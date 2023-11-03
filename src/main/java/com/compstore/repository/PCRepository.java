package com.compstore.repository;

import com.compstore.entity.pc.PCEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PCRepository extends JpaRepository<PCEntity, UUID> {}
