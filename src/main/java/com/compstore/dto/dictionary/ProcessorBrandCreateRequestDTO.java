package com.compstore.dto.dictionary;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProcessorBrandCreateRequestDTO {

    @NotBlank private String name;

    @NotBlank private String processorBrandDeviceType;
}
