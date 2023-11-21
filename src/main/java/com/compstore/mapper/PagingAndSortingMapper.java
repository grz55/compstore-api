package com.compstore.mapper;

import com.compstore.dto.PagingAndSortingMetadataDTO;
import com.compstore.dto.PagingAndSortingRequestDTO;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Mapper(componentModel = "spring")
public interface PagingAndSortingMapper {

    String DEFAULT_SORTING_PROPERTY = "price";

    default Pageable toPageable(PagingAndSortingRequestDTO pagingAndSortingRequest) {
        Sort.Direction direction =
                Boolean.TRUE.equals(pagingAndSortingRequest.getAscendingFlag())
                        ? Sort.Direction.ASC
                        : Sort.Direction.DESC;

        return PageRequest.of(
                pagingAndSortingRequest.getPageNumber(),
                pagingAndSortingRequest.getPageSize(),
                direction,
                DEFAULT_SORTING_PROPERTY);
    }

    default PagingAndSortingMetadataDTO toPagingAndSortingMetadataDTO(Page<?> page) {
        return PagingAndSortingMetadataDTO.builder()
                .pageNumber(page.getNumber())
                .pageSize(page.getSize())
                .pagesCount(page.getTotalPages())
                .elementsCount(page.getTotalElements())
                .build();
    }
}
