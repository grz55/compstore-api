package com.compstore.repository.pc;

import com.compstore.entity.pc.PCEntity;
import com.compstore.repository.ProductRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PCRepository
        extends ProductRepository<PCEntity>, JpaSpecificationExecutor<PCEntity> {}
