package com.example.neoproject.service;
import com.example.neoproject.exception.PostolettoNotFoundException;
import com.example.neoproject.exception.SensoreNotFoundException;
import com.example.neoproject.jsonRequest.SensoreEcgRequest;
import com.example.neoproject.model.*;
import com.example.neoproject.repository.ObservationecgRepository;
import com.example.neoproject.repository.ObservationtempRepository;
import com.example.neoproject.repository.PostolettoRepository;
import com.example.neoproject.repository.SensoreEcgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//qui creare le Observation in maniera randomica
@Service
public class SensoreService {

    @Autowired
    private SensoreEcgRepository sensoreEcgRepository;

    @Autowired
    private PostolettoRepository postolettoRepository;

    @Autowired
    private ObservationecgRepository obsEcgRepository;

    @Autowired
    private ObservationtempRepository obsTempRepository;

 //testare
    //quando creo un sensore, associo direttamente il posto letto associato
    /*public Sensoreecg addSensoreEcg(){
        if(!postolettoRepository.existsById(IdPostoLetto))
            throw new PostolettoNotFoundException(IdPostoLetto);
        Postoletto postoletto = postolettoRepository.findPostolettoById(IdPostoLetto);
        Sensoreecg s = new Sensoreecg();
        s.setIdpostoletto(postoletto);
        return sensoreEcgRepository.save(s);
    }*/

    public List<Sensoreecg> findSensoriEcgByIdPostoLetto(Integer idPostoLetto){
        if(!postolettoRepository.existsById(idPostoLetto))
            throw new PostolettoNotFoundException(idPostoLetto);
        return sensoreEcgRepository.findSensoreByIdpostoletto(postolettoRepository.findPostolettoById(idPostoLetto));
    }

    public Sensoreecg findSensoreEcgById(Integer id){
        if(!sensoreEcgRepository.existsById(id))
            throw new SensoreNotFoundException(id);
        return sensoreEcgRepository.findSensoreById(id);
    }

    private List<Observationecg> randomObservationEcg(){
        return null;
    }

    /*private List<Observationtemp> randomObservationTemp() {
        List<Observationtemp> listObs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Observationtemp obs = new Observationtemp();
            obs.setTemperatura(new Random().nextInt(37, 40));
            List<Sensore> sensores = sensoreEcgRepository.findAll();
            Sensore s = sensores.get(new Random().nextInt(0, sensores.size() - 1));
            obs.setIdsensore(s);
            ObservationtempId observationtempId = new ObservationtempId(); //embedded
            observationtempId.setDataRilevazione(Instant.now());
            observationtempId.setIdsensore(s.getId());
            obs.setId(observationtempId);
            listObs.add(obs);
        }
        return listObs;
    }*/

    public List<Sensoreecg> findAllSensoriEcg () {
        return sensoreEcgRepository.findAll();
    }

    }
