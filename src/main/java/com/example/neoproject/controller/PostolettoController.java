package com.example.neoproject.controller;
import com.example.neoproject.model.Postoletto;
import com.example.neoproject.service.PostoLettoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class PostolettoController {

    @Autowired
    private PostoLettoService postoLettoService;
    @GetMapping("/postoletto/{idPostoletto}")
    public ResponseEntity <Postoletto> getPostoletto(@PathVariable Integer idPostoletto){
        return new ResponseEntity<>(postoLettoService.findPostolettoById(idPostoletto), HttpStatus.OK);
    }

    @PostMapping("/postoletto")
    public ResponseEntity <Postoletto> addPostoletto(@RequestParam String nomeReparto){
        return new ResponseEntity<>(postoLettoService.addPostoLetto(nomeReparto),HttpStatus.OK);

    }

}
