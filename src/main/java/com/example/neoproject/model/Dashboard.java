package com.example.neoproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "dashboard")
public class Dashboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idpostoletto", nullable = false)
    @JsonBackReference
    private Postoletto idpostoletto;

    @OneToMany(mappedBy = "iddashboard")
    @JsonManagedReference
    private List<Sensore> sensores = new ArrayList<>();

    public List <Sensore> getSensores() {
        return sensores;
    }

    public void setSensores(List<Sensore> sensores) {
        this.sensores = sensores;
    }

    public Postoletto getIdpostoletto() {
        return idpostoletto;
    }

    public void setIdpostoletto(Postoletto idpostoletto) {
        this.idpostoletto = idpostoletto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}