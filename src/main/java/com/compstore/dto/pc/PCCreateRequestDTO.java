package com.compstore.dto.pc;

import lombok.Data;

@Data
public class PCCreateRequestDTO {

    private String processorBrand;

    private String processorName;

    private String graphicsCardBrand;

    private String graphicsCardName;

    private Integer ramGBCapacity;

    private Integer driveGBCapacity;

    private String driveType;

    private String operatingSystem;

    private Double price;
}
