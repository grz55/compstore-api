package com.compstore.repository;

import com.compstore.entity.ProductEntity;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository<T extends ProductEntity> extends JpaRepository<T, UUID> {

    @Query("SELECT p FROM #{#entityName} p WHERE p.id IN :uuids")
    List<T> findByUUIDs(@Param("uuids") Set<UUID> uuids);
}
