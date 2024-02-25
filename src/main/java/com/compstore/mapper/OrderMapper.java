package com.compstore.mapper;

import com.compstore.dto.order.OrderCreateResponseDTO;
import com.compstore.dto.order.OrderItemDetailsDTO;
import com.compstore.entity.OrderEntity;
import com.compstore.entity.OrderProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = ProductMapper.class)
public interface OrderMapper {

    @Mapping(target = "orderItems", source = "orderProducts")
    OrderCreateResponseDTO toOrderCreateResponseDTO(OrderEntity orderEntity);

    OrderItemDetailsDTO toOrderItemDetailsDTO(OrderProductEntity orderProductEntity);
}
