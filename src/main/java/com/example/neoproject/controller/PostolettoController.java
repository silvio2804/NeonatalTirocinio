package com.example.neoproject.controller;

import com.example.neoproject.map.dtos.postoletto.PostilettoAll;
import com.example.neoproject.model.Postoletto;
import com.example.neoproject.service.PostoLettoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class PostolettoController {

    @Autowired
    private PostoLettoService postoLettoService;

    @GetMapping("/postoletto/{idPostoletto}")
    public ResponseEntity <Postoletto> getPostoletto(@PathVariable Integer idPostoletto){
        return new ResponseEntity<>(postoLettoService.findPostolettoById(idPostoletto), HttpStatus.OK);
    }


    @GetMapping("/postoletto/list/{nomeReparto}")
    public ResponseEntity <List<PostilettoAll>> getAllPostilettoFromReparto(@PathVariable String nomeReparto){
        return new ResponseEntity<>(postoLettoService.findAllPostiLettoByReparto(nomeReparto),HttpStatus.OK);
    }
   /*@PostMapping("/postoletto")
    public ResponseEntity <Postoletto> addPostoletto(@RequestBody Reparto reparto){
        return new ResponseEntity<>(postoLettoService.addPostoLetto(reparto.getId()),HttpStatus.CREATED);
    }*/
}
