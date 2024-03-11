package com.compstore.controller;

import com.compstore.dto.product.ProductDTO;
import com.compstore.service.IProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@Tag(name = "ProductController")
public class ProductController {

    private final IProductService productService;

    @PostMapping
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<List<ProductDTO>> getProductsByIds(@RequestBody Set<UUID> productUUIDs) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.getProductsByIds(productUUIDs));
    }
}
