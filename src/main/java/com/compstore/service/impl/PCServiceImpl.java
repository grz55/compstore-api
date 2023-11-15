package com.compstore.service.impl;

import com.compstore.dto.pc.PCComboDataDTO;
import com.compstore.dto.pc.PCDTO;
import com.compstore.entity.enums.PCDriveType;
import com.compstore.entity.pc.PCEntity;
import com.compstore.entity.pc.PCGraphicsCardBrandEntity;
import com.compstore.entity.pc.PCOperatingSystemEntity;
import com.compstore.entity.pc.PCProcessorBrandEntity;
import com.compstore.exception.NotFoundException;
import com.compstore.mapper.PCMapper;
import com.compstore.repository.pc.PCGraphicsCardBrandRepository;
import com.compstore.repository.pc.PCOperatingSystemRepository;
import com.compstore.repository.pc.PCProcessorBrandRepository;
import com.compstore.repository.pc.PCRepository;
import com.compstore.service.IPCService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PCServiceImpl implements IPCService {

    private final PCMapper pcMapper;
    private final PCRepository pcRepository;

    private final PCProcessorBrandRepository pcProcessorBrandRepository;
    private final PCGraphicsCardBrandRepository pcGraphicsCardBrandRepository;
    private final PCOperatingSystemRepository pcOperatingSystemRepository;

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
    public PCComboDataDTO getPCComboData() {
        List<PCProcessorBrandEntity> allPCProcessorBrands = fetchAllPCProcessorBrands();
        List<PCGraphicsCardBrandEntity> allPCGraphicsCardBrands = fetchAllPCGraphicsCardBrands();
        List<PCOperatingSystemEntity> allPCOperatingSystems = fetchAllPCOperatingSystems();
        return pcMapper.toPCComboDataDTO(
                allPCProcessorBrands,
                allPCGraphicsCardBrands,
                PCDriveType.values(),
                allPCOperatingSystems);
    }

    private List<PCProcessorBrandEntity> fetchAllPCProcessorBrands() {
        return pcProcessorBrandRepository.findAll();
    }

    private List<PCGraphicsCardBrandEntity> fetchAllPCGraphicsCardBrands() {
        return pcGraphicsCardBrandRepository.findAll();
    }

    private List<PCOperatingSystemEntity> fetchAllPCOperatingSystems() {
        return pcOperatingSystemRepository.findAll();
    }
}
