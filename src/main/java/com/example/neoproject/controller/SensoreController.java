package com.example.neoproject.controller;

import com.example.neoproject.model.Sensore;
import com.example.neoproject.service.SensoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class SensoreController {

    @Autowired
    private SensoreService sensoreService;

    @GetMapping("/sensore/{id}")
    public ResponseEntity<Sensore> getSensore(@PathVariable Integer id){
        return  new ResponseEntity<>(sensoreService.findSensoreById(id), HttpStatus.OK);
    }

    @PostMapping("/sensore/add")
    public ResponseEntity <Sensore> addSensore(@RequestParam  Integer pos, @RequestParam Integer dim,
                                               @RequestParam String tipologia, @RequestParam Integer postoletto){
        return new ResponseEntity<>(sensoreService.addSensore(pos, dim, tipologia, postoletto),HttpStatus.OK);
    }

    
}
