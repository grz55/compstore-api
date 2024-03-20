package com.compstore.service.impl;

import com.compstore.dto.tv.TVDTO;
import com.compstore.exception.NotFoundException;
import com.compstore.mapper.TVMapper;
import com.compstore.repository.TVRepository;
import com.compstore.service.ITVService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class TVServiceImpl implements ITVService {

    private static final String TV_NOT_FOUND_MSG = "TV not found with id: ";

    private final TVMapper tvMapper;
    private final TVRepository tvRepository;

    @Override
    public TVDTO getTVById(UUID tvId) {
        log.info("Requested getting a TV with id: {}", tvId);
        return tvRepository
                .findById(tvId)
                .map(tvMapper::toDTO)
                .orElseThrow(() -> new NotFoundException(TV_NOT_FOUND_MSG + tvId));
    }
}
