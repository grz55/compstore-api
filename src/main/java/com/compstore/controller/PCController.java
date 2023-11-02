package com.compstore.controller;

import com.compstore.dto.pc.PCDTO;
import com.compstore.service.IPCService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    public ResponseEntity<PCDTO> getPCById(@PathVariable UUID pcId) {
        return ResponseEntity.status(HttpStatus.OK).body(pcService.getPCById(pcId));
    }
}
