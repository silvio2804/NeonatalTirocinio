package com.example.neoproject.service;

import com.example.neoproject.exception.NeonatoNotFoundException;
import com.example.neoproject.model.Neonato;
import com.example.neoproject.repository.NeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class NeonatoService {
    @Autowired
    private NeonatoRepository neonatoRepository;
    private Neonato neonato = new Neonato();

    public Neonato findNeonatoById(Integer id){
        if(!neonatoRepository.existsById(id))
            throw new NeonatoNotFoundException(id);
        return neonatoRepository.findNeonatoById(id);
    }

    public Neonato addNeonato(String nome, String cognome, LocalDate dataNa, Double peso,
                              Integer etaG, LocalDate dataInizio, LocalDate dataFine){
        neonato.setNome(nome);
        neonato.setCognome(cognome);
        neonato.setDataNa(dataNa);
        neonato.setPeso(peso);
        neonato.setEtaGestazionale(etaG);
        neonato.setDatainizioricovero(dataInizio);
        neonato.setDatafinericovero(dataFine);
        return neonatoRepository.save(neonato);
    }

    public Neonato updateNeonato(Neonato n){
         neonato.setNome(n.getNome());
         neonato.setCognome(n.getCognome());
         neonato.setDataNa(n.getDataNa());
         neonato.setPeso(n.getPeso());
         neonato.setEtaGestazionale(n.getEtaGestazionale());
         neonato.setDatainizioricovero(n.getDatainizioricovero());
         neonato.setDatafinericovero(n.getDatafinericovero());
         return neonatoRepository.save(neonato);
    }
}
