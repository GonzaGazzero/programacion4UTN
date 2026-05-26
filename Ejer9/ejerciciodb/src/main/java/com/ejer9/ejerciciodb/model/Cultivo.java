package com.ejer9.ejerciciodb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Cultivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String tipoGrano;

    @OneToMany(mappedBy = "cultivo", cascade = CascadeType.ALL)
    private List<Siembra> siembras = new ArrayList<>();

}
