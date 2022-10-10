package com.example.neoproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "neonato")
public class Neonato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "data_na", nullable = false)
    private LocalDate dataNa;

    @Column(name = "peso", nullable = false)
    private Double peso;

    @Column(name = "eta_gestazionale", nullable = false)
    private Integer etaGestazionale;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) //molti neonati a un posto letto
    @JoinColumn(name = "idpostoletto", nullable = false)
    @JsonBackReference
    private Postoletto idpostoletto;

    @Column(name = "datainizioricovero", nullable = false)
    private LocalDate datainizioricovero;

    @Column(name = "datafinericovero")
    private LocalDate datafinericovero;

    public LocalDate getDatafinericovero() {
        return datafinericovero;
    }

    public void setDatafinericovero(LocalDate datafinericovero) {
        this.datafinericovero = datafinericovero;
    }

    public LocalDate getDatainizioricovero() {
        return datainizioricovero;
    }

    public void setDatainizioricovero(LocalDate datainizioricovero) {
        this.datainizioricovero = datainizioricovero;
    }

    public Postoletto getIdpostoletto() {
        return idpostoletto;
    }

    public void setIdpostoletto(Postoletto idpostoletto) {
        this.idpostoletto = idpostoletto;
    }

    public Integer getEtaGestazionale() {
        return etaGestazionale;
    }

    public void setEtaGestazionale(Integer etaGestazionale) {
        this.etaGestazionale = etaGestazionale;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public LocalDate getDataNa() {
        return dataNa;
    }

    public void setDataNa(LocalDate dataNa) {
        this.dataNa = dataNa;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}