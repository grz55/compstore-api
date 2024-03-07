package com.compstore.service;

import com.compstore.dto.order.OrderCreateRequestDTO;
import com.compstore.dto.order.OrderCreateResponseDTO;
import java.util.UUID;

public interface IOrderService {

    OrderCreateResponseDTO createOrder(OrderCreateRequestDTO orderCreateRequest);

    void deleteOrderById(UUID orderId);
}
