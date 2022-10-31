package com.example.neoproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "neonato")
public class Neonato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "data_na", nullable = false)
    private LocalDate dataNa;

    @Column(name = "peso", nullable = false)
    private Double peso;

    @Column(name = "eta_gestazionale", nullable = false)
    private Integer etaGestazionale;

    @ManyToOne(fetch = FetchType.LAZY, optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "idpostoletto", nullable = false)
    @JsonBackReference
    private Postoletto idpostoletto;

    @Column(name = "datainizioricovero", nullable = false)
    private LocalDate datainizioricovero;

    @Column(name = "datafinericovero")
    private LocalDate datafinericovero;

    @ManyToMany
    @JoinTable(name = "affettodapatologie",
            joinColumns = @JoinColumn(name = "idneonato"),
            inverseJoinColumns = @JoinColumn(name = "nomepatologia"))
    private List<Patologia> patologias = new ArrayList<>();

}