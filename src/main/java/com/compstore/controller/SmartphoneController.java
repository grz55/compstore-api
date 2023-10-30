package com.compstore.controller;

import com.compstore.dto.smartphone.SmartphoneCreateRequestDTO;
import com.compstore.entity.smartphone.SmartphoneEntity;
import com.compstore.service.ISmartphoneService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/smartphones")
@AllArgsConstructor
@Tag(name = "SmartphoneController")
public class SmartphoneController {

    private final ISmartphoneService smartphoneService;

    @GetMapping("/{smartphoneId}")
    public ResponseEntity<SmartphoneEntity> getSmartphoneById(@PathVariable UUID smartphoneId) {
        Optional<SmartphoneEntity> smartphoneFound =
                smartphoneService.getSmartphoneById(smartphoneId);
        return smartphoneFound
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SmartphoneEntity> createSmartphone(
            @RequestBody SmartphoneCreateRequestDTO smartphoneCreateRequestDTO) {
        SmartphoneEntity createdSmartphone =
                smartphoneService.createSmartphone(smartphoneCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSmartphone);
    }
}
