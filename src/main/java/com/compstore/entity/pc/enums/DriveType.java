package com.compstore.entity.pc.enums;

import com.compstore.exception.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DriveType {
    HDD("HDD"),
    SSD("SSD");

    private final String value;

    public static DriveType fromValue(String value) {
        for (DriveType driveType : values()) {
            if (driveType.value.equalsIgnoreCase(value)) {
                return driveType;
            }
        }
        throw new BadRequestException("Unsupported drive type value: " + value);
    }
}
