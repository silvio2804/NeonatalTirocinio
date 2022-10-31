package com.example.neoproject.controller;

import com.example.neoproject.jsonRequest.SensoreEcgRequest;
import com.example.neoproject.model.Sensoreecg;
import com.example.neoproject.service.SensoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class SensoreController {

    @Autowired
    private SensoreService sensoreService;

    @GetMapping("/sensore/{id}")
    public ResponseEntity<Sensoreecg> getSensore(@PathVariable Integer id){
        return  new ResponseEntity<>(sensoreService.findSensoreEcgById(id), HttpStatus.OK);
    }

    @PostMapping("/sensore/add")
    /*public ResponseEntity <Sensoreecg> addSensore(@RequestBody SensoreEcgRequest sensoreecgRequest){
        return new ResponseEntity<>(sensoreService.addSensoreEcg(sensoreecgRequest),HttpStatus.OK);
    }*/

    @GetMapping("/sensore/list")
    public ResponseEntity <List<Sensoreecg>> getAll(){
        return new ResponseEntity<>(sensoreService.findAllSensoriEcg(),HttpStatus.OK);
    }


}
