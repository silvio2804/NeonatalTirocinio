package com.example.neoproject.controller;
import com.example.neoproject.map.dto.NeonatoGetDto;
import com.example.neoproject.map.dto.NeonatoPostDto;
import com.example.neoproject.map.dto.PostolettoDto;
import com.example.neoproject.map.dto.RepartoPostDto;
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

    @GetMapping("/neonato/sensors/{id}")
    public ResponseEntity<NeonatoGetDto> getSensore(@PathVariable Integer id){
        return  new ResponseEntity<>(neonatoService.findNeonatoById(id), HttpStatus.OK);
    }

    @PostMapping("/neonato/add")
    public ResponseEntity <Neonato> addNeonato(@RequestBody NeonatoPostDto neonatoPostDto){
        System.out.println(neonatoPostDto);
        return new ResponseEntity<>(neonatoService.addNeonato(neonatoPostDto),HttpStatus.CREATED);
    }

    @GetMapping("/neonato/{id}")
    public ResponseEntity <NeonatoGetDto> getNeonato(@PathVariable Integer id){
        return new ResponseEntity<>(neonatoService.findNeonatoById(id),HttpStatus.OK);
    }



}
