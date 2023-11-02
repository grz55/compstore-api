package com.compstore.dto.smartphone;

import java.util.UUID;
import lombok.Data;

@Data
public class SmartphoneDTO {

    private UUID id;

    private String brand;

    private String name;

    private String color;

    private Double screenSize;

    private Integer resolutionHeight;

    private Integer resolutionWidth;

    private String smartphoneScreenType;

    private Integer batteryCapacity;

    private Integer ramGBCapacity;

    private Integer storageGBCapacity;

    private Integer frontCameraMpixResolution;

    private Integer backCameraMpixResolution;

    private String operatingSystem;

    private String processorBrand;

    private String processorName;

    private Double price;
}
