package com.example.neoproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "postoletto")
public class Postoletto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nomereparto")
    private Reparto nomereparto;

    @OneToMany(mappedBy = "idpostoletto")
    @JsonManagedReference
    private List<Neonato> neonatoes = new ArrayList<>();

    @OneToMany(mappedBy = "idpostoletto")
    @JsonManagedReference
    private List<Dashboard> dashboards = new ArrayList<>();

    @OneToMany(mappedBy = "idpostoletto")
    @JsonManagedReference
    private List<Sensore> sensores = new ArrayList<>();

    public List<Sensore> getSensores() {
        return sensores;
    }

    public void setSensores(List<Sensore> sensores) {
        this.sensores = sensores;
    }

    public List<Dashboard> getDashboards() {
        return dashboards;
    }

    public void setDashboards(List<Dashboard> dashboards) {
        this.dashboards = dashboards;
    }

    public List<Neonato> getNeonatoes() {
        return neonatoes;
    }

    public void setNeonatoes(List<Neonato> neonatoes) {
        this.neonatoes = neonatoes;
    }

    public Reparto getNomereparto() {
        return nomereparto;
    }

    public void setNomereparto(Reparto nomereparto) {
        this.nomereparto = nomereparto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}