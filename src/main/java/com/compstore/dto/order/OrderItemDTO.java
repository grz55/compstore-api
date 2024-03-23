package com.compstore.dto.order;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.UUID;
import lombok.Data;

@Data
public class OrderItemDTO {

    @NotNull private UUID product;

    @NotNull @PositiveOrZero private Integer quantity;
}
