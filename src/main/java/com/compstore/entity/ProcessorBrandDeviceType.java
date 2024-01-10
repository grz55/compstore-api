package com.compstore.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProcessorBrandDeviceType {
    PC("PC"),
    SMARTPHONE("Smartphone");

    private final String value;
}
