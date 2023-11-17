package com.compstore.entity.enums;

import com.compstore.exception.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PCDriveType {
    HDD("HDD"),
    SSD("SSD");

    private final String value;

    public static PCDriveType fromValue(String value) {
        for (PCDriveType driveType : values()) {
            if (driveType.value.equalsIgnoreCase(value)) {
                return driveType;
            }
        }
        throw new BadRequestException("Unsupported PC drive type value: " + value);
    }
}
