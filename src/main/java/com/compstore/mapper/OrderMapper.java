package com.compstore.mapper;

import com.compstore.dto.order.OrderCreateResponseDTO;
import com.compstore.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface OrderMapper {

    OrderCreateResponseDTO toOrderCreateResponseDTO(OrderEntity orderEntity);
}
