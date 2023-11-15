package com.compstore.service;

import com.compstore.dto.pc.PCComboDataDTO;
import com.compstore.dto.pc.PCDTO;
import java.util.UUID;

public interface IPCService {

    PCDTO getPCById(UUID pcId);

    PCComboDataDTO getPCComboData();
}
