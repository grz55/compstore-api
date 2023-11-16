package com.compstore.service;

import com.compstore.dto.pc.PCDTO;
import com.compstore.dto.pc.PCFilteringRequestDTO;
import com.compstore.dto.pc.PCFilteringResponseDTO;
import java.util.UUID;

public interface IPCService {

    PCDTO getPCById(UUID pcId);

    PCFilteringResponseDTO searchPC(PCFilteringRequestDTO pcFilteringRequestDTO);
}
