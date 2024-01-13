package com.compstore.entity;

import com.compstore.exception.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProcessorBrandDeviceType {
    PC("PC"),
    SMARTPHONE("Smartphone");

    private final String value;

    public static ProcessorBrandDeviceType fromValue(String value) {
        for (ProcessorBrandDeviceType processorBrandDeviceType : values()) {
            if (processorBrandDeviceType.value.equalsIgnoreCase(value)) {
                return processorBrandDeviceType;
            }
        }
        throw new BadRequestException("Unsupported processor brand device type value: " + value);
    }
}
