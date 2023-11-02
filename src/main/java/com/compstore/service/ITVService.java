package com.compstore.service;

import com.compstore.dto.tv.TVCreateRequestDTO;
import com.compstore.dto.tv.TVDTO;
import com.compstore.entity.tv.TVEntity;
import java.util.UUID;

public interface ITVService {

    TVDTO getTVById(UUID tvId);

    TVEntity createTV(TVCreateRequestDTO tvCreateRequestDTO);
}
