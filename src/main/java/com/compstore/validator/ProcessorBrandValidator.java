package com.compstore.validator;

import com.compstore.entity.ProcessorBrandEntity;
import com.compstore.exception.EntityUsedException;
import org.springframework.stereotype.Service;

@Service
public class ProcessorBrandValidator {

    public void validateDelete(ProcessorBrandEntity processorBrandEntity) {
        if (processorBrandEntity.isUsed()) {
            throw new EntityUsedException(processorBrandEntity.getEntityName());
        }
    }
}
