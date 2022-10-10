package com.example.neoproject.service;
import com.example.neoproject.exception.NeonatoNotFoundException;
import com.example.neoproject.exception.SensoreNotFoundException;
import com.example.neoproject.model.Neonato;
import com.example.neoproject.model.Postoletto;
import com.example.neoproject.model.Reparto;
import com.example.neoproject.repository.NeonatoRepository;
import com.example.neoproject.repository.PostolettoRepository;
import com.example.neoproject.repository.RepartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostoLettoService {

    @Autowired
    private PostolettoRepository postolettoRepository;

    @Autowired
    private RepartoRepository repartoRepository;

    @Autowired
    private NeonatoRepository neonatoRepository;

    //modificare reparto
    public Postoletto addPostoLetto(String nomeReparto){
        Postoletto postoletto = new Postoletto();
        Reparto r = new Reparto();
        r.setId(nomeReparto);
        return postolettoRepository.save(postoletto);
    }

    public List <Postoletto> findAllPostiLetto(){
        return postolettoRepository.findAll();
    }

    public Postoletto findPostoLettoByNeonato(Neonato n){
        if(! neonatoRepository.existsById(n.getId()))
            throw new NeonatoNotFoundException(n.getId());
        return postolettoRepository.findPostolettoByNeonatoes(n);
    }

    public Postoletto findPostolettoById(Integer id){
        if(!postolettoRepository.existsById(id))
            throw new SensoreNotFoundException(id);
        return postolettoRepository.findPostolettoById(id);
    }
}
