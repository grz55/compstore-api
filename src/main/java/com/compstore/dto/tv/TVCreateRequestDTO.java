package com.compstore.dto.tv;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class TVCreateRequestDTO {

    @NotBlank private String brand;

    @NotBlank private String color;

    @NotNull @Positive private Integer screenSize;

    @NotBlank private String resolutionName;

    @NotNull @Positive private Integer resolutionHeight;

    @NotNull @Positive private Integer resolutionWidth;

    @NotBlank private String screenType;

    @NotNull private Boolean hdrFlag;

    @NotNull @Positive private Integer refreshRate;

    @NotNull private Boolean smartTVFlag;

    @NotNull private Boolean wifiFlag;

    @NotNull private Boolean bluetoothFlag;

    @NotNull @PositiveOrZero private Integer hdmiCount;

    @NotNull @PositiveOrZero private Integer usbCount;

    @NotNull @PositiveOrZero private Double price;
}
