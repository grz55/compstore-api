package com.compstore.controller;

import com.compstore.dto.pc.PCCreateRequestDTO;
import com.compstore.entity.pc.PCEntity;
import com.compstore.service.IPCService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pcs")
@AllArgsConstructor
@Tag(name = "PCController")
public class PCController {

    private final IPCService pcService;

    @GetMapping("/{pcId}")
    public ResponseEntity<PCEntity> getPCById(@PathVariable UUID pcId) {
        Optional<PCEntity> pcFound = pcService.getPCById(pcId);
        return pcFound.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PCEntity> createPC(@RequestBody PCCreateRequestDTO pcCreateRequestDTO) {
        PCEntity createdPC = pcService.createPC(pcCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPC);
    }
}
