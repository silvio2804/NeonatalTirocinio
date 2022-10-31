package com.example.neoproject.service;

import com.example.neoproject.exception.NeonatoNotFoundException;
import com.example.neoproject.exception.RepartoNotFoundException;
import com.example.neoproject.map.MapStructMapper;
import com.example.neoproject.map.dto.NeonatoGetDto;
import com.example.neoproject.map.dto.NeonatoPostDto;
import com.example.neoproject.map.dto.PostolettoDto;
import com.example.neoproject.map.dto.RepartoPostDto;
import com.example.neoproject.model.Neonato;
import com.example.neoproject.model.Postoletto;
import com.example.neoproject.model.Reparto;
import com.example.neoproject.repository.NeonatoRepository;
import com.example.neoproject.repository.PostolettoRepository;
import com.example.neoproject.repository.RepartoRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NeonatoService {
    @Autowired
    private NeonatoRepository neonatoRepository;

    @Autowired
    private RepartoRepository repartoRepository;

    @Autowired
    private PostolettoRepository postolettoRepository;

    private MapStructMapper mapper = Mappers.getMapper(MapStructMapper.class);

    private Neonato neonato = new Neonato();

    public NeonatoGetDto findNeonatoById(Integer id){
        if(!neonatoRepository.existsById(id))
            throw new NeonatoNotFoundException(id);
        NeonatoGetDto n = mapper.neonatoGetDtoToNeonato(neonatoRepository.findNeonatoById(id));
        return n;
    }

    public Neonato addNeonato(NeonatoPostDto neonatoPostDto){
        Neonato n = mapper.neonatoPostDtoToNeonato(neonatoPostDto);
        Postoletto p = new Postoletto();
        if(!repartoRepository.existsById(neonatoPostDto.getNomeReparto()))
            throw new RepartoNotFoundException(neonatoPostDto.getNomeReparto());
        Reparto r = repartoRepository.findRepartoById(neonatoPostDto.getNomeReparto());
        p.setNomereparto(r);
        n.setIdpostoletto(p);
        return neonatoRepository.save(n);
    }

    public Neonato updateNeonato(Neonato n){
         neonato.setNome(n.getNome());
         neonato.setCognome(n.getCognome());
         neonato.setDataNa(n.getDataNa());
         neonato.setPeso(n.getPeso());
         neonato.setEtaGestazionale(n.getEtaGestazionale());
         neonato.setDatainizioricovero(n.getDatainizioricovero());
         neonato.setDatafinericovero(n.getDatafinericovero());
         return neonatoRepository.save(neonato);
    }
}
