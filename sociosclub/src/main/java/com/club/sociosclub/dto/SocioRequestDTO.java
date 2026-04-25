package com.club.sociosclub.dto;

import com.club.sociosclub.validation.DniValido;
import com.club.sociosclub.validation.OnCreate;
import com.club.sociosclub.validation.OnUpdate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SocioRequestDTO {

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "{socio.nombre.notBlank}")
    private String nombre;

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "{socio.apellido.notBlank}")
    private String apellido;

    @NotBlank(groups = OnCreate.class, message = "{socio.dni.notBlank}")
    @DniValido(groups = OnCreate.class, message = "{socio.dni.valido}")
    private String dni;

    @NotBlank(groups = OnCreate.class, message = "{socio.email.notBlank}")
    @Email(groups = {OnCreate.class, OnUpdate.class}, message = "{socio.email.invalid}")
    private String email;

    @NotBlank(groups = OnCreate.class, message = "{socio.password.notBlank}")
    @Size(min = 8, groups = OnCreate.class, message = "{socio.password.size}")
    private String password;

    @NotNull(groups = OnCreate.class, message = "{socio.fechaNacimiento.notNull}")
    @Past(groups = {OnCreate.class, OnUpdate.class}, message = "{socio.fechaNacimiento.past}")
    private LocalDate fechaNacimiento;

    @NotNull(groups = OnCreate.class, message = "{socio.direccion.notNull}")
    @Valid
    private DireccionDTO direccion;
}
