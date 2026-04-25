package com.club.sociosclub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class DireccionDTO {

    @NotBlank(message = "{direccion.calle.notBlank}")
    @Size(min = 5, max = 150, message = "{direccion.calle.size}")
    private String calle;

    @NotBlank(message = "{direccion.ciudad.notBlank}")
    @Size(min = 3, max = 80, message = "{direccion.ciudad.size}")
    private String ciudad;

    @NotBlank(message = "{direccion.provincia.notBlank}")
    private String provincia;

    @NotBlank(message = "{direccion.codigoPostal.notBlank}")
    @Pattern(regexp = "\\d{4}", message = "{direccion.codigoPostal.pattern}")
    private String codigoPostal;
}
