package com.compstore.dto.smartphone;

import com.compstore.dto.dictionary.BrandDTO;
import com.compstore.dto.dictionary.ProcessorBrandSimpleDTO;
import com.compstore.dto.dictionary.ScreenTypeDTO;
import java.util.UUID;
import lombok.Data;

@Data
public class SmartphoneDTO {

    private UUID id;

    private BrandDTO brand;

    private String name;

    private String color;

    private Double screenSize;

    private Integer resolutionHeight;

    private Integer resolutionWidth;

    private ScreenTypeDTO screenType;

    private Integer batteryCapacity;

    private String ramCapacity;

    private String storageCapacity;

    private Integer frontCameraMpixResolution;

    private Integer backCameraMpixResolution;

    private String operatingSystem;

    private ProcessorBrandSimpleDTO processorBrand;

    private String processorName;

    private Double price;
}
