package com.compstore.mapper;

import com.compstore.dto.smartphone.SmartphoneDTO;
import com.compstore.entity.enums.Color;
import com.compstore.entity.smartphone.SmartphoneEntity;
import com.compstore.entity.smartphone.enums.RAMCapacity;
import com.compstore.entity.smartphone.enums.StorageCapacity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface SmartphoneMapper {

    SmartphoneDTO toDTO(SmartphoneEntity smartphoneEntity);

    default String colorToString(Color color) {
        return color.getValue();
    }

    default String ramCapacityToString(RAMCapacity ramCapacity) {
        return ramCapacity.getValue();
    }

    default String storageCapacityToString(StorageCapacity storageCapacity) {
        return storageCapacity.getValue();
    }
}
