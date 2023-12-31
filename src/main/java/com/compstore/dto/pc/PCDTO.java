package com.compstore.dto.pc;

import java.util.UUID;
import lombok.Data;

@Data
public class PCDTO {

    private UUID id;

    private String processorBrand;

    private String processorName;

    private String graphicsCardBrand;

    private String graphicsCardName;

    private String ramCapacity;

    private String driveCapacity;

    private String driveType;

    private String operatingSystem;

    private Double price;
}
