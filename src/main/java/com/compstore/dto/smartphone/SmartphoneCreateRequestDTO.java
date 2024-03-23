package com.compstore.dto.smartphone;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class SmartphoneCreateRequestDTO {

    @NotBlank private String brand;

    @NotBlank private String color;

    @NotNull @Positive private Double screenSize;

    @NotNull @Positive private Integer resolutionHeight;

    @NotNull @Positive private Integer resolutionWidth;

    @NotBlank private String screenType;

    @Positive private Integer batteryCapacity;

    private String ramCapacity;

    @NotBlank private String storageCapacity;

    @Positive private Integer frontCameraMpixResolution;

    @NotNull @Positive private Integer backCameraMpixResolution;

    @NotBlank private String operatingSystem;

    @NotBlank private String processorBrand;

    @NotBlank private String processorName;

    @NotNull @Positive private Double price;
}
