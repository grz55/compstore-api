package com.compstore.validator;

import com.compstore.entity.pc.PCEntity;
import com.compstore.exception.EntityUsedException;
import org.springframework.stereotype.Service;

@Service
public class PCValidator {

    public void validateDelete(PCEntity pcEntity) {
        if (pcEntity.isUsed()) {
            throw new EntityUsedException(pcEntity.getEntityName());
        }
    }
}
