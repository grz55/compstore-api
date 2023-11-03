package com.compstore.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Color {
    WHITE("White"),
    GRAY("Gray"),
    YELLOW("Yellow"),
    BEIGE("Beige"),
    ORANGE("Orange"),
    PINK("Pink"),
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    PURPLE("Purple"),
    BROWN("Brown"),
    BLACK("Black");

    private final String value;
}
