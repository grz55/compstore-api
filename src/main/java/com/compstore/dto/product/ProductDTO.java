package com.compstore.dto.product;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Data
public class ProductDTO {

    private UUID id;

    private String description;

    private BigDecimal price;
}
