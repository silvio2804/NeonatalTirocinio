package com.example.neoproject.model;

import javax.persistence.*;

@Entity
@Table(name = "patologia")
public class Patologia {
    @Id
    @Column(name = "nome", nullable = false)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //TODO Reverse Engineering! Migrate other columns to the entity
}