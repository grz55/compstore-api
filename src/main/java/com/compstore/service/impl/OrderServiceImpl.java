package com.compstore.service.impl;

import com.compstore.dto.order.OrderCreateRequestDTO;
import com.compstore.dto.order.OrderCreateResponseDTO;
import com.compstore.dto.order.OrderItemDTO;
import com.compstore.entity.OrderEntity;
import com.compstore.entity.OrderItemEntity;
import com.compstore.entity.ProductEntity;
import com.compstore.exception.NotFoundException;
import com.compstore.mapper.OrderMapper;
import com.compstore.repository.OrderRepository;
import com.compstore.repository.ProductRepository;
import com.compstore.service.IOrderService;
import com.compstore.validator.OrderValidator;
import com.compstore.validator.ProductValidator;
import java.math.BigDecimal;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private static final String ORDER_NOT_FOUND_MSG = "Order not found with id: ";

    private final OrderMapper orderMapper;

    private final OrderRepository orderRepository;
    private final ProductRepository<ProductEntity> productRepository;

    private final OrderValidator orderValidator;
    private final ProductValidator productValidator;

    @Override
    public OrderCreateResponseDTO createOrder(OrderCreateRequestDTO orderCreateRequest) {

        orderValidator.validateEmptyOrder(orderCreateRequest.getOrderItems());
        Map<UUID, Integer> itemQuantities = mergeOrderItemQuantities(orderCreateRequest);

        log.info("Requested creating an order with ids: {}", itemQuantities.keySet());

        List<ProductEntity> productsFound = productRepository.findByIdIn(itemQuantities.keySet());
        productValidator.validateProductsExist(itemQuantities.keySet(), productsFound);

        OrderEntity newOrder = prepareOrderFromProducts(itemQuantities, productsFound);

        OrderEntity savedOrder = orderRepository.save(newOrder);
        return orderMapper.toOrderCreateResponseDTO(savedOrder);
    }

    @Override
    public void deleteOrderById(UUID orderId) {
        log.info("Requested deleting an order with id: {}", orderId);
        Optional<OrderEntity> orderById = orderRepository.findById(orderId);
        if (orderById.isPresent()) {
            orderRepository.delete(orderById.get());
        } else {
            throw new NotFoundException(ORDER_NOT_FOUND_MSG + orderId);
        }
    }

    private Map<UUID, Integer> mergeOrderItemQuantities(OrderCreateRequestDTO orderCreateRequest) {
        Map<UUID, Integer> itemQuantities = new HashMap<>();
        for (OrderItemDTO orderItemDTO : orderCreateRequest.getOrderItems()) {
            UUID orderItemUUID = orderItemDTO.getProduct();
            Integer quantity = itemQuantities.getOrDefault(orderItemUUID, 0);
            itemQuantities.put(orderItemUUID, quantity + orderItemDTO.getQuantity());
        }
        return itemQuantities;
    }

    private OrderEntity prepareOrderFromProducts(
            Map<UUID, Integer> itemQuantities, List<ProductEntity> productsFound) {
        OrderEntity newOrder = new OrderEntity();

        List<OrderItemEntity> orderProducts =
                productsFound.stream()
                        .map(
                                product ->
                                        new OrderItemEntity(
                                                newOrder,
                                                product,
                                                itemQuantities.get(product.getId())))
                        .toList();

        BigDecimal finalOrderPrice = calculateFinalOrderPrice(itemQuantities, productsFound);

        newOrder.setOrderItems(orderProducts);
        newOrder.setPrice(finalOrderPrice);
        return newOrder;
    }

    private BigDecimal calculateFinalOrderPrice(
            Map<UUID, Integer> itemQuantities, List<ProductEntity> productsFound) {
        return productsFound.stream()
                .map(
                        product -> {
                            BigDecimal productPrice = product.getPrice();
                            Integer productQuantityInOrder = itemQuantities.get(product.getId());
                            return productPrice.multiply(
                                    BigDecimal.valueOf(productQuantityInOrder));
                        })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
