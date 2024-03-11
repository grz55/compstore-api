package com.compstore.controller;

import com.compstore.dto.order.OrderCreateRequestDTO;
import com.compstore.dto.order.OrderCreateResponseDTO;
import com.compstore.service.IOrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
@Tag(name = "OrderController")
public class OrderController {

    private final IOrderService orderService;

    @PostMapping
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<OrderCreateResponseDTO> createOrder(
            @RequestBody OrderCreateRequestDTO orderCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderService.createOrder(orderCreateRequest));
    }

    @DeleteMapping("/{orderId}")
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<Void> deleteOrderById(@PathVariable UUID orderId) {
        orderService.deleteOrderById(orderId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
