package com.compstore.repository;

import com.compstore.entity.ProductEntity;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository<T extends ProductEntity> extends JpaRepository<T, UUID> {

    List<T> findByIdIn(Set<UUID> uuids);
}
