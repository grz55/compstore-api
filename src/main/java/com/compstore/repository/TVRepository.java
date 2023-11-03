package com.compstore.repository;

import com.compstore.entity.tv.TVEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TVRepository extends JpaRepository<TVEntity, UUID> {}
