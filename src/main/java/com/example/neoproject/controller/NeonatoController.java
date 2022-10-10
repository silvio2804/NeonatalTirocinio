package com.example.neoproject.controller;
import com.example.neoproject.model.Neonato;
import com.example.neoproject.service.NeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequestMapping("/api")
@RestController
public class NeonatoController {

    @Autowired
    private NeonatoService neonatoService;

    @GetMapping("/neonato/{id}")
    public ResponseEntity<Neonato> getSensore(@PathVariable Integer id){
        return  new ResponseEntity<>(neonatoService.findNeonatoById(id), HttpStatus.OK);
    }

    @PostMapping("/neonato/add")
    public ResponseEntity <Neonato> addSensore(@RequestParam String nome, @RequestParam String cognome, @RequestParam LocalDate dataNa,
                                               @RequestParam Double peso, @RequestParam Integer etaG, @RequestParam LocalDate dataInizio,
                                               @RequestParam LocalDate dataFine){
        return new ResponseEntity<>(neonatoService.addNeonato(nome,cognome,dataNa,peso,etaG,dataInizio,dataFine),HttpStatus.OK);
    }
}
