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

    @Override
    public OrderCreateResponseDTO createOrder(OrderCreateRequestDTO orderCreateRequest) {
        Set<UUID> productsUuids = orderCreateRequest.getProductsQuantity().keySet();
        List<ProductEntity> productsFound = productRepository.findByUUIDs(productsUuids);
        List<OrderProductEntity> orderProducts = new ArrayList<>();
        OrderEntity newOrder = new OrderEntity();
        for (ProductEntity product : productsFound) {
            orderProducts.add(
                    new OrderProductEntity(
                            null,
                            newOrder,
                            product,
                            orderCreateRequest.getProductsQuantity().get(product.getId())));
        }
        BigDecimal finalOrderPrice = calculateFinalOrderPrice(orderCreateRequest, productsFound);
        newOrder.setOrderProducts(orderProducts);
        newOrder.setPrice(finalOrderPrice);

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

    private BigDecimal calculateFinalOrderPrice(
            OrderCreateRequestDTO orderCreateRequest, List<ProductEntity> productsFound) {
        BigDecimal finalOrderPrice = new BigDecimal(0);
        for (ProductEntity product : productsFound) {
            BigDecimal productPrice = product.getPrice();
            Integer singleProductQuantityInOrder =
                    orderCreateRequest.getProductsQuantity().get(product.getId());
            finalOrderPrice =
                    finalOrderPrice.add(
                            productPrice.multiply(
                                    BigDecimal.valueOf(singleProductQuantityInOrder)));
        }
        return finalOrderPrice;
    }
}
