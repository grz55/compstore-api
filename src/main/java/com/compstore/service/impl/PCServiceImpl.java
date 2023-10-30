package com.compstore.service.impl;

import com.compstore.dto.pc.PCCreateRequestDTO;
import com.compstore.entity.pc.PCEntity;
import com.compstore.repository.PCRepository;
import com.compstore.service.IPCService;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PCServiceImpl implements IPCService {

    private final PCRepository pcRepository;

    @Override
    public Optional<PCEntity> getPCById(UUID pcId) {
        return pcRepository.findById(pcId);
    }

    @Override
    public PCEntity createPC(PCCreateRequestDTO pcCreateRequestDTO) {
        return null;
    }
}
