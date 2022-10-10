package com.example.neoproject.service;
import com.example.neoproject.exception.PostolettoNotFoundException;
import com.example.neoproject.exception.SensoreNotFoundException;
import com.example.neoproject.model.Postoletto;
import com.example.neoproject.model.Sensore;
import com.example.neoproject.repository.PostolettoRepository;
import com.example.neoproject.repository.SensoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SensoreService {

    @Autowired
    private SensoreRepository sensoreRepository;

    @Autowired
    private PostolettoRepository postolettoRepository;

    public Sensore addSensore(Integer pos, Integer dim, String tipologia, Integer IdPostoLetto){
        if(!postolettoRepository.existsById(IdPostoLetto))
            throw new PostolettoNotFoundException(IdPostoLetto);
        Postoletto postoletto = postolettoRepository.findPostolettoById(IdPostoLetto);
        Sensore s = new Sensore();
        s.setPosizione(pos);
        s.setDimensione(dim);
        s.setTipologia(tipologia);
        s.setIdpostoletto(postoletto);
        return sensoreRepository.save(s);
    }

    public List<Sensore> findSensoriByIdPostoLetto(Integer idPostoLetto){
        if(!postolettoRepository.existsById(idPostoLetto))
            throw new PostolettoNotFoundException(idPostoLetto);
        return sensoreRepository.findSensoreByIdpostoletto(postolettoRepository.findPostolettoById(idPostoLetto));
    }

    public Sensore findSensoreById(Integer id){
        if(!sensoreRepository.existsById(id))
            throw new SensoreNotFoundException(id);
        return sensoreRepository.findSensoreById(id);
    }
}
