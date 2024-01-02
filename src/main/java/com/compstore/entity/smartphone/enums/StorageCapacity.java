package com.compstore.entity.smartphone.enums;

import com.compstore.exception.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StorageCapacity {
    STORAGE_64_GB("64 GB"),
    STORAGE_128_GB("128 GB"),
    STORAGE_256_GB("256 GB"),
    STORAGE_512_GB("512 GB"),
    STORAGE_1_TB("1 TB");

    private final String value;

    public static StorageCapacity fromValue(String value) {
        for (StorageCapacity storageCapacity : values()) {
            if (storageCapacity.value.equalsIgnoreCase(value)) {
                return storageCapacity;
            }
        }
        throw new BadRequestException("Unsupported storage capacity value: " + value);
    }
}
