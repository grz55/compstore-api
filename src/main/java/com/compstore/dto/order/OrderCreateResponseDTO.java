package com.compstore.dto.order;

import java.util.UUID;
import lombok.Data;

@Data
public class OrderCreateResponseDTO {

    private UUID id;

    private Double price;
}
