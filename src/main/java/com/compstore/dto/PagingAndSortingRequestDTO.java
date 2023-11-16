package com.compstore.dto;

import lombok.Data;

@Data
public class PagingAndSortingRequestDTO {

    private Integer pageNumber = 0;

    private Integer pageSize = 10;

    private String sortingType;

    private String sortingOrder;
}
