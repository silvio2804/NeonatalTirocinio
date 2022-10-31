package com.example.neoproject.map;

import com.example.neoproject.map.dto.NeonatoGetDto;
import com.example.neoproject.map.dto.NeonatoPostDto;
import com.example.neoproject.map.dto.PostolettoDto;
import com.example.neoproject.map.dto.RepartoPostDto;
import com.example.neoproject.model.Neonato;
import com.example.neoproject.model.Postoletto;
import com.example.neoproject.model.Reparto;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {

    Postoletto postolettoPostDtoToPostoletto(PostolettoDto postolettoDto);
    Reparto repartoPostDtoToReparto(RepartoPostDto repartoPostDto);

    Neonato neonatoPostDtoToNeonato(NeonatoPostDto neonatoPostDto);
    NeonatoGetDto neonatoGetDtoToNeonato(Neonato neonato);
}
