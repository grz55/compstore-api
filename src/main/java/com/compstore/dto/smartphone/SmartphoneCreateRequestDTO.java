package com.compstore.dto.smartphone;

import lombok.Data;

@Data
public class SmartphoneCreateRequestDTO {

    private String brand;

    private String color;

    private Double screenSize;

    private Integer resolutionHeight;

    private Integer resolutionWidth;

    private String screenType;

    private Integer batteryCapacity;

    private String ramCapacity;

    private String storageCapacity;

    private Integer frontCameraMpixResolution;

    private Integer backCameraMpixResolution;

    private String operatingSystem;

    private String processorBrand;

    private String processorName;

    private Double price;
}
