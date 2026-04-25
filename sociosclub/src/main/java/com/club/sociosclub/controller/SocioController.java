package com.club.sociosclub.controller;

import com.club.sociosclub.dto.SocioRequestDTO;
import com.club.sociosclub.dto.SocioResponseDTO;
import com.club.sociosclub.service.SocioService;
import com.club.sociosclub.validation.OnCreate;
import com.club.sociosclub.validation.OnUpdate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/socios")
public class SocioController {

    private final SocioService socioService;

    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    @PostMapping
    public ResponseEntity<SocioResponseDTO> crearSocio(@Validated(OnCreate.class) @RequestBody SocioRequestDTO dto) {
        SocioResponseDTO response = socioService.crearSocio(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SocioResponseDTO> actualizarSocio(@PathVariable Long id, @Validated(OnUpdate.class) @RequestBody SocioRequestDTO dto) {
        SocioResponseDTO response = socioService.actualizarSocio(id, dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
