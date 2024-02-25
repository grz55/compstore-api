package com.compstore.service.impl;

import com.compstore.dto.product.ProductDTO;
import com.compstore.entity.ProductEntity;
import com.compstore.mapper.ProductMapper;
import com.compstore.repository.ProductRepository;
import com.compstore.service.IProductService;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.compstore.validator.ProductValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.compstore.validator.ProductValidator.PRODUCT_NOT_FOUND_IN_GIVEN_LIST;

@Service
@Slf4j
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductMapper productMapper;
    private final ProductRepository<ProductEntity> productRepository;
    private final ProductValidator productValidator;

    @Override
    public List<ProductDTO> getProductsByIds(Set<UUID> productUUIDs) {
        log.info("Requested getting products with ids: {}", productUUIDs);
        List<ProductEntity> productsFound = productRepository.findByIdIn(productUUIDs);
        productValidator.validateProductsExist(productUUIDs, productsFound);
        return productMapper.toProductDTOList(productsFound);
    }
}
