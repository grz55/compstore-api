package com.compstore.dto.pc;

import java.util.UUID;
import lombok.Data;

@Data
public class PCCreateRequestDTO {

    private UUID processorBrand;

    private String processorName;

    private UUID graphicsCardBrand;

    private String graphicsCardName;

    private String ramCapacity;

    private String driveCapacity;

    private String driveType;

    private UUID operatingSystem;

    private Double price;
}
