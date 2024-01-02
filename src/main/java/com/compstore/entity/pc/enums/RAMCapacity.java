package com.compstore.entity.pc.enums;

import com.compstore.exception.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RAMCapacity {
    RAM_8_GB("8 GB"),
    RAM_16_GB("16 GB"),
    RAM_32_GB("32 GB"),
    RAM_64_GB("64 GB");

    private final String value;

    public static RAMCapacity fromValue(String value) {
        for (RAMCapacity ramCapacity : values()) {
            if (ramCapacity.value.equalsIgnoreCase(value)) {
                return ramCapacity;
            }
        }
        throw new BadRequestException("Unsupported RAM capacity value: " + value);
    }
}
