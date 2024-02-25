package com.compstore.dto.order;

import java.util.*;
import lombok.Data;

@Data
public class OrderCreateRequestDTO {

    private List<OrderItemDTO> orderItems;
}
