package com.compstore.service;

import com.compstore.dto.smartphone.SmartphoneCreateRequestDTO;
import com.compstore.entity.smartphone.SmartphoneEntity;
import java.util.Optional;
import java.util.UUID;

public interface ISmartphoneService {

    Optional<SmartphoneEntity> getSmartphoneById(UUID smartphoneId);

    SmartphoneEntity createSmartphone(SmartphoneCreateRequestDTO smartphoneCreateRequestDTO);
}
