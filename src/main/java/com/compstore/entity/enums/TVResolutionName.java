package com.compstore.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TVResolutionName {
    RES_HD_READY("HD Ready"),
    RES_FULL_HD("Full HD"),
    RES_4K("4K"),
    RES_8K("8K");

    private final String value;
}
