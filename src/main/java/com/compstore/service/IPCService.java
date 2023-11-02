package com.compstore.service;

import com.compstore.dto.pc.PCCreateRequestDTO;
import com.compstore.dto.pc.PCDTO;
import com.compstore.entity.pc.PCEntity;
import java.util.UUID;

public interface IPCService {

    PCDTO getPCById(UUID pcId);

    PCEntity createPC(PCCreateRequestDTO pcCreateRequestDTO);
}
