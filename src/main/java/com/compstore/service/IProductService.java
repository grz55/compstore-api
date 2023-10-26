package com.compstore.service;

import com.compstore.entity.ProductEntity;
import java.util.Optional;
import java.util.UUID;

public interface IProductService {

    Optional<ProductEntity> getProductById(UUID productId);

    ProductEntity createProduct(ProductEntity product);
}
