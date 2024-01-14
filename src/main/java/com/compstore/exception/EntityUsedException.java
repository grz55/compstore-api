package com.compstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class EntityUsedException extends RuntimeException {

    private static final String ENTITY_USED_MSG = " is used";

    public EntityUsedException(String entityName) {
        super(entityName + ENTITY_USED_MSG);
    }
}
