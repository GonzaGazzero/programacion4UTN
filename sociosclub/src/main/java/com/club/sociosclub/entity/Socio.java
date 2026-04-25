package com.club.sociosclub.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String password;
    private LocalDate fechaNacimiento;
    private LocalDateTime fechaRegistro;
    private LocalDate fechaVencimientoMembresia;
    private String calle;
    private String ciudad;
    private String provincia;
    private String codigoPostal;
}
