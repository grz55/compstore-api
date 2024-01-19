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
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProcessorBrandServiceImpl implements IProcessorBrandService {

    private static final String PROCESSOR_BRAND_NOT_FOUND_MSG =
            "Processor brand not found with id: ";

    private final ProcessorBrandMapper processorBrandMapper;

    private final ProcessorBrandRepository processorBrandRepository;

    private final ProcessorBrandValidator processorBrandValidator;

    @Override
    public List<ProcessorBrandDTO> getAllProcessorBrands() {
        return processorBrandRepository.findAll().stream()
                .map(processorBrandMapper::toDTO)
                .toList();
    }

    @Override
    public void createProcessorBrand(
            ProcessorBrandCreateRequestDTO processorBrandCreateRequestDTO) {
        ProcessorBrandEntity processorBrandEntity =
                processorBrandMapper.toEntity(processorBrandCreateRequestDTO);
        processorBrandRepository.save(processorBrandEntity);
    }

    @Override
    public void updateProcessorBrand(
            UUID processorBrandId, ProcessorBrandCreateRequestDTO processorBrandUpdateRequest) {
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
        return processorBrandMapper.toProcessorBrandComboDataDTO(ProcessorBrandDeviceType.values());
    }
}
