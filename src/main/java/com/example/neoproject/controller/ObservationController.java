package com.example.neoproject.controller;

import com.example.neoproject.model.Observationecg;
import com.example.neoproject.model.Observationtemp;
import com.example.neoproject.service.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RequestMapping("/api")
@RestController
public class ObservationController {

    @Autowired
    ObservationService observationService;

    @PostMapping("/Observationecg/{sensorId}")
    public ResponseEntity<Observationecg> saveObservationecg(@PathVariable Integer sensorId){
        return new ResponseEntity<>(observationService.addObservationecg(sensorId), HttpStatus.OK);
    }

    //ok
    @PostMapping("/Observationtemp/{sensorId}")
    public ResponseEntity<Observationtemp> saveObservationtemp(@PathVariable Integer sensorId){
        return new ResponseEntity<>(observationService.addObservationtemp(sensorId), HttpStatus.OK);
    }
    @GetMapping("/observationtemp/list/{sensorId}")
    public ResponseEntity<List<Observationtemp>> getAllObservationtemp(@PathVariable Integer sensorId){
        return new ResponseEntity<>(observationService.findAllObservationTempByIdSensore(sensorId),HttpStatus.OK);
    }

    @GetMapping("/observationecg/list/{sensorId}")
    public ResponseEntity<List<Observationecg>> getAllObservationecg(@PathVariable Integer sensorId){
        return new ResponseEntity<>(observationService.findAllObservationEcgByIdSensore(sensorId),HttpStatus.OK);
    }

    //elimina TUTTE le obs di quel sensore, ma non TUTTA la tabella
    @DeleteMapping("/observationtemp/delete/{idSensoretemp}")
    @Transactional
    public void deleteObservationtemp(@PathVariable Integer idSensoretemp){
        observationService.deleteObservationtempByIdSensore(idSensoretemp);
    }

    @DeleteMapping("/observationtecg/delete/{idSensoreecg}")
    @Transactional
    public void deleteObservationecg(@PathVariable Integer idSensoreecg){
        observationService.deleteObservationecgByIdSensore(idSensoreecg);
    }
    //elimina indipendentemente dal sensore
    @DeleteMapping("/observationtemp/deleteAll")
    @Transactional
    public ResponseEntity<HttpStatus> deleteAlltemps(){
        observationService.deleteAlltemps();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/observationecg/deleteAll")
    @Transactional
    public ResponseEntity<HttpStatus> deleteAllecgs(){
        observationService.deleteAllecgs();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*
    //prende i valori delle observation tra due date
    @GetMapping("/Observationtemp/filter")
    public ResponseEntity<List<Observationtemp>> getByFilter(@RequestBody DateDto dateDto){
        return new ResponseEntity<>(observationService.findObservationtempByFilter(dateDto),HttpStatus.OK);
    }*/

        /*
    //prende le obs in una certa data
    @GetMapping("/Observationecg/{data}")
    public ResponseEntity<Observationecg> getByData(@PathVariable Instant data){

    }
    @GetMapping("/Observationecg/filter")
    public ResponseEntity<Observationecg> getByFilter(@RequestBody Instant arrayData){

    }*/
}
