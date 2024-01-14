package com.compstore.repository;

import com.compstore.entity.dictionary.GraphicsCardBrandEntity;
import com.compstore.entity.dictionary.enums.GraphicsCardBrandDeviceType;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphicsCardBrandRepository extends JpaRepository<GraphicsCardBrandEntity, UUID> {

    Optional<GraphicsCardBrandEntity> findByIdAndGraphicsCardBrandDeviceType(
            UUID id, GraphicsCardBrandDeviceType graphicsCardBrandDeviceType);

    List<GraphicsCardBrandEntity> findByGraphicsCardBrandDeviceType(
            GraphicsCardBrandDeviceType graphicsCardBrandDeviceType);
}
