package com.compstore.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ProductEntity {

    @Id @GeneratedValue protected UUID id;

    protected String description;

    protected BigDecimal price;
}
