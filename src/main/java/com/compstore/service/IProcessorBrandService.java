package com.compstore.service;

import com.compstore.dto.dictionary.ProcessorBrandComboDataDTO;
import com.compstore.dto.dictionary.ProcessorBrandCreateRequestDTO;
import com.compstore.dto.dictionary.ProcessorBrandDTO;
import java.util.List;
import java.util.UUID;

public interface IProcessorBrandService {

    void createProcessorBrand(ProcessorBrandCreateRequestDTO processorBrandCreateRequestDTO);

    List<ProcessorBrandDTO> getAllProcessorBrands();

    ProcessorBrandDTO getProcessorBrandById(UUID processorBrandId);

    void updateProcessorBrand(
            UUID processorBrandId, ProcessorBrandCreateRequestDTO processorBrandUpdateRequest);

    void deleteProcessorBrandById(UUID processorBrandId);

    ProcessorBrandComboDataDTO getProcessorBrandComboData();
}
