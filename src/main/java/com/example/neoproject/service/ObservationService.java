package com.example.neoproject.service;
import com.example.neoproject.exception.PostolettoNotFoundException;
import com.example.neoproject.exception.SensoreNotFoundException;
import com.example.neoproject.map.dtos.observation.DateDto;
import com.example.neoproject.model.*;
import com.example.neoproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
    private SensoretempRepository sensoretempRepository;
    @Autowired
    private PostolettoRepository postolettoRepository;

    public List <Observationtemp> findObservationTempByIdSensore(Sensoretemp sensore){
        if(!sensoreEcgRepository.existsById(sensore.getId()))
            throw new SensoreNotFoundException(sensore.getId());
        return observationtempRepository.findObservationtempByIdsensore(sensore);
    }

    public Observationecg findLastObservationecg(Integer idPostoletto){
        if(!postolettoRepository.existsById(idPostoletto))
            throw new PostolettoNotFoundException(idPostoletto);
        Postoletto p = postolettoRepository.findPostolettoById(idPostoletto);
        Sensoreecg s = p.getSensoreecgs().get(0);
        return observationecgRepository.findLastObservationEcg(s);
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
        observationtempRepository.save(o);
        return observationtempRepository.findLastObservationTemp(s);
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
        observationecgRepository.save(o);
        return observationecgRepository.findLastObservationEcg(s);
    }
/*
    public List<Observationtemp> findObservationtempByFilter(DateDto dateDto){
        ArrayList <Instant> array = stringToInstance(dateDto);
        System.out.println(dateDto);
        return observationtempRepository.findById_DataRilevazioneBetween(array.get(0),array.get(1));
    }*/

   /* private static ArrayList <Instant> stringToInstance(DateDto dateDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String date = "2016/08/16";
        LocalDate localDate = LocalDate.parse(date, formatter);
        System.out.println(localDate.toString());

        /*DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(date);
        LocalDate localInzio = LocalDate.parse(date, dateTimeFormatter);
        System.out.println(localInzio);
        LocalDate localFine = LocalDate.parse(dateDto.getDataFine(), dateTimeFormatter);
        Instant instantFine = localFine.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Instant instantInzio = localInzio.atStartOfDay(ZoneId.systemDefault()).toInstant();
        ArrayList <Instant> array = new ArrayList<>();
        array.add(instantInzio);
        array.add(instantFine);
        return array;
        return new ArrayList<>();
    }*/
}


