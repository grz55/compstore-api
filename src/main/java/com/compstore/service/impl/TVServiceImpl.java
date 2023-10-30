package com.compstore.service.impl;

import com.compstore.dto.tv.TVCreateRequestDTO;
import com.compstore.entity.tv.TVEntity;
import com.compstore.repository.TVRepository;
import com.compstore.service.ITVService;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TVServiceImpl implements ITVService {

    private final TVRepository tvRepository;

    @Override
    public Optional<TVEntity> getTVById(UUID tvId) {
        return tvRepository.findById(tvId);
    }

    @Override
    public TVEntity createTV(TVCreateRequestDTO tvCreateRequestDTO) {
        return null;
    }
}
