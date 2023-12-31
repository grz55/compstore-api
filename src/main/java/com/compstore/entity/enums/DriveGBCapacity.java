package com.compstore.entity.enums;

import com.compstore.exception.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DriveGBCapacity {
    DRIVE_256_GB("256 GB"),
    DRIVE_512_GB("512 GB"),
    DRIVE_1024_GB("1024 GB"),
    DRIVE_2048_GB("2048 GB"),
    DRIVE_4096_GB("4096 GB");

    private final String value;

    public static DriveGBCapacity fromValue(String value) {
        for (DriveGBCapacity driveGBCapacity : values()) {
            if (driveGBCapacity.value.equalsIgnoreCase(value)) {
                return driveGBCapacity;
            }
        }
        throw new BadRequestException("Unsupported drive GB capacity value: " + value);
    }
}
