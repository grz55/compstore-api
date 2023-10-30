package com.compstore.service.impl;

import com.compstore.dto.smartphone.SmartphoneCreateRequestDTO;
import com.compstore.entity.smartphone.SmartphoneEntity;
import com.compstore.repository.SmartphoneRepository;
import com.compstore.service.ISmartphoneService;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SmartphoneServiceImpl implements ISmartphoneService {

    private final SmartphoneRepository smartphoneRepository;

    @Override
    public Optional<SmartphoneEntity> getSmartphoneById(UUID smartphoneId) {
        return Optional.empty();
    }

    @Override
    public SmartphoneEntity createSmartphone(
            SmartphoneCreateRequestDTO smartphoneCreateRequestDTO) {
        return null;
    }
}
