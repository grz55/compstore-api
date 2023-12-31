package com.compstore.dto.pc;

import java.util.List;
import lombok.Data;

@Data
public class PCComboDataDTO {

    private List<PCProcessorBrandDTO> processorBrands;

    private List<PCGraphicsCardBrandDTO> graphicsCardBrands;

    private List<String> ramGBCapacities;

    private List<String> driveGBCapacities;

    private List<String> driveTypes;

    private List<PCOperatingSystemDTO> operatingSystems;
}
