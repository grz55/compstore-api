package com.compstore.service;

import com.compstore.dto.smartphone.SmartphoneCreateRequestDTO;
import com.compstore.dto.smartphone.SmartphoneDTO;
import com.compstore.entity.smartphone.SmartphoneEntity;
import java.util.UUID;

public interface ISmartphoneService {

    SmartphoneDTO getSmartphoneById(UUID smartphoneId);

    SmartphoneEntity createSmartphone(SmartphoneCreateRequestDTO smartphoneCreateRequestDTO);
}
