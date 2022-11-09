package com.example.neoproject.controller;

import com.example.neoproject.map.dtos.neonato.NeonatoGetDto;
import com.example.neoproject.map.dtos.neonato.NeonatoPostDto;
import com.example.neoproject.model.Neonato;
import com.example.neoproject.service.NeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class NeonatoController {

    @Autowired
    private NeonatoService neonatoService;

    @PostMapping("/neonato/add")
    public ResponseEntity <Neonato> addNeonato(@RequestBody NeonatoPostDto neonatoPostDto){
        return new ResponseEntity<>(neonatoService.addNeonato(neonatoPostDto),HttpStatus.CREATED);
    }

    @GetMapping("/neonato/{id}")
    public ResponseEntity <NeonatoGetDto> getNeonato(@PathVariable Integer id){
        return new ResponseEntity<>(neonatoService.findNeonatoById(id),HttpStatus.OK);
    }

    /*@PutMapping
    public ResponseEntity <Neonato> updateNeonato(@PathVariable Integer id){

    }*/
}
