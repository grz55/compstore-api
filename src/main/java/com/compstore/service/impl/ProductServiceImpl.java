package com.compstore.service.impl;

import com.compstore.entity.ProductEntity;
import com.compstore.repository.ProductRepository;
import com.compstore.service.IProductService;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public Optional<ProductEntity> getProductById(UUID productId) {
        return productRepository.findById(productId);
    }
}
