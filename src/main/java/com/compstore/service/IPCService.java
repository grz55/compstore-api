package com.compstore.service;

import com.compstore.dto.pc.PCCreateRequestDTO;
import com.compstore.entity.pc.PCEntity;
import java.util.Optional;
import java.util.UUID;

public interface IPCService {

    Optional<PCEntity> getPCById(UUID pcId);

    PCEntity createPC(PCCreateRequestDTO pcCreateRequestDTO);
}
