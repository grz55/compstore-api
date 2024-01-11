package com.compstore.repository.pc;

import com.compstore.entity.GraphicsCardBrandDeviceType;
import com.compstore.entity.GraphicsCardBrandEntity;
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
