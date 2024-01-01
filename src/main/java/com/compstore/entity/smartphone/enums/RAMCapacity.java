package com.compstore.entity.smartphone.enums;

import com.compstore.exception.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RAMCapacity {
    RAM_4_GB("4 GB"),
    RAM_6_GB("6 GB"),
    RAM_8_GB("8 GB"),
    RAM_12_GB("12 GB"),
    RAM_16_GB("16 GB"),
    RAM_32_GB("32 GB");

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
