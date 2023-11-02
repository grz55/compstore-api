package com.compstore.controller;

import com.compstore.dto.tv.TVCreateRequestDTO;
import com.compstore.dto.tv.TVDTO;
import com.compstore.entity.tv.TVEntity;
import com.compstore.service.ITVService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tvs")
@AllArgsConstructor
@Tag(name = "TVController")
public class TVController {

    private final ITVService tvService;

    @GetMapping("/{tvId}")
    public ResponseEntity<TVDTO> getTVById(@PathVariable UUID tvId) {
        return ResponseEntity.status(HttpStatus.OK).body(tvService.getTVById(tvId));
    }

    @PostMapping
    public ResponseEntity<TVEntity> createTV(@RequestBody TVCreateRequestDTO tvCreateRequestDTO) {
        TVEntity createdTV = tvService.createTV(tvCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTV);
    }
}
