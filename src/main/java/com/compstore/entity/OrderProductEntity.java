package com.compstore.entity;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "order_products")
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductEntity {

    @Id @GeneratedValue private UUID id;

    @ManyToOne
    @JoinColumn(name = "order_uuid")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "product_uuid")
    private ProductEntity product;

    private Integer quantity;

    public OrderProductEntity(OrderEntity order, ProductEntity product, Integer quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }
}
