package com.compstore.dto.pc;

import com.compstore.dto.PagingAndSortingMetadataDTO;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PCFilteringResponseDTO {

    private List<PCSimpleDTO> pcs;

    private PagingAndSortingMetadataDTO pagingAndSortingMetadata;
}
