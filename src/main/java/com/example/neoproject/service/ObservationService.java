package com.example.neoproject.service;
import com.example.neoproject.exception.SensoreNotFoundException;
import com.example.neoproject.model.Observationecg;
import com.example.neoproject.model.Observationtemp;
import com.example.neoproject.model.Sensore;
import com.example.neoproject.repository.ObservationecgRepository;
import com.example.neoproject.repository.ObservationtempRepository;
import com.example.neoproject.repository.SensoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObservationService {

    @Autowired
    private ObservationecgRepository observationecgRepository;

    @Autowired
    private ObservationtempRepository observationtempRepository;

    @Autowired
    private SensoreRepository sensoreRepository;

    public List <Observationtemp> findObservationTempByIdSensore(Sensore sensore){
        if(!sensoreRepository.existsById(sensore.getId()))
            throw new SensoreNotFoundException(sensore.getId());
        return observationtempRepository.findObservationtempByIdsensore(sensore);
    }

    public List <Observationecg> findObservationEgcByIdSensore(Sensore sensore){
        if(!sensoreRepository.existsById(sensore.getId()))
            throw new SensoreNotFoundException(sensore.getId());
        return observationecgRepository.findObservationecgByIdsensore(sensore);
    }
}
