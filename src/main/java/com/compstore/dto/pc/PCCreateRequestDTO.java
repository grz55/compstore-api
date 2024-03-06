package com.compstore.dto.pc;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.UUID;
import lombok.Data;

@Data
public class PCCreateRequestDTO {

    @NotNull private UUID processorBrand;

    @NotEmpty private String processorName;

    @NotNull private UUID graphicsCardBrand;

    @NotEmpty private String graphicsCardName;

    @NotEmpty private String ramCapacity;

    @NotEmpty private String driveCapacity;

    @NotEmpty private String driveType;

    private UUID operatingSystem;

    @NotNull @PositiveOrZero private Double price;
}
