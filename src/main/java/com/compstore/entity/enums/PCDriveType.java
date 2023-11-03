package com.compstore.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PCDriveType {
    HDD("HDD"),
    SSD("SSD");

    private final String value;
}
