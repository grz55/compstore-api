package com.compstore.service;

import com.compstore.dto.smartphone.SmartphoneDTO;
import java.util.UUID;

public interface ISmartphoneService {

    SmartphoneDTO getSmartphoneById(UUID smartphoneId);
}
