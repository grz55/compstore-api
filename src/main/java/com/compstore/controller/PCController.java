package com.compstore.controller;

import com.compstore.dto.pc.PCComboDataDTO;
import com.compstore.dto.pc.PCCreateRequestDTO;
import com.compstore.dto.pc.PCDTO;
import com.compstore.dto.pc.PCFilteringRequestDTO;
import com.compstore.dto.pc.PCFilteringResponseDTO;
import com.compstore.service.IPCService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pcs")
@AllArgsConstructor
@Tag(name = "PCController")
public class PCController {

    private final IPCService pcService;

    @GetMapping("/{pcId}")
    public ResponseEntity<PCDTO> getPCById(@PathVariable UUID pcId) {
        return ResponseEntity.status(HttpStatus.OK).body(pcService.getPCById(pcId));
    }

    @PostMapping("/search")
    public ResponseEntity<PCFilteringResponseDTO> searchPC(
            @RequestBody PCFilteringRequestDTO pcFilteringRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(pcService.searchPC(pcFilteringRequestDTO));
    }

    @PostMapping
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<PCDTO> createPC(@RequestBody PCCreateRequestDTO pcCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pcService.createPC(pcCreateRequest));
    }

    @PutMapping("/{pcId}")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<PCDTO> updatePC(
            @PathVariable UUID pcId, @RequestBody PCCreateRequestDTO pcUpdateRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(pcService.updatePC(pcId, pcUpdateRequest));
    }

    @DeleteMapping("/{pcId}")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<Void> deletePCById(@PathVariable UUID pcId) {
        pcService.deletePCById(pcId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/combo-data")
    public ResponseEntity<PCComboDataDTO> getPCComboData() {
        return ResponseEntity.status(HttpStatus.OK).body(pcService.getPCComboData());
    }
}
