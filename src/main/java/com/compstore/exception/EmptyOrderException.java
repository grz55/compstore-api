package com.compstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class EmptyOrderException extends RuntimeException {

    private static final String EMPTY_ORDER_MSG = "Order cannot be empty";

    public EmptyOrderException() {
        super(EMPTY_ORDER_MSG);
    }
}
