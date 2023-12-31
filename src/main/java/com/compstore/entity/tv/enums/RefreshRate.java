package com.compstore.entity.tv.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RefreshRate {
    REFRESH_RATE_60HZ(60),
    REFRESH_RATE_100HZ(100);

    private final Integer value;
}
