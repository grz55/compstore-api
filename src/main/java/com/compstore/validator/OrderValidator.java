package com.compstore.validator;

import com.compstore.entity.ProductEntity;
import com.compstore.exception.EmptyOrderException;
import com.compstore.exception.NotFoundException;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class OrderValidator {

    private static final String PRODUCT_NOT_FOUND_IN_GIVEN_LIST =
            "At least one of given products does not exist";

    public void validateEmptyOrder(Set<UUID> productsInOrderUuids) {
        if (productsInOrderUuids.isEmpty()) {
            throw new EmptyOrderException();
        }
    }

    public void validateProductsExist(
            Set<UUID> productsInOrderUuids, List<ProductEntity> productsFound) {
        if (productsInOrderUuids.size() != productsFound.size()) {
            throw new NotFoundException(PRODUCT_NOT_FOUND_IN_GIVEN_LIST);
        }
    }
}
