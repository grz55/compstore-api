package com.compstore.dto.order;

import java.util.UUID;
import lombok.Data;

@Data
public class OrderItemDTO {

    private UUID product;

    private Integer quantity;
}
