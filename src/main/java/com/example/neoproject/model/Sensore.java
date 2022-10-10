package com.example.neoproject.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
@Table(name = "sensore")
public class Sensore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "posizione", nullable = false)
    private Integer posizione;

    @Column(name = "dimensione", nullable = false)
    private Integer dimensione;

    @Column(name = "tipologia", nullable = false)
    private String tipologia;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idpostoletto", nullable = false)
    @JsonBackReference
    private Postoletto idpostoletto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "iddashboard", nullable = false)
    @JsonBackReference
    private Dashboard iddashboard;

    public Dashboard getIddashboard() {
        return iddashboard;
    }

    public void setIddashboard(Dashboard iddashboard) {
        this.iddashboard = iddashboard;
    }

    public Postoletto getIdpostoletto() {
        return idpostoletto;
    }

    public void setIdpostoletto(Postoletto idpostoletto) {
        this.idpostoletto = idpostoletto;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public Integer getDimensione() {
        return dimensione;
    }

    public void setDimensione(Integer dimensione) {
        this.dimensione = dimensione;
    }

    public Integer getPosizione() {
        return posizione;
    }

    public void setPosizione(Integer posizione) {
        this.posizione = posizione;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}