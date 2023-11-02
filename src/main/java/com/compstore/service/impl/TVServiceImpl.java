package com.compstore.service.impl;

import com.compstore.dto.tv.TVCreateRequestDTO;
import com.compstore.dto.tv.TVDTO;
import com.compstore.entity.tv.TVEntity;
import com.compstore.exception.NotFoundException;
import com.compstore.mapper.TVMapper;
import com.compstore.repository.TVRepository;
import com.compstore.service.ITVService;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TVServiceImpl implements ITVService {

    private final TVMapper tvMapper;
    private final TVRepository tvRepository;

    @Override
    public TVDTO getTVById(UUID tvId) {
        Optional<TVEntity> tvById = tvRepository.findById(tvId);
        if (tvById.isPresent()) {
            return tvMapper.toDTO(tvById.get());
        } else {
            throw new NotFoundException("TV not found with id: " + tvId);
        }
    }

    @Override
    public TVEntity createTV(TVCreateRequestDTO tvCreateRequestDTO) {
        return null;
    }
}
