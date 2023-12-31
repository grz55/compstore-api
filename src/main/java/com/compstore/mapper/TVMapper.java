package com.compstore.mapper;

import com.compstore.dto.tv.TVDTO;
import com.compstore.entity.enums.Color;
import com.compstore.entity.enums.TVRefreshRate;
import com.compstore.entity.enums.TVResolutionName;
import com.compstore.entity.tv.TVEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TVMapper {

    @Mapping(target = "tvBrand", source = "tvBrand.name")
    @Mapping(target = "screenType", source = "screenType.name")
    TVDTO toDTO(TVEntity tvEntity);

    default String colorToString(Color color) {
        return color.getValue();
    }

    default String tvResolutionNameToString(TVResolutionName tvResolutionName) {
        return tvResolutionName.getValue();
    }

    default Integer refreshRateToString(TVRefreshRate tvRefreshRate) {
        return tvRefreshRate.getValue();
    }
}
