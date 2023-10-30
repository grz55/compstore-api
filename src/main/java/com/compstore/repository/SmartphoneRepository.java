package com.compstore.repository;

import com.compstore.entity.smartphone.SmartphoneEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepository extends JpaRepository<SmartphoneEntity, UUID> {}
