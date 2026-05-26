package com.ejer9.ejerciciodb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numero;

    private Double superficie;

    @ManyToOne
    @JoinColumn(name = "campo_id")
    private Campo campo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "suelo_id")
    private Suelo suelo;

    @OneToMany(mappedBy = "lote", cascade = CascadeType.ALL)
    private List<Siembra> siembras = new ArrayList<>();

}
