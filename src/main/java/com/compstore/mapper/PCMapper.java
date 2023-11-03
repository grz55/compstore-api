package com.compstore.mapper;

import com.compstore.dto.pc.PCDTO;
import com.compstore.entity.enums.PCDriveType;
import com.compstore.entity.pc.PCEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PCMapper {

    @Mapping(target = "processorBrand", source = "processorBrand.name")
    @Mapping(target = "graphicsCardBrand", source = "graphicsCardBrand.name")
    @Mapping(target = "operatingSystem", source = "operatingSystem.name")
    PCDTO toDTO(PCEntity pcEntity);

    default String driveTypeToString(PCDriveType pcDriveType) {
        return pcDriveType.getValue();
    }
}
