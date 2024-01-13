package com.compstore.mapper;

import com.compstore.dto.dictionary.ProcessorBrandComboDataDTO;
import com.compstore.dto.dictionary.ProcessorBrandCreateRequestDTO;
import com.compstore.dto.dictionary.ProcessorBrandDTO;
import com.compstore.entity.ProcessorBrandDeviceType;
import com.compstore.entity.ProcessorBrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProcessorBrandMapper {

    @Mapping(target = "id", ignore = true)
    ProcessorBrandEntity toEntity(ProcessorBrandCreateRequestDTO processorBrandCreateRequestDTO);

    ProcessorBrandDTO toDTO(ProcessorBrandEntity processorBrandEntity);

    @Mapping(target = "id", ignore = true)
    void toEntity(
            ProcessorBrandCreateRequestDTO processorBrandUpdateRequest,
            @MappingTarget ProcessorBrandEntity existingProcessorBrand);

    ProcessorBrandComboDataDTO toProcessorBrandComboDataDTO(
            ProcessorBrandDeviceType[] processorBrandDeviceTypes);

    default ProcessorBrandDeviceType toProcessorBrandDeviceType(String processorBrandDeviceType) {
        return ProcessorBrandDeviceType.fromValue(processorBrandDeviceType);
    }

    default String toString(ProcessorBrandDeviceType processorBrandDeviceType) {
        return processorBrandDeviceType.getValue();
    }
}
