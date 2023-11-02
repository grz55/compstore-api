package com.compstore.service.impl;

import com.compstore.dto.pc.PCCreateRequestDTO;
import com.compstore.dto.pc.PCDTO;
import com.compstore.entity.pc.PCEntity;
import com.compstore.exception.NotFoundException;
import com.compstore.mapper.PCMapper;
import com.compstore.repository.PCRepository;
import com.compstore.service.IPCService;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PCServiceImpl implements IPCService {

    private final PCMapper pcMapper;
    private final PCRepository pcRepository;

    @Override
    public PCDTO getPCById(UUID pcId) {
        Optional<PCEntity> pcById = pcRepository.findById(pcId);
        if (pcById.isPresent()) {
            return pcMapper.toDTO(pcById.get());
        } else {
            throw new NotFoundException("PC not found with id: " + pcId);
        }
    }

    @Override
    public PCEntity createPC(PCCreateRequestDTO pcCreateRequestDTO) {
        return null;
    }
}
