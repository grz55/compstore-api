package com.compstore.dto.order;

import com.compstore.dto.product.ProductDTO;
import lombok.Data;

@Data
public class OrderItemDetailsDTO {

    private ProductDTO product;

    private Integer quantity;
}
