package com.ejer9.ejerciciodb.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PerfilProductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String contactoEmergencia;

    private String observaciones;

    @OneToOne
    @JoinColumn(name = "productor_id")
    private Productor productor;

}
