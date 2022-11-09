package com.example.neoproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString(exclude = "idsensore")
@Entity
@Table(name = "observationecg")
public class Observationecg {
    @EmbeddedId
    private ObservationecgId id;

    @MapsId("idsensore")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idsensore", nullable = false)
    @JsonBackReference
    private Sensoreecg idsensore;

    @Column(name = "battiti", nullable = false)
    private Integer battiti;

    @Column(name = "saturazione", nullable = false)
    private Integer saturazione;
}