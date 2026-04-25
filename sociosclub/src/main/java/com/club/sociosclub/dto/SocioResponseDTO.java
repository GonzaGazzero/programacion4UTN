package com.club.sociosclub.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SocioResponseDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDateTime fechaRegistro;
    private String estadoMembresia;
    private DireccionDTO direccion;
}
