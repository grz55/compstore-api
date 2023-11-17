package com.compstore.mapper;

import com.compstore.dto.pc.PCComboDataDTO;
import com.compstore.dto.pc.PCCreateRequestDTO;
import com.compstore.dto.pc.PCDTO;
import com.compstore.entity.enums.PCDriveType;
import com.compstore.entity.pc.PCEntity;
import com.compstore.entity.pc.PCGraphicsCardBrandEntity;
import com.compstore.entity.pc.PCOperatingSystemEntity;
import com.compstore.entity.pc.PCProcessorBrandEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PCMapper {

    @Mapping(target = "processorBrand", source = "processorBrand.name")
    @Mapping(target = "graphicsCardBrand", source = "graphicsCardBrand.name")
    @Mapping(target = "operatingSystem", source = "operatingSystem.name")
    PCDTO toDTO(PCEntity pcEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "processorBrand", ignore = true)
    @Mapping(target = "graphicsCardBrand", ignore = true)
    @Mapping(target = "operatingSystem", ignore = true)
    PCEntity toEntity(PCCreateRequestDTO pcCreateRequest);

    PCComboDataDTO toPCComboDataDTO(
            List<PCProcessorBrandEntity> processorBrands,
            List<PCGraphicsCardBrandEntity> graphicsCardBrands,
            PCDriveType[] driveTypes,
            List<PCOperatingSystemEntity> operatingSystems);

    default PCDriveType toPCDriveType(String driveType) {
        return PCDriveType.fromValue(driveType);
    }

    default String toString(PCDriveType pcDriveType) {
        return pcDriveType.getValue();
    }
}
