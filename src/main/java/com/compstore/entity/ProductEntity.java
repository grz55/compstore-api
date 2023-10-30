package com.compstore.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@MappedSuperclass
public abstract class ProductEntity {

    @Id @GeneratedValue private UUID id;

    private BigDecimal price;
}
