package com.example.neoproject.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Embeddable
public class ObservationtempId implements Serializable {
    private static final long serialVersionUID = 2198908211493412444L;
    @Column(name = "data_rilevazione", nullable = false)
    private Instant dataRilevazione;
    @Column(name = "idsensore", nullable = false)
    private Integer idsensore;

    public Integer getIdsensore() {
        return idsensore;
    }

    public void setIdsensore(Integer idsensore) {
        this.idsensore = idsensore;
    }

    public Instant getDataRilevazione() {
        return dataRilevazione;
    }

    public void setDataRilevazione(Instant dataRilevazione) {
        this.dataRilevazione = dataRilevazione;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idsensore, dataRilevazione);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ObservationtempId entity = (ObservationtempId) o;
        return Objects.equals(this.idsensore, entity.idsensore) &&
                Objects.equals(this.dataRilevazione, entity.dataRilevazione);
    }
}