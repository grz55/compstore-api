package com.compstore.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BrandDeviceType {
    SMARTPHONE("Smartphone"),
    TV("TV");

    private final String value;
}
