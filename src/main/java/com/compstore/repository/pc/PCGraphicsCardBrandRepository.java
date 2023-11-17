package com.compstore.repository.pc;

import com.compstore.entity.pc.PCGraphicsCardBrandEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PCGraphicsCardBrandRepository
        extends JpaRepository<PCGraphicsCardBrandEntity, UUID> {}
