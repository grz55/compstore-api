package com.compstore.entity.enums;

import com.compstore.exception.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RAMGBCapacity {
    RAM_8_GB("8 GB"),
    RAM_16_GB("16 GB"),
    RAM_32_GB("32 GB"),
    RAM_64_GB("64 GB");

    private final String value;

    public static RAMGBCapacity fromValue(String value) {
        for (RAMGBCapacity ramGBCapacity : values()) {
            if (ramGBCapacity.value.equalsIgnoreCase(value)) {
                return ramGBCapacity;
            }
        }
        throw new BadRequestException("Unsupported RAM GB capacity value: " + value);
    }
}
