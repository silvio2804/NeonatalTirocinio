package com.example.neoproject.model;

import javax.persistence.*;

@Entity
@Table(name = "neonato")
public class Neonato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpostoletto")
    private Postoletto idpostoletto;

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

    //TODO Reverse Engineering! Migrate other columns to the entity
}