package com.compstore.service;

import com.compstore.dto.pc.PCCreateRequestDTO;
import com.compstore.dto.pc.PCComboDataDTO;
import com.compstore.dto.pc.PCDTO;
import java.util.UUID;

public interface IPCService {

    PCDTO getPCById(UUID pcId);

    PCDTO createPC(PCCreateRequestDTO pcCreateRequest);

    PCComboDataDTO getPCComboData();
}
