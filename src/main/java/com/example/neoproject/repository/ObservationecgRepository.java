package com.example.neoproject.repository;

import com.example.neoproject.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ObservationecgRepository extends JpaRepository<Observationecg, ObservationecgId> {

    Observationecg findTopByIdsensore(Sensoreecg sensoreecg); //restituisce il primo record
    @Query(value = "SELECT o FROM Observationecg o WHERE o.idsensore= ?1 " +
            "AND o.id.dataRilevazione = (SELECT max(o.id.dataRilevazione) FROM Observationecg o)")
    Observationecg findLastObservationEcg(Sensoreecg sensoreecg);

}