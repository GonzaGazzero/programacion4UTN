package com.ejer9.ejerciciodb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Siembra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaInicio;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "lote_id")
    private Lote lote;

    @ManyToOne
    @JoinColumn(name = "cultivo_id")
    private Cultivo cultivo;

    @ManyToMany
    @JoinTable(name = "siembra_agroquimico",
            joinColumns = @JoinColumn(name = "siembra_id"),
            inverseJoinColumns = @JoinColumn(name = "agroquimico_id"))
    private List<Agroquimico> agroquimicos = new ArrayList<>();

}
