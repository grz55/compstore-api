package com.compstore.dto;

import lombok.Data;

@Data
public class PagingAndSortingMetadataDTO {

    private Integer pageNumber;

    private Integer pageSize;

    private Integer pagesCount;

    private Long elementsCount;
}
