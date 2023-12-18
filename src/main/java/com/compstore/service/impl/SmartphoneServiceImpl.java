package com.compstore.service.impl;

import com.compstore.dto.smartphone.SmartphoneDTO;
import com.compstore.exception.NotFoundException;
import com.compstore.mapper.SmartphoneMapper;
import com.compstore.repository.SmartphoneRepository;
import com.compstore.service.ISmartphoneService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SmartphoneServiceImpl implements ISmartphoneService {

    private static final String SMARTPHONE_NOT_FOUND_MSG = "Smartphone not found with id: ";

    private final SmartphoneMapper smartphoneMapper;
    private final SmartphoneRepository smartphoneRepository;

    @Override
    public SmartphoneDTO getSmartphoneById(UUID smartphoneId) {
        return smartphoneRepository
                .findById(smartphoneId)
                .map(smartphoneMapper::toDTO)
                .orElseThrow(() -> new NotFoundException(SMARTPHONE_NOT_FOUND_MSG + smartphoneId));
    }
}
