package com.compstore.dto.pc;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.UUID;
import lombok.Data;

@Data
public class PCCreateRequestDTO {

    @NotNull private UUID processorBrand;

    @NotBlank private String processorName;

    @NotNull private UUID graphicsCardBrand;

    @NotBlank private String graphicsCardName;

    @NotBlank private String ramCapacity;

    @NotBlank private String driveCapacity;

    @NotBlank private String driveType;

    private UUID operatingSystem;

    @NotNull @PositiveOrZero private Double price;
}
