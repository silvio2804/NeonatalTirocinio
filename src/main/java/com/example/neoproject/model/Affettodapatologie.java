package com.example.neoproject.model;

import javax.persistence.*;

@Entity
@Table(name = "affettodapatologie")
public class Affettodapatologie {
    @EmbeddedId
    private AffettodapatologieId id;

    @MapsId("idneonato")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idneonato", nullable = false)
    private Neonato idneonato;

    @MapsId("nomepatologia")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nomepatologia", nullable = false)
    private Patologia nomepatologia;

    public Patologia getNomepatologia() {
        return nomepatologia;
    }

    public void setNomepatologia(Patologia nomepatologia) {
        this.nomepatologia = nomepatologia;
    }

    public Neonato getIdneonato() {
        return idneonato;
    }

    public void setIdneonato(Neonato idneonato) {
        this.idneonato = idneonato;
    }

    public AffettodapatologieId getId() {
        return id;
    }

    public void setId(AffettodapatologieId id) {
        this.id = id;
    }
}