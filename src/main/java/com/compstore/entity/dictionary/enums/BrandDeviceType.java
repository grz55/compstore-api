package com.compstore.entity.dictionary.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BrandDeviceType {
    SMARTPHONE("Smartphone"),
    TV("TV");

    private final String value;
}
