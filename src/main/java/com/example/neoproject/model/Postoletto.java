package com.example.neoproject.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "postoletto")
public class Postoletto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "idpostoletto")
    private Set<Neonato> neonatoes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idpostoletto")
    private Set<Sensore> sensores = new LinkedHashSet<>();

    public Set<Sensore> getSensores() {
        return sensores;
    }

    public void setSensores(Set<Sensore> sensores) {
        this.sensores = sensores;
    }

    public Set<Neonato> getNeonatoes() {
        return neonatoes;
    }

    public void setNeonatoes(Set<Neonato> neonatoes) {
        this.neonatoes = neonatoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}