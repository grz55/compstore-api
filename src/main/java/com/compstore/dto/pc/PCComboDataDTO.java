package com.compstore.dto.pc;

import com.compstore.dto.ProcessorBrandDTO;
import java.util.List;
import lombok.Data;

@Data
public class PCComboDataDTO {

    private List<ProcessorBrandDTO> processorBrands;

    private List<PCGraphicsCardBrandDTO> graphicsCardBrands;

    private List<String> ramCapacities;

    private List<String> driveCapacities;

    private List<String> driveTypes;

    private List<PCOperatingSystemDTO> operatingSystems;
}
