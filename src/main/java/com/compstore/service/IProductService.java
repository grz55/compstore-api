package com.compstore.service;

import com.compstore.dto.product.ProductDTO;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface IProductService {

    List<ProductDTO> getProductsByIds(Set<UUID> productUUIDs);
}
