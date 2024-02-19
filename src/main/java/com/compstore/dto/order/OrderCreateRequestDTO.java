package com.compstore.dto.order;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import lombok.Data;

@Data
public class OrderCreateRequestDTO {

    private Map<UUID, Integer> productsQuantity = new HashMap<>();
}
