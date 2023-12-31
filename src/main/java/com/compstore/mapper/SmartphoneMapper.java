package com.compstore.mapper;

import com.compstore.dto.smartphone.SmartphoneDTO;
import com.compstore.entity.enums.Color;
import com.compstore.entity.smartphone.SmartphoneEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface SmartphoneMapper {

    @Mapping(target = "brand", source = "smartphoneBrand.name")
    @Mapping(target = "smartphoneScreenType", source = "smartphoneScreenType.name")
    @Mapping(target = "operatingSystem", source = "operatingSystem.name")
    @Mapping(target = "processorBrand", source = "processorBrand.name")
    SmartphoneDTO toDTO(SmartphoneEntity smartphoneEntity);

    default String colorToString(Color color) {
        return color.getValue();
    }
}
