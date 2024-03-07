package com.compstore.validator;

import com.compstore.dto.order.OrderItemDTO;
import com.compstore.exception.EmptyOrderException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderValidator {

    public void validateEmptyOrder(List<OrderItemDTO> orderItems) {
        if (orderItems.isEmpty()) {
            throw new EmptyOrderException();
        }
    }
}
