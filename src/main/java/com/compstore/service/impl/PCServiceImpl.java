package com.compstore.service.impl;

import com.compstore.dto.pc.PCComboDataDTO;
import com.compstore.dto.pc.PCCreateRequestDTO;
import com.compstore.dto.pc.PCDTO;
import com.compstore.dto.pc.PCFilteringRequestDTO;
import com.compstore.dto.pc.PCFilteringResponseDTO;
import com.compstore.entity.enums.PCDriveType;
import com.compstore.entity.pc.*;
import com.compstore.exception.NotFoundException;
import com.compstore.mapper.PCMapper;
import com.compstore.mapper.PagingAndSortingMapper;
import com.compstore.repository.pc.*;
import com.compstore.service.IPCService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PCServiceImpl implements IPCService {

    private static final String PC_NOT_FOUND_MSG = "PC not found with id: ";
    private static final String PC_PROCESSOR_BRAND_NOT_FOUND_MSG =
            "PC processor brand not found with id: ";
    private static final String PC_GRAPHICS_CARD_BRAND_NOT_FOUND_MSG =
            "PC graphics card brand not found with id: ";
    private static final String PC_OPERATING_SYSTEM_NOT_FOUND_MSG =
            "PC operating system not found with id: ";

    private final PCMapper pcMapper;
    private final PagingAndSortingMapper pagingAndSortingMapper;

    private final PCRepository pcRepository;
    private final PCProcessorBrandRepository pcProcessorBrandRepository;
    private final PCGraphicsCardBrandRepository pcGraphicsCardBrandRepository;
    private final PCOperatingSystemRepository pcOperatingSystemRepository;

    @Override
    public PCDTO getPCById(UUID pcId) {
        Optional<PCEntity> pcById = pcRepository.findById(pcId);
        if (pcById.isPresent()) {
            return pcMapper.toDTO(pcById.get());
        } else {
            throw new NotFoundException(PC_NOT_FOUND_MSG + pcId);
        }
    }

    @Override
    public PCFilteringResponseDTO searchPC(PCFilteringRequestDTO pcFilteringRequestDTO) {
        Page<PCEntity> pcsFound =
                pcRepository.findAll(
                        PCSpecification.filterPC(pcFilteringRequestDTO),
                        pagingAndSortingMapper.toPageable(
                                pcFilteringRequestDTO.getPagingAndSortingRequest()));

        return PCFilteringResponseDTO.builder()
                .pcs(pcMapper.toPCSimpleDTOList(pcsFound.getContent()))
                .pagingAndSortingMetadata(
                        pagingAndSortingMapper.toPagingAndSortingMetadataDTO(pcsFound))
                .build();
    }

    @Override
    public PCDTO createPC(PCCreateRequestDTO pcCreateRequest) {
        PCEntity pcEntity = pcMapper.toEntity(pcCreateRequest);
        fetchPCRelatedEntities(pcEntity, pcCreateRequest);
        PCEntity savedPc = pcRepository.save(pcEntity);
        return pcMapper.toDTO(savedPc);
    }

    @Override
    public PCDTO updatePC(UUID pcId, PCCreateRequestDTO pcUpdateRequest) {
        Optional<PCEntity> pcById = pcRepository.findById(pcId);
        if (pcById.isPresent()) {
            PCEntity existingPC = pcById.get();
            pcMapper.toEntity(pcUpdateRequest, existingPC);
            fetchPCRelatedEntities(existingPC, pcUpdateRequest);
            PCEntity updatedPc = pcRepository.save(existingPC);
            return pcMapper.toDTO(updatedPc);
        } else {
            throw new NotFoundException(PC_NOT_FOUND_MSG + pcId);
        }
    }

    @Override
    public void deletePCById(UUID pcId) {
        Optional<PCEntity> pcById = pcRepository.findById(pcId);
        if (pcById.isPresent()) {
            pcRepository.delete(pcById.get());
        } else {
            throw new NotFoundException(PC_NOT_FOUND_MSG + pcId);
        }
    }

    private void fetchPCRelatedEntities(PCEntity pcEntity, PCCreateRequestDTO pcCreateRequest) {
        fetchPCProcessorBrand(pcEntity, pcCreateRequest.getProcessorBrand());
        fetchPCGraphicsCardBrand(pcEntity, pcCreateRequest.getGraphicsCardBrand());
        fetchPCOperatingSystem(pcEntity, pcCreateRequest.getOperatingSystem());
    }

    private void fetchPCProcessorBrand(PCEntity pcEntity, UUID pcProcessorBrandUUID) {
        Optional<PCProcessorBrandEntity> pcProcessorBrandById =
                pcProcessorBrandRepository.findById(pcProcessorBrandUUID);
        if (pcProcessorBrandById.isPresent()) {
            pcEntity.setProcessorBrand(pcProcessorBrandById.get());
        } else {
            throw new NotFoundException(PC_PROCESSOR_BRAND_NOT_FOUND_MSG + pcProcessorBrandUUID);
        }
    }

    private void fetchPCGraphicsCardBrand(PCEntity pcEntity, UUID graphicsCardBrandUUID) {
        Optional<PCGraphicsCardBrandEntity> pcGraphicsCardBrandById =
                pcGraphicsCardBrandRepository.findById(graphicsCardBrandUUID);
        if (pcGraphicsCardBrandById.isPresent()) {
            pcEntity.setGraphicsCardBrand(pcGraphicsCardBrandById.get());
        } else {
            throw new NotFoundException(
                    PC_GRAPHICS_CARD_BRAND_NOT_FOUND_MSG + graphicsCardBrandUUID);
        }
    }

    private void fetchPCOperatingSystem(PCEntity pcEntity, UUID operatingSystemUUID) {
        Optional<PCOperatingSystemEntity> pcOperatingSystemById =
                pcOperatingSystemRepository.findById(operatingSystemUUID);
        if (pcOperatingSystemById.isPresent()) {
            pcEntity.setOperatingSystem(pcOperatingSystemById.get());
        } else {
            throw new NotFoundException(PC_OPERATING_SYSTEM_NOT_FOUND_MSG + operatingSystemUUID);
        }
    }

    @Override
    public PCComboDataDTO getPCComboData() {
        List<PCProcessorBrandEntity> allPCProcessorBrands = fetchAllPCProcessorBrands();
        List<PCGraphicsCardBrandEntity> allPCGraphicsCardBrands = fetchAllPCGraphicsCardBrands();
        List<PCOperatingSystemEntity> allPCOperatingSystems = fetchAllPCOperatingSystems();
        return pcMapper.toPCComboDataDTO(
                allPCProcessorBrands,
                allPCGraphicsCardBrands,
                PCDriveType.values(),
                allPCOperatingSystems);
    }

    private List<PCProcessorBrandEntity> fetchAllPCProcessorBrands() {
        return pcProcessorBrandRepository.findAll();
    }

    private List<PCGraphicsCardBrandEntity> fetchAllPCGraphicsCardBrands() {
        return pcGraphicsCardBrandRepository.findAll();
    }

    private List<PCOperatingSystemEntity> fetchAllPCOperatingSystems() {
        return pcOperatingSystemRepository.findAll();
    }
}
