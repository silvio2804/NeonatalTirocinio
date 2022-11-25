package com.example.neoproject.service;
import com.example.neoproject.exception.PostolettoNotFoundException;
import com.example.neoproject.exception.SensoreNotFoundException;
import com.example.neoproject.model.*;
import com.example.neoproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;
import java.util.Random;

@Service
public class ObservationService {
    @Autowired
    private ObservationecgRepository observationecgRepository;
    @Autowired
    private ObservationtempRepository observationtempRepository;
    @Autowired
    private SensoreEcgRepository sensoreEcgRepository;
    @Autowired
    private SensoreTempRepository sensoretempRepository;
    @Autowired
    private PostolettoRepository postolettoRepository;

    public List <Observationtemp> findAllObservationTempByIdSensore(Integer idSensore){
        if(!sensoreEcgRepository.existsById(idSensore))
            throw new SensoreNotFoundException(idSensore);
        return observationtempRepository.findByIdsensore_Idpostoletto_Id(idSensore);
    }

    public List <Observationecg> findAllObservationEcgByIdSensore(Integer idSensore){
        if(!sensoreEcgRepository.existsById(idSensore))
            throw new SensoreNotFoundException(idSensore);
        return observationecgRepository.findByIdsensore_Id(idSensore);
    }

    public Observationecg findLastObservationecg(Integer idPostoletto){
        if(!postolettoRepository.existsById(idPostoletto))
            throw new PostolettoNotFoundException(idPostoletto);
        Postoletto p = postolettoRepository.findPostolettoById(idPostoletto);
        Sensoreecg s = p.getSensoreecgs().get(0);
        return observationecgRepository.findLastObservationecg(s);
    }

    public Observationtemp findLastObservationtemp(Integer idPostoletto){
        if(!postolettoRepository.existsById(idPostoletto))
            throw new PostolettoNotFoundException(idPostoletto);
        Postoletto p = postolettoRepository.findPostolettoById(idPostoletto);
        Sensoretemp s = p.getSensoretemps().get(0);
        return observationtempRepository.findLastObservationTemp(s);
    }

    public Observationtemp addObservationtemp(Integer idSensore){
        if(!sensoretempRepository.existsById(idSensore))
            throw new SensoreNotFoundException(idSensore);
        Sensoretemp s = sensoretempRepository.findSensoreById(idSensore);
        Observationtemp o = new Observationtemp();
        ObservationtempId obsId = new ObservationtempId(Instant.now(),s.getId());
        o.setId(obsId);
        o.setTemperatura(new Random().nextInt(36,41));
        o.setIdsensore(s); //necessario settarlo
        return observationtempRepository.save(o);
    }

    public Observationecg addObservationecg(Integer idSensore){
        if(!sensoretempRepository.existsById(idSensore))
            throw new SensoreNotFoundException(idSensore);
        Sensoreecg s = sensoreEcgRepository.findSensoreById(idSensore);
        Observationecg o = new Observationecg();
        ObservationecgId obsId = new ObservationecgId(Instant.now(),s.getId());
        o.setId(obsId);
        o.setBattiti(new Random().nextInt(100,191));
        o.setSaturazione(new Random().nextInt(80,101));
        o.setIdsensore(s); //necessario settarlo
        return observationecgRepository.save(o);
    }
    public void deleteObservationtempByIdSensore(Integer idSensoretemp){
        if(!sensoretempRepository.existsById(idSensoretemp))
            throw new SensoreNotFoundException(idSensoretemp);
        Sensoretemp s = sensoretempRepository.findSensoreById(idSensoretemp);
        observationtempRepository.deleteByIdsensore(s);
    }
    public void deleteAlltemps(){
        observationtempRepository.deleteAll();
    }
    public void deleteObservationecgByIdSensore(Integer observationecg){
        observationecgRepository.deleteById(observationecg);
    }
    public void deleteAllecgs(){
        observationecgRepository.deleteAll();
    }
}


