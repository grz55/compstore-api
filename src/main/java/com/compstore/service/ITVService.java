package com.compstore.service;

import com.compstore.dto.tv.TVCreateRequestDTO;
import com.compstore.entity.tv.TVEntity;
import java.util.Optional;
import java.util.UUID;

public interface ITVService {

    Optional<TVEntity> getTVById(UUID tvId);

    TVEntity createTV(TVCreateRequestDTO tvCreateRequestDTO);
}
