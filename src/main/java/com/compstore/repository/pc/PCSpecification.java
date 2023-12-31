package com.compstore.repository.pc;

import com.compstore.dto.pc.PCFilteringRequestDTO;
import com.compstore.entity.enums.DriveGBCapacity;
import com.compstore.entity.enums.PCDriveType;
import com.compstore.entity.enums.RAMGBCapacity;
import com.compstore.entity.pc.*;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PCSpecification {

    public static Specification<PCEntity> filterPC(PCFilteringRequestDTO pcFilteringRequestDTO) {

        return Specification.where(
                        findByProcessorBrands(pcFilteringRequestDTO.getProcessorBrands()))
                .and(findByGraphicsCardBrands(pcFilteringRequestDTO.getGraphicsCardBrands()))
                .and(findByRamGBCapacities(pcFilteringRequestDTO.getRamGBCapacities()))
                .and(findByDriveGBCapacities(pcFilteringRequestDTO.getDriveGBCapacities()))
                .and(findByDriveTypes(pcFilteringRequestDTO.getDriveTypes()))
                .and(findByOperatingSystems(pcFilteringRequestDTO.getOperatingSystems()))
                .and(findByPriceFrom(pcFilteringRequestDTO.getPriceFrom()))
                .and(findByPriceTo(pcFilteringRequestDTO.getPriceTo()));
    }

    private static Specification<PCEntity> findByProcessorBrands(List<UUID> processorBrands) {
        if (processorBrands == null || processorBrands.isEmpty()) {
            return null;
        }
        return (root, query, criteriaBuilder) -> {
            Join<PCEntity, PCProcessorBrandEntity> pcProcessorBrandEntityJoin =
                    root.join(PCEntity_.PROCESSOR_BRAND, JoinType.INNER);
            return pcProcessorBrandEntityJoin.get(PCProcessorBrandEntity_.ID).in(processorBrands);
        };
    }

    private static Specification<PCEntity> findByGraphicsCardBrands(List<UUID> graphicsCardBrands) {
        if (graphicsCardBrands == null || graphicsCardBrands.isEmpty()) {
            return null;
        }
        return (root, query, criteriaBuilder) -> {
            Join<PCEntity, PCGraphicsCardBrandEntity> pcGraphicsCardBrandEntityJoin =
                    root.join(PCEntity_.GRAPHICS_CARD_BRAND, JoinType.INNER);
            return pcGraphicsCardBrandEntityJoin
                    .get(PCGraphicsCardBrandEntity_.ID)
                    .in(graphicsCardBrands);
        };
    }

    private static Specification<PCEntity> findByRamGBCapacities(List<String> ramGBCapacities) {
        if (ramGBCapacities == null || ramGBCapacities.isEmpty()) {
            return null;
        }
        return (root, query, criteriaBuilder) -> {
            Predicate[] predicates =
                    ramGBCapacities.stream()
                            .map(
                                    ramGBCapacity ->
                                            criteriaBuilder.equal(
                                                    root.get(PCEntity_.RAM_GB_CAPACITY),
                                                    RAMGBCapacity.fromValue(ramGBCapacity)))
                            .toArray(Predicate[]::new);

            return criteriaBuilder.or(predicates);
        };
    }

    private static Specification<PCEntity> findByDriveGBCapacities(List<String> driveGBCapacities) {
        if (driveGBCapacities == null || driveGBCapacities.isEmpty()) {
            return null;
        }
        return (root, query, criteriaBuilder) -> {
            Predicate[] predicates =
                    driveGBCapacities.stream()
                            .map(
                                    driveGBCapacity ->
                                            criteriaBuilder.equal(
                                                    root.get(PCEntity_.DRIVE_GB_CAPACITY),
                                                    DriveGBCapacity.fromValue(driveGBCapacity)))
                            .toArray(Predicate[]::new);

            return criteriaBuilder.or(predicates);
        };
    }

    private static Specification<PCEntity> findByDriveTypes(List<String> driveTypes) {
        if (driveTypes == null || driveTypes.isEmpty()) {
            return null;
        }
        return (root, query, criteriaBuilder) -> {
            Predicate[] predicates =
                    driveTypes.stream()
                            .map(
                                    driveType ->
                                            criteriaBuilder.equal(
                                                    root.get(PCEntity_.DRIVE_TYPE),
                                                    PCDriveType.fromValue(driveType)))
                            .toArray(Predicate[]::new);

            return criteriaBuilder.or(predicates);
        };
    }

    private static Specification<PCEntity> findByOperatingSystems(List<UUID> operatingSystems) {
        if (operatingSystems == null || operatingSystems.isEmpty()) {
            return null;
        }
        return (root, query, criteriaBuilder) -> {
            Join<PCEntity, PCOperatingSystemEntity> pcOperatingSystemEntityJoin =
                    root.join(PCEntity_.OPERATING_SYSTEM, JoinType.INNER);
            return pcOperatingSystemEntityJoin
                    .get(PCOperatingSystemEntity_.ID)
                    .in(operatingSystems);
        };
    }

    private static Specification<PCEntity> findByPriceFrom(Double priceFrom) {
        if (priceFrom == null) {
            return null;
        }
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get(PCEntity_.PRICE), priceFrom);
    }

    private static Specification<PCEntity> findByPriceTo(Double priceTo) {
        if (priceTo == null) {
            return null;
        }
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get(PCEntity_.PRICE), priceTo);
    }
}
