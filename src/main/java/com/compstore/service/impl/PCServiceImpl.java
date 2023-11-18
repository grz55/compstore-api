package com.compstore.service.impl;

import com.compstore.dto.PagingAndSortingMetadataDTO;
import com.compstore.dto.pc.PCComboDataDTO;
import com.compstore.dto.pc.PCCreateRequestDTO;
import com.compstore.dto.pc.PCDTO;
import com.compstore.dto.pc.PCFilteringRequestDTO;
import com.compstore.dto.pc.PCFilteringResponseDTO;
import com.compstore.dto.pc.PCSimpleDTO;
import com.compstore.entity.enums.PCDriveType;
import com.compstore.entity.pc.PCEntity;
import com.compstore.entity.pc.PCGraphicsCardBrandEntity;
import com.compstore.entity.pc.PCOperatingSystemEntity;
import com.compstore.entity.pc.PCProcessorBrandEntity;
import com.compstore.exception.NotFoundException;
import com.compstore.mapper.PCMapper;
import com.compstore.repository.pc.*;
import com.compstore.service.IPCService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PCServiceImpl implements IPCService {

    private final PCMapper pcMapper;
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
            throw new NotFoundException("PC not found with id: " + pcId);
        }
    }

    @Override
    public PCFilteringResponseDTO searchPC(PCFilteringRequestDTO pcFilteringRequestDTO) {
        Pageable pageRequest =
                pcFilteringRequestDTO.getPagingAndSortingRequest() != null
                        ? PageRequest.of(
                                pcFilteringRequestDTO.getPagingAndSortingRequest().getPageNumber(),
                                pcFilteringRequestDTO.getPagingAndSortingRequest().getPageSize())
                        : PageRequest.of(0, 10);

        Page<PCEntity> pcsFound =
                pcRepository.findAll(PCSpecification.filterPC(pcFilteringRequestDTO), pageRequest);

        List<PCEntity> pcs = pcsFound.getContent();
        List<PCSimpleDTO> simplePCs = pcMapper.toPCSimpleDTOList(pcs);

        PagingAndSortingMetadataDTO pagingAndSortingMetadataDTO = new PagingAndSortingMetadataDTO();
        pagingAndSortingMetadataDTO.setPageNumber(pcsFound.getNumber());
        pagingAndSortingMetadataDTO.setPageSize(pcsFound.getSize());
        pagingAndSortingMetadataDTO.setPagesCount(pcsFound.getTotalPages());
        pagingAndSortingMetadataDTO.setElementsCount(pcsFound.getNumberOfElements());

        PCFilteringResponseDTO pcFilteringResponseDTO = new PCFilteringResponseDTO();
        pcFilteringResponseDTO.setPcs(simplePCs);
        pcFilteringResponseDTO.setPagingAndSortingMetadata(pagingAndSortingMetadataDTO);
        return pcFilteringResponseDTO;
    }

    @Override
    public PCDTO createPC(PCCreateRequestDTO pcCreateRequest) {
        PCEntity pcEntity = pcMapper.toEntity(pcCreateRequest);
        fetchPCRelatedEntities(pcEntity, pcCreateRequest);
        PCEntity savedPc = pcRepository.save(pcEntity);
        return pcMapper.toDTO(savedPc);
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
            throw new NotFoundException(
                    "PC processor brand not found with id: " + pcProcessorBrandUUID);
        }
    }

    private void fetchPCGraphicsCardBrand(PCEntity pcEntity, UUID graphicsCardBrandUUID) {
        Optional<PCGraphicsCardBrandEntity> pcGraphicsCardBrandById =
                pcGraphicsCardBrandRepository.findById(graphicsCardBrandUUID);
        if (pcGraphicsCardBrandById.isPresent()) {
            pcEntity.setGraphicsCardBrand(pcGraphicsCardBrandById.get());
        } else {
            throw new NotFoundException(
                    "PC graphics card brand not found with id: " + graphicsCardBrandUUID);
        }
    }

    private void fetchPCOperatingSystem(PCEntity pcEntity, UUID operatingSystemUUID) {
        Optional<PCOperatingSystemEntity> pcOperatingSystemById =
                pcOperatingSystemRepository.findById(operatingSystemUUID);
        if (pcOperatingSystemById.isPresent()) {
            pcEntity.setOperatingSystem(pcOperatingSystemById.get());
        } else {
            throw new NotFoundException(
                    "PC operating system not found with id: " + operatingSystemUUID);
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
