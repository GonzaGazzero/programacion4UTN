package com.ejer9.ejerciciodb.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Suelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    private Double ph;

}
