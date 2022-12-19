package com.example.neoproject.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.Instant;

@Data
@Embeddable
public class ObservationtempId implements Serializable {
    private static final long serialVersionUID = 2198908211493412444L;
    @Column(name = "data_rilevazione", nullable = false)
    private Instant dataRilevazione;
    @Column(name = "idsensore", nullable = false)
    private Integer idsensore;

    public ObservationtempId (){
    }

    public ObservationtempId(Instant dataRilevazione, Integer idsensore) {
        this.dataRilevazione = dataRilevazione;
        this.idsensore = idsensore;
    }
}