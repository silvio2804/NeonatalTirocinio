package com.example.neoproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "observationtemp")
public class Observationtemp {
    @EmbeddedId
    private ObservationtempId id;

    @MapsId("idsensore")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idsensore", nullable = false)
    @JsonBackReference
    private Sensoretemp idsensore;

    @Column(name = "temperatura", nullable = false)
    private Integer temperatura;
}