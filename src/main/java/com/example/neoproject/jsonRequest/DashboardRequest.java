package com.example.neoproject.jsonRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DashboardRequest {

    //neonato
    //posto letto -> gia esiste
    @JsonProperty("idPostoletto")
    private Integer idPostoletto;

    @JsonProperty("tipoSensore")
    private String tipoSensore;
    @JsonProperty("posizione")
    private Integer posizione;
    @JsonProperty("dimensione")
    private Integer dimensione;


    public Integer getIdPostoletto() {
        return idPostoletto;
    }

    public void setIdPostoletto(Integer idPostoletto) {
        this.idPostoletto = idPostoletto;
    }

    public String getTipoSensore() {
        return tipoSensore;
    }

    public void setTipoSensore(String tipoSensore) {
        this.tipoSensore = tipoSensore;
    }

    public Integer getPosizione() {
        return posizione;
    }

    public void setPosizione(Integer posizione) {
        this.posizione = posizione;
    }

    public Integer getDimensione() {
        return dimensione;
    }

    public void setDimensione(Integer dimensione) {
        this.dimensione = dimensione;
    }
}
