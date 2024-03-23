package com.compstore.dto.pagination;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class PagingAndSortingRequestDTO {

    @NotNull @PositiveOrZero private Integer pageNumber = 0;

    @NotNull @PositiveOrZero private Integer pageSize = 10;

    @NotNull private Boolean ascendingFlag = true;
}
