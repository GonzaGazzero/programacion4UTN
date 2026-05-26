package com.ejer9.ejerciciodb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Productor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String cuit;

    @OneToOne(mappedBy = "productor", cascade = CascadeType.ALL)
    private PerfilProductor perfil;

    @OneToMany(mappedBy = "productor", cascade = CascadeType.ALL)
    private List<Campo> campos = new ArrayList<>();

}
