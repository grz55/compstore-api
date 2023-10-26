package com.compstore.controller;

import com.compstore.entity.ProductEntity;
import com.compstore.service.IProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@Tag(name = "ProductController")
public class ProductController {

    private final IProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable UUID productId) {
        Optional<ProductEntity> product = productService.getProductById(productId);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product) {
        ProductEntity createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }
}
