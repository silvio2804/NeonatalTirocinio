package com.example.neoproject.model;

import javax.persistence.*;

@Entity
@Table(name = "reparto")
public class Reparto {
    @Id
    @Column(name = "nome", nullable = false)
    private String id;

    @Column(name = "ospedale", nullable = false)
    private String ospedale;

    @Column(name = "livello", nullable = false)
    private Integer livello;

    public Integer getLivello() {
        return livello;
    }

    public void setLivello(Integer livello) {
        this.livello = livello;
    }

    public String getOspedale() {
        return ospedale;
    }

    public void setOspedale(String ospedale) {
        this.ospedale = ospedale;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}