package com.example.neoproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "observationecg")
public class Observationecg {
    @EmbeddedId
    private ObservationecgId id;

    @MapsId("idsensore")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idsensore", nullable = false)
    @JsonBackReference
    private Sensore idsensore;

    @Column(name = "battiti", nullable = false)
    private Integer battiti;

    @Column(name = "saturazione", nullable = false)
    private Integer saturazione;

    public Integer getSaturazione() {
        return saturazione;
    }

    public void setSaturazione(Integer saturazione) {
        this.saturazione = saturazione;
    }

    public Integer getBattiti() {
        return battiti;
    }

    public void setBattiti(Integer battiti) {
        this.battiti = battiti;
    }

    public Sensore getIdsensore() {
        return idsensore;
    }

    public void setIdsensore(Sensore idsensore) {
        this.idsensore = idsensore;
    }

    public ObservationecgId getId() {
        return id;
    }

    public void setId(ObservationecgId id) {
        this.id = id;
    }
}