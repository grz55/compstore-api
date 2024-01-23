package com.compstore.dto.pc;

import com.compstore.dto.dictionary.GraphicsCardBrandDTO;
import com.compstore.dto.dictionary.OperatingSystemDTO;
import com.compstore.dto.dictionary.ProcessorBrandSimpleDTO;
import java.util.UUID;
import lombok.Data;

@Data
public class PCDTO {

    private UUID id;

    private ProcessorBrandSimpleDTO processorBrand;

    private String processorName;

    private GraphicsCardBrandDTO graphicsCardBrand;

    private String graphicsCardName;

    private String ramCapacity;

    private String driveCapacity;

    private String driveType;

    private OperatingSystemDTO operatingSystem;

    private Double price;
}
