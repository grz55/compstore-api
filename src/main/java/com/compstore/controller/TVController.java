package com.compstore.controller;

import com.compstore.dto.tv.TVCreateRequestDTO;
import com.compstore.entity.tv.TVEntity;
import com.compstore.service.ITVService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Optional;
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
    public ResponseEntity<TVEntity> getTVById(@PathVariable UUID tvId) {
        Optional<TVEntity> tvFound = tvService.getTVById(tvId);
        return tvFound.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TVEntity> createTV(@RequestBody TVCreateRequestDTO tvCreateRequestDTO) {
        TVEntity createdTV = tvService.createTV(tvCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTV);
    }
}
