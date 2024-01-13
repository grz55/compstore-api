package com.compstore.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ScreenTypeDeviceType {
    SMARTPHONE("Smartphone"),
    TV("TV");

    private final String value;
}
