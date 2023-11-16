package com.compstore.dto.pc;

import java.util.UUID;
import lombok.Data;

@Data
public class PCSimpleDTO {

    private UUID id;

    private String processorName;

    private String graphicsCardName;

    private Integer ramGBCapacity;

    private Double price;
}
