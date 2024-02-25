package com.compstore.dto.order;

import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class OrderCreateResponseDTO {

    private UUID id;

    private List<OrderItemDetailsDTO> orderItems;

    private Double price;
}
