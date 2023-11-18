package com.compstore.dto.pc;

import com.compstore.dto.PagingAndSortingRequestDTO;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class PCFilteringRequestDTO {

    private List<UUID> processorBrands;

    private List<UUID> graphicsCardBrands;

    private Integer ramGBCapacityFrom;

    private Integer ramGBCapacityTo;

    private Integer driveGBCapacityFrom;

    private Integer driveGBCapacityTo;

    private List<String> driveTypes;

    private List<UUID> operatingSystems;

    private Double priceFrom;

    private Double priceTo;

    private PagingAndSortingRequestDTO pagingAndSortingRequest;
}