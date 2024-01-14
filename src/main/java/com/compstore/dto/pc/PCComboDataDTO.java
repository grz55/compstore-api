package com.compstore.dto.pc;

import com.compstore.dto.dictionary.GraphicsCardBrandDTO;
import com.compstore.dto.dictionary.ProcessorBrandSimpleDTO;
import java.util.List;
import lombok.Data;

@Data
public class PCComboDataDTO {

    private List<ProcessorBrandSimpleDTO> processorBrands;

    private List<GraphicsCardBrandDTO> graphicsCardBrands;

    private List<String> ramCapacities;

    private List<String> driveCapacities;

    private List<String> driveTypes;

    private List<PCOperatingSystemDTO> operatingSystems;
}
