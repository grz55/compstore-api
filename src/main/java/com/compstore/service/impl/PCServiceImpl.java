package com.compstore.service.impl;

import com.compstore.dto.pc.PCComboDataDTO;
import com.compstore.dto.pc.PCCreateRequestDTO;
import com.compstore.dto.pc.PCDTO;
import com.compstore.dto.pc.PCFilteringRequestDTO;
import com.compstore.dto.pc.PCFilteringResponseDTO;
import com.compstore.entity.dictionary.GraphicsCardBrandEntity;
import com.compstore.entity.dictionary.ProcessorBrandEntity;
import com.compstore.entity.dictionary.enums.GraphicsCardBrandDeviceType;
import com.compstore.entity.dictionary.enums.ProcessorBrandDeviceType;
import com.compstore.entity.pc.*;
import com.compstore.entity.pc.enums.DriveCapacity;
import com.compstore.entity.pc.enums.DriveType;
import com.compstore.entity.pc.enums.RAMCapacity;
import com.compstore.exception.NotFoundException;
import com.compstore.mapper.PCMapper;
import com.compstore.mapper.PagingAndSortingMapper;
import com.compstore.repository.GraphicsCardBrandRepository;
import com.compstore.repository.ProcessorBrandRepository;
import com.compstore.repository.pc.*;
import com.compstore.service.IPCService;
import com.compstore.validator.PCValidator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@Slf4j
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
    private final ProcessorBrandRepository processorBrandRepository;
    private final GraphicsCardBrandRepository graphicsCardBrandRepository;
    private final PCOperatingSystemRepository pcOperatingSystemRepository;

    private final PCValidator pcValidator;

    @Override
    public PCDTO getPCById(UUID pcId) {
        log.info("Requested getting a PC with id: {}", pcId);
        return pcRepository
                .findById(pcId)
                .map(pcMapper::toDTO)
                .orElseThrow(() -> new NotFoundException(PC_NOT_FOUND_MSG + pcId));
    }

    @Override
    public PCFilteringResponseDTO searchPC(PCFilteringRequestDTO pcFilteringRequestDTO) {
        log.info("Requested searching PCs");
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
        log.info("Requested creating a PC");
        PCEntity pcEntity = pcMapper.toEntity(pcCreateRequest);
        fetchPCRelatedEntities(pcEntity, pcCreateRequest);
        preparePCDescription(pcEntity);
        PCEntity savedPc = pcRepository.save(pcEntity);
        return pcMapper.toDTO(savedPc);
    }

    @Override
    public PCDTO updatePC(UUID pcId, PCCreateRequestDTO pcUpdateRequest) {
        log.info("Requested updating a PC with id: {}", pcId);
        Optional<PCEntity> pcById = pcRepository.findById(pcId);
        if (pcById.isPresent()) {
            PCEntity existingPC = pcById.get();
            pcMapper.toEntity(pcUpdateRequest, existingPC);
            fetchPCRelatedEntities(existingPC, pcUpdateRequest);
            preparePCDescription(existingPC);
            PCEntity updatedPc = pcRepository.save(existingPC);
            return pcMapper.toDTO(updatedPc);
        } else {
            throw new NotFoundException(PC_NOT_FOUND_MSG + pcId);
        }
    }

    @Override
    public void deletePCById(UUID pcId) {
        log.info("Requested deleting a PC with id: {}", pcId);
        Optional<PCEntity> pcById = pcRepository.findById(pcId);
        if (pcById.isPresent()) {
            pcValidator.validateDelete(pcById.get());
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

    private void fetchPCProcessorBrand(PCEntity pcEntity, UUID processorBrandUUID) {
        Optional<ProcessorBrandEntity> processorBrandById =
                processorBrandRepository.findByIdAndProcessorBrandDeviceType(
                        processorBrandUUID, ProcessorBrandDeviceType.PC);
        if (processorBrandById.isPresent()) {
            pcEntity.setProcessorBrand(processorBrandById.get());
        } else {
            throw new NotFoundException(PC_PROCESSOR_BRAND_NOT_FOUND_MSG + processorBrandUUID);
        }
    }

    private void fetchPCGraphicsCardBrand(PCEntity pcEntity, UUID graphicsCardBrandUUID) {
        Optional<GraphicsCardBrandEntity> pcGraphicsCardBrandById =
                graphicsCardBrandRepository.findByIdAndGraphicsCardBrandDeviceType(
                        graphicsCardBrandUUID, GraphicsCardBrandDeviceType.PC);
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

    private void preparePCDescription(PCEntity pcEntity) {
        String processorName = pcEntity.getProcessorName();
        String ramCapacity = pcEntity.getRamCapacity().getValue();
        String graphicsCardName = pcEntity.getGraphicsCardName();
        String driveCapacity = pcEntity.getDriveCapacity().getValue();
        String driveType = pcEntity.getDriveType().getValue();
        String operatingSystem = pcEntity.getOperatingSystem().getName();

        String description =
                processorName
                        + " - "
                        + ramCapacity
                        + " RAM - "
                        + graphicsCardName
                        + " - "
                        + driveCapacity
                        + " "
                        + driveType
                        + " - "
                        + operatingSystem;

        pcEntity.setDescription(description);
    }

    @Override
    public PCComboDataDTO getPCComboData() {
        log.info("Requested getting PC's combo data");
        List<ProcessorBrandEntity> allPCProcessorBrands = fetchAllPCProcessorBrands();
        List<GraphicsCardBrandEntity> allPCGraphicsCardBrands = fetchAllPCGraphicsCardBrands();
        List<PCOperatingSystemEntity> allPCOperatingSystems = fetchAllPCOperatingSystems();
        return pcMapper.toPCComboDataDTO(
                allPCProcessorBrands,
                allPCGraphicsCardBrands,
                RAMCapacity.values(),
                DriveCapacity.values(),
                DriveType.values(),
                allPCOperatingSystems);
    }

    private List<ProcessorBrandEntity> fetchAllPCProcessorBrands() {
        return processorBrandRepository.findByProcessorBrandDeviceType(ProcessorBrandDeviceType.PC);
    }

    private List<GraphicsCardBrandEntity> fetchAllPCGraphicsCardBrands() {
        return graphicsCardBrandRepository.findByGraphicsCardBrandDeviceType(
                GraphicsCardBrandDeviceType.PC);
    }

    private List<PCOperatingSystemEntity> fetchAllPCOperatingSystems() {
        return pcOperatingSystemRepository.findAll();
    }
}
