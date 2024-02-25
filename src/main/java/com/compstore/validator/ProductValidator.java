package com.compstore.validator;

import com.compstore.entity.ProductEntity;
import com.compstore.exception.NotFoundException;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ProductValidator {

    public static final String PRODUCT_NOT_FOUND_IN_GIVEN_LIST =
            "At least one of given products does not exist";

    public void validateProductsExist(
            Set<UUID> productsInOrderUuids, List<ProductEntity> productsFound) {
        if (productsInOrderUuids.size() != productsFound.size()) {
            throw new NotFoundException(PRODUCT_NOT_FOUND_IN_GIVEN_LIST);
        }
    }
}
