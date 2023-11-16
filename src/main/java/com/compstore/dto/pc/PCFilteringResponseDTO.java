package com.compstore.dto.pc;

import com.compstore.dto.PagingAndSortingMetadataDTO;
import java.util.List;
import lombok.Data;

@Data
public class PCFilteringResponseDTO {

    private List<PCSimpleDTO> pcs;

    private PagingAndSortingMetadataDTO pagingAndSortingMetadata;
}
