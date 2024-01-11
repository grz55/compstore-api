package com.compstore.mapper;

import com.compstore.dto.tv.TVDTO;
import com.compstore.entity.enums.Color;
import com.compstore.entity.tv.TVEntity;
import com.compstore.entity.tv.enums.RefreshRate;
import com.compstore.entity.tv.enums.ResolutionName;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TVMapper {

    @Mapping(target = "brand", source = "brand.name")
    @Mapping(target = "screenType", source = "screenType.name")
    TVDTO toDTO(TVEntity tvEntity);

    default String colorToString(Color color) {
        return color.getValue();
    }

    default String tvResolutionNameToString(ResolutionName resolutionName) {
        return resolutionName.getValue();
    }

    default Integer refreshRateToString(RefreshRate refreshRate) {
        return refreshRate.getValue();
    }
}
