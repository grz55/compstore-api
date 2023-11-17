package com.compstore.repository.pc;

import com.compstore.dto.pc.PCFilteringRequestDTO;
import com.compstore.entity.pc.PCEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PCSpecification {

    public static Specification<PCEntity> filterPC(PCFilteringRequestDTO pcFilteringRequestDTO) {

        Specification<PCEntity> pcSpecification = Specification.where(null);

        if(pcFilteringRequestDTO.getProcessorBrands() != null && !pcFilteringRequestDTO.getProcessorBrands().isEmpty()) {
            pcSpecification = (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("processorBrand"), pcFilteringRequestDTO.getProcessorBrands());
        }

        return pcSpecification;
    }
}
