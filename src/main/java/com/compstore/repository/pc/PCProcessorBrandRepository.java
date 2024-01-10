package com.compstore.repository.pc;

import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface PCProcessorBrandRepository extends JpaRepository<PCProcessorBrandEntity, UUID> {}
