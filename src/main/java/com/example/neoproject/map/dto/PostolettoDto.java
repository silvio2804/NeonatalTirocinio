package com.example.neoproject.map.dto;

import com.example.neoproject.model.Reparto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostolettoDto {

    @JsonProperty("idPostoletto")
    private Integer idPostoletto;

    @JsonProperty("reparto")
    private Reparto reparto;
}
