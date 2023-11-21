package com.compstore.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PagingAndSortingMetadataDTO {

    private Integer pageNumber;

    private Integer pageSize;

    private Integer pagesCount;

    private Long elementsCount;
}
