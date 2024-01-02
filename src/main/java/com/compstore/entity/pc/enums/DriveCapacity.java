package com.compstore.entity.pc.enums;

import com.compstore.exception.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DriveCapacity {
    DRIVE_256_GB("256 GB"),
    DRIVE_512_GB("512 GB"),
    DRIVE_1_TB("1 TB"),
    DRIVE_2_TB("2 TB"),
    DRIVE_4_TB("4 TB");

    private final String value;

    public static DriveCapacity fromValue(String value) {
        for (DriveCapacity driveCapacity : values()) {
            if (driveCapacity.value.equalsIgnoreCase(value)) {
                return driveCapacity;
            }
        }
        throw new BadRequestException("Unsupported drive capacity value: " + value);
    }
}
