package com.compstore.service.impl;

import com.compstore.dto.smartphone.SmartphoneCreateRequestDTO;
import com.compstore.dto.smartphone.SmartphoneDTO;
import com.compstore.entity.smartphone.SmartphoneEntity;
import com.compstore.exception.NotFoundException;
import com.compstore.mapper.SmartphoneMapper;
import com.compstore.repository.SmartphoneRepository;
import com.compstore.service.ISmartphoneService;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SmartphoneServiceImpl implements ISmartphoneService {

    private final SmartphoneMapper smartphoneMapper;
    private final SmartphoneRepository smartphoneRepository;

    @Override
    public SmartphoneDTO getSmartphoneById(UUID smartphoneId) {
        Optional<SmartphoneEntity> smartphoneById = smartphoneRepository.findById(smartphoneId);
        if (smartphoneById.isPresent()) {
            return smartphoneMapper.toDTO(smartphoneById.get());
        } else {
            throw new NotFoundException("Smartphone not found with id: " + smartphoneId);
        }
    }

    @Override
    public SmartphoneEntity createSmartphone(
            SmartphoneCreateRequestDTO smartphoneCreateRequestDTO) {
        return null;
    }
}
