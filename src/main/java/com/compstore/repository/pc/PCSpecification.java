package com.compstore.repository.pc;

import com.compstore.dto.pc.PCFilteringRequestDTO;
import com.compstore.entity.ProcessorBrandDeviceType;
import com.compstore.entity.ProcessorBrandEntity;
import com.compstore.entity.ProcessorBrandEntity_;
import com.compstore.entity.pc.*;
import com.compstore.entity.pc.enums.DriveCapacity;
import com.compstore.entity.pc.enums.DriveType;
import com.compstore.entity.pc.enums.RAMCapacity;
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
                .and(findByRamCapacities(pcFilteringRequestDTO.getRamCapacities()))
                .and(findByDriveCapacities(pcFilteringRequestDTO.getDriveCapacities()))
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
            Join<PCEntity, ProcessorBrandEntity> processorBrandEntityJoin =
                    root.join(PCEntity_.PROCESSOR_BRAND, JoinType.INNER);
            Predicate idsPredicate =
                    processorBrandEntityJoin.get(ProcessorBrandEntity_.ID).in(processorBrands);
            Predicate deviceTypePredicate =
                    criteriaBuilder.equal(
                            processorBrandEntityJoin.get(
                                    ProcessorBrandEntity_.PROCESSOR_BRAND_DEVICE_TYPE),
                            ProcessorBrandDeviceType.PC);
            return criteriaBuilder.and(idsPredicate, deviceTypePredicate);
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

    private static Specification<PCEntity> findByRamCapacities(List<String> ramCapacities) {
        if (ramCapacities == null || ramCapacities.isEmpty()) {
            return null;
        }
        return (root, query, criteriaBuilder) -> {
            Predicate[] predicates =
                    ramCapacities.stream()
                            .map(
                                    ramCapacity ->
                                            criteriaBuilder.equal(
                                                    root.get(PCEntity_.RAM_CAPACITY),
                                                    RAMCapacity.fromValue(ramCapacity)))
                            .toArray(Predicate[]::new);

            return criteriaBuilder.or(predicates);
        };
    }

    private static Specification<PCEntity> findByDriveCapacities(List<String> driveCapacities) {
        if (driveCapacities == null || driveCapacities.isEmpty()) {
            return null;
        }
        return (root, query, criteriaBuilder) -> {
            Predicate[] predicates =
                    driveCapacities.stream()
                            .map(
                                    driveCapacity ->
                                            criteriaBuilder.equal(
                                                    root.get(PCEntity_.DRIVE_CAPACITY),
                                                    DriveCapacity.fromValue(driveCapacity)))
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
                                                    DriveType.fromValue(driveType)))
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
