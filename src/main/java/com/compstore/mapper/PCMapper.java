package com.compstore.mapper;

import com.compstore.dto.pc.PCComboDataDTO;
import com.compstore.dto.pc.PCCreateRequestDTO;
import com.compstore.dto.pc.PCDTO;
import com.compstore.dto.pc.PCSimpleDTO;
import com.compstore.entity.dictionary.GraphicsCardBrandEntity;
import com.compstore.entity.dictionary.ProcessorBrandEntity;
import com.compstore.entity.pc.PCEntity;
import com.compstore.entity.pc.PCOperatingSystemEntity;
import com.compstore.entity.pc.enums.DriveCapacity;
import com.compstore.entity.pc.enums.DriveType;
import com.compstore.entity.pc.enums.RAMCapacity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface PCMapper {

    PCDTO toDTO(PCEntity pcEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "processorBrand", ignore = true)
    @Mapping(target = "graphicsCardBrand", ignore = true)
    @Mapping(target = "operatingSystem", ignore = true)
    @Mapping(target = "description", ignore = true)
    PCEntity toEntity(PCCreateRequestDTO pcCreateRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "processorBrand", ignore = true)
    @Mapping(target = "graphicsCardBrand", ignore = true)
    @Mapping(target = "operatingSystem", ignore = true)
    @Mapping(target = "description", ignore = true)
    void toEntity(PCCreateRequestDTO pcUpdateRequest, @MappingTarget PCEntity existingPC);

    PCComboDataDTO toPCComboDataDTO(
            List<ProcessorBrandEntity> processorBrands,
            List<GraphicsCardBrandEntity> graphicsCardBrands,
            RAMCapacity[] ramCapacities,
            DriveCapacity[] driveCapacities,
            DriveType[] driveTypes,
            List<PCOperatingSystemEntity> operatingSystems);

    PCSimpleDTO toPCSimpleDTO(PCEntity pcEntity);

    List<PCSimpleDTO> toPCSimpleDTOList(List<PCEntity> pcs);

    default DriveType toDriveType(String driveType) {
        return DriveType.fromValue(driveType);
    }

    default RAMCapacity toRAMCapacity(String ramCapacity) {
        return RAMCapacity.fromValue(ramCapacity);
    }

    default DriveCapacity toDriveCapacity(String driveCapacity) {
        return DriveCapacity.fromValue(driveCapacity);
    }

    default String toString(DriveType driveType) {
        return driveType.getValue();
    }

    default String toString(RAMCapacity ramCapacity) {
        return ramCapacity.getValue();
    }

    default String toString(DriveCapacity driveCapacity) {
        return driveCapacity.getValue();
    }
}
