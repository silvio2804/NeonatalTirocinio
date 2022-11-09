package com.example.neoproject.controller;

import com.example.neoproject.map.dtos.observation.DateDto;
import com.example.neoproject.model.Observationecg;
import com.example.neoproject.model.Observationtemp;
import com.example.neoproject.service.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RequestMapping("/api")
@RestController
public class ObservationController {

    @Autowired
    ObservationService observationService;

    @PostMapping("/Observationecg/{sensorId}")
    public ResponseEntity<Observationecg> addObservationEcg(@PathVariable Integer sensorId){
        return new ResponseEntity<>(observationService.addObservationecg(sensorId), HttpStatus.OK);
    }

    //ok
    @PostMapping("/Observationtemp/{sensorId}")
    public ResponseEntity<Observationtemp> addObservationTemp(@PathVariable Integer sensorId){
        return new ResponseEntity<>(observationService.addObservationtemp(sensorId), HttpStatus.OK);
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
