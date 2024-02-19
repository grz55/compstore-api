package com.compstore.service.impl;

import com.compstore.dto.order.OrderCreateRequestDTO;
import com.compstore.dto.order.OrderCreateResponseDTO;
import com.compstore.entity.OrderEntity;
import com.compstore.entity.OrderProductEntity;
import com.compstore.entity.ProductEntity;
import com.compstore.exception.NotFoundException;
import com.compstore.mapper.OrderMapper;
import com.compstore.repository.OrderRepository;
import com.compstore.repository.ProductRepository;
import com.compstore.service.IOrderService;
import com.compstore.validator.OrderValidator;
import java.math.BigDecimal;
import java.util.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private static final String ORDER_NOT_FOUND_MSG = "Order not found with id: ";

    private final OrderMapper orderMapper;

    private final OrderRepository orderRepository;
    private final ProductRepository<ProductEntity> productRepository;

    private final OrderValidator orderValidator;

    @Override
    public OrderCreateResponseDTO createOrder(OrderCreateRequestDTO orderCreateRequest) {
        Set<UUID> productsInOrderUuids = orderCreateRequest.getProductsQuantity().keySet();
        orderValidator.validateEmptyOrder(productsInOrderUuids);

        List<ProductEntity> productsFound = productRepository.findByIdIn(productsInOrderUuids);
        orderValidator.validateProductsExist(productsInOrderUuids, productsFound);

        OrderEntity newOrder = prepareOrderFromProducts(orderCreateRequest, productsFound);

        OrderEntity savedOrder = orderRepository.save(newOrder);
        return orderMapper.toOrderCreateResponseDTO(savedOrder);
    }

    @Override
    public void deleteOrderById(UUID orderId) {
        Optional<OrderEntity> orderById = orderRepository.findById(orderId);
        if (orderById.isPresent()) {
            orderRepository.delete(orderById.get());
        } else {
            throw new NotFoundException(ORDER_NOT_FOUND_MSG + orderId);
        }
    }

    private OrderEntity prepareOrderFromProducts(
            OrderCreateRequestDTO orderCreateRequest, List<ProductEntity> productsFound) {
        OrderEntity newOrder = new OrderEntity();

        List<OrderProductEntity> orderProducts =
                productsFound.stream()
                        .map(
                                product ->
                                        new OrderProductEntity(
                                                newOrder,
                                                product,
                                                orderCreateRequest
                                                        .getProductsQuantity()
                                                        .get(product.getId())))
                        .toList();

        BigDecimal finalOrderPrice = calculateFinalOrderPrice(orderCreateRequest, productsFound);

        newOrder.setOrderProducts(orderProducts);
        newOrder.setPrice(finalOrderPrice);
        return newOrder;
    }

    private BigDecimal calculateFinalOrderPrice(
            OrderCreateRequestDTO orderCreateRequest, List<ProductEntity> productsFound) {
        return productsFound.stream()
                .map(
                        product -> {
                            BigDecimal productPrice = product.getPrice();
                            Integer productQuantityInOrder =
                                    orderCreateRequest.getProductsQuantity().get(product.getId());
                            return productPrice.multiply(
                                    BigDecimal.valueOf(productQuantityInOrder));
                        })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
