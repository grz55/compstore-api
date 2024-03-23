package com.compstore.controller;

import com.compstore.dto.dictionary.ProcessorBrandComboDataDTO;
import com.compstore.dto.dictionary.ProcessorBrandCreateRequestDTO;
import com.compstore.dto.dictionary.ProcessorBrandDTO;
import com.compstore.service.IProcessorBrandService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/processor-brands")
@AllArgsConstructor
@Tag(name = "ProcessorBrandController")
public class ProcessorBrandController {

    private final IProcessorBrandService processorBrandService;

    @GetMapping
    public ResponseEntity<List<ProcessorBrandDTO>> getAllProcessorBrands() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(processorBrandService.getAllProcessorBrands());
    }

    @GetMapping("/{processorBrandId}")
    public ResponseEntity<ProcessorBrandDTO> getProcessorBrandById(
            @PathVariable UUID processorBrandId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(processorBrandService.getProcessorBrandById(processorBrandId));
    }

    @PostMapping
    public ResponseEntity<Void> createProcessorBrand(
            @Valid @RequestBody ProcessorBrandCreateRequestDTO processorBrandCreateRequestDTO) {
        processorBrandService.createProcessorBrand(processorBrandCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{processorBrandId}")
    public ResponseEntity<Void> updateProcessorBrand(
            @PathVariable UUID processorBrandId,
            @Valid @RequestBody ProcessorBrandCreateRequestDTO processorBrandUpdateRequest) {
        processorBrandService.updateProcessorBrand(processorBrandId, processorBrandUpdateRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{processorBrandId}")
    public ResponseEntity<Void> deleteProcessorBrandById(@PathVariable UUID processorBrandId) {
        processorBrandService.deleteProcessorBrandById(processorBrandId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/combo-data")
    public ResponseEntity<ProcessorBrandComboDataDTO> getProcessorBrandComboData() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(processorBrandService.getProcessorBrandComboData());
    }
}
