package com.compstore.repository;

import com.compstore.entity.dictionary.ProcessorBrandEntity;
import com.compstore.entity.dictionary.enums.ProcessorBrandDeviceType;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessorBrandRepository extends JpaRepository<ProcessorBrandEntity, UUID> {

    Optional<ProcessorBrandEntity> findByIdAndProcessorBrandDeviceType(
            UUID id, ProcessorBrandDeviceType processorBrandDeviceType);

    List<ProcessorBrandEntity> findByProcessorBrandDeviceType(
            ProcessorBrandDeviceType processorBrandDeviceType);
}
