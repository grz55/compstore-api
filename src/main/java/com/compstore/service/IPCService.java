package com.compstore.service;

import com.compstore.dto.pc.PCComboDataDTO;
import com.compstore.dto.pc.PCCreateRequestDTO;
import com.compstore.dto.pc.PCDTO;
import com.compstore.dto.pc.PCFilteringRequestDTO;
import com.compstore.dto.pc.PCFilteringResponseDTO;
import java.util.UUID;

public interface IPCService {

    PCDTO getPCById(UUID pcId);

    PCDTO createPC(PCCreateRequestDTO pcCreateRequest);

    PCDTO updatePC(UUID pcId, PCCreateRequestDTO pcUpdateRequest);

    void deletePCById(UUID pcId);

    PCComboDataDTO getPCComboData();

    PCFilteringResponseDTO searchPC(PCFilteringRequestDTO pcFilteringRequestDTO);
}
