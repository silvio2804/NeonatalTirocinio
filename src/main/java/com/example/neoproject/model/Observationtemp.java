package com.example.neoproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "observationtemp")
public class Observationtemp {
    @EmbeddedId
    private ObservationtempId id;

    @MapsId("idsensore")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idsensore", nullable = false)
    @JsonBackReference
    private Sensore idsensore;

    @Column(name = "temperatura", nullable = false)
    private Integer temperatura;

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    public Sensore getIdsensore() {
        return idsensore;
    }

    public void setIdsensore(Sensore idsensore) {
        this.idsensore = idsensore;
    }

    public ObservationtempId getId() {
        return id;
    }

    public void setId(ObservationtempId id) {
        this.id = id;
    }
}