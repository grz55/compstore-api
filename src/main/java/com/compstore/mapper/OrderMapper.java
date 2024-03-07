package com.compstore.mapper;

import com.compstore.dto.order.OrderCreateResponseDTO;
import com.compstore.dto.order.OrderItemDetailsDTO;
import com.compstore.entity.OrderEntity;
import com.compstore.entity.OrderItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = ProductMapper.class)
public interface OrderMapper {

    OrderCreateResponseDTO toOrderCreateResponseDTO(OrderEntity orderEntity);

    OrderItemDetailsDTO toOrderItemDetailsDTO(OrderItemEntity orderItemEntity);
}
