package com.compstore.mapper;

import com.compstore.dto.pc.PCComboDataDTO;
import com.compstore.dto.pc.PCCreateRequestDTO;
import com.compstore.dto.pc.PCDTO;
import com.compstore.dto.pc.PCSimpleDTO;
import com.compstore.entity.enums.DriveGBCapacity;
import com.compstore.entity.enums.PCDriveType;
import com.compstore.entity.enums.RAMGBCapacity;
import com.compstore.entity.pc.PCEntity;
import com.compstore.entity.pc.PCGraphicsCardBrandEntity;
import com.compstore.entity.pc.PCOperatingSystemEntity;
import com.compstore.entity.pc.PCProcessorBrandEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
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

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "processorBrand", ignore = true)
    @Mapping(target = "graphicsCardBrand", ignore = true)
    @Mapping(target = "operatingSystem", ignore = true)
    void toEntity(PCCreateRequestDTO pcUpdateRequest, @MappingTarget PCEntity existingPC);

    PCComboDataDTO toPCComboDataDTO(
            List<PCProcessorBrandEntity> processorBrands,
            List<PCGraphicsCardBrandEntity> graphicsCardBrands,
            RAMGBCapacity[] ramGBCapacities,
            DriveGBCapacity[] driveGBCapacities,
            PCDriveType[] driveTypes,
            List<PCOperatingSystemEntity> operatingSystems);

    PCSimpleDTO toPCSimpleDTO(PCEntity pcEntity);

    List<PCSimpleDTO> toPCSimpleDTOList(List<PCEntity> pcs);

    default PCDriveType toPCDriveType(String driveType) {
        return PCDriveType.fromValue(driveType);
    }

    default RAMGBCapacity toRAMGBCapacity(String ramGBCapacity) {
        return RAMGBCapacity.fromValue(ramGBCapacity);
    }

    default DriveGBCapacity toDriveGBCapacity(String driveGBCapacity) {
        return DriveGBCapacity.fromValue(driveGBCapacity);
    }

    default String toString(PCDriveType pcDriveType) {
        return pcDriveType.getValue();
    }

    default String toString(RAMGBCapacity ramGBCapacity) {
        return ramGBCapacity.getValue();
    }

    default String toString(DriveGBCapacity driveGBCapacity) {
        return driveGBCapacity.getValue();
    }
}
