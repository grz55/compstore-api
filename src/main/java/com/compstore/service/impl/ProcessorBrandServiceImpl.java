package com.compstore.service.impl;

import com.compstore.dto.dictionary.ProcessorBrandComboDataDTO;
import com.compstore.dto.dictionary.ProcessorBrandCreateRequestDTO;
import com.compstore.dto.dictionary.ProcessorBrandDTO;
import com.compstore.entity.dictionary.ProcessorBrandEntity;
import com.compstore.entity.dictionary.enums.ProcessorBrandDeviceType;
import com.compstore.exception.NotFoundException;
import com.compstore.mapper.ProcessorBrandMapper;
import com.compstore.repository.ProcessorBrandRepository;
import com.compstore.service.IProcessorBrandService;
import com.compstore.validator.ProcessorBrandValidator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ProcessorBrandServiceImpl implements IProcessorBrandService {

    private static final String PROCESSOR_BRAND_NOT_FOUND_MSG =
            "Processor brand not found with id: ";

    private final ProcessorBrandMapper processorBrandMapper;

    private final ProcessorBrandRepository processorBrandRepository;

    private final ProcessorBrandValidator processorBrandValidator;

    @Override
    public List<ProcessorBrandDTO> getAllProcessorBrands() {
        log.info("Requested getting all processor brands");
        return processorBrandRepository.findAll().stream()
                .map(processorBrandMapper::toDTO)
                .toList();
    }

    @Override
    public ProcessorBrandDTO getProcessorBrandById(UUID processorBrandId) {
        log.info("Requested getting a processor brand with id: {}", processorBrandId);
        return processorBrandRepository
                .findById(processorBrandId)
                .map(processorBrandMapper::toDTO)
                .orElseThrow(
                        () ->
                                new NotFoundException(
                                        PROCESSOR_BRAND_NOT_FOUND_MSG + processorBrandId));
    }

    @Override
    public void createProcessorBrand(
            ProcessorBrandCreateRequestDTO processorBrandCreateRequestDTO) {
        log.info(
                "Requested creating a processor brand with name: {}",
                processorBrandCreateRequestDTO.getName());
        ProcessorBrandEntity processorBrandEntity =
                processorBrandMapper.toEntity(processorBrandCreateRequestDTO);
        processorBrandRepository.save(processorBrandEntity);
    }

    @Override
    public void updateProcessorBrand(
            UUID processorBrandId, ProcessorBrandCreateRequestDTO processorBrandUpdateRequest) {
        log.info("Requested updating a processor brand with id: {}", processorBrandId);
        Optional<ProcessorBrandEntity> processorBrandById =
                processorBrandRepository.findById(processorBrandId);
        if (processorBrandById.isPresent()) {
            ProcessorBrandEntity existingProcessorBrand = processorBrandById.get();
            processorBrandMapper.toEntity(processorBrandUpdateRequest, existingProcessorBrand);
            processorBrandRepository.save(existingProcessorBrand);
        } else {
            throw new NotFoundException(PROCESSOR_BRAND_NOT_FOUND_MSG + processorBrandId);
        }
    }

    @Override
    public void deleteProcessorBrandById(UUID processorBrandId) {
        log.info("Requested deleting a processor brand with id: {}", processorBrandId);
        Optional<ProcessorBrandEntity> processorBrandById =
                processorBrandRepository.findById(processorBrandId);
        if (processorBrandById.isPresent()) {
            processorBrandValidator.validateDelete(processorBrandById.get());
            processorBrandRepository.delete(processorBrandById.get());
        } else {
            throw new NotFoundException(PROCESSOR_BRAND_NOT_FOUND_MSG + processorBrandId);
        }
    }

    @Override
    public ProcessorBrandComboDataDTO getProcessorBrandComboData() {
        log.info("Requested getting processor brand's combo data");
        return processorBrandMapper.toProcessorBrandComboDataDTO(ProcessorBrandDeviceType.values());
    }
}
