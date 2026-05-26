package com.ejer9.ejerciciodb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Campo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private Double hectareasTotales;

    @ManyToOne
    @JoinColumn(name = "productor_id")
    private Productor productor;

    @OneToMany(mappedBy = "campo", cascade = CascadeType.ALL)
    private List<Lote> lotes = new ArrayList<>();

}
