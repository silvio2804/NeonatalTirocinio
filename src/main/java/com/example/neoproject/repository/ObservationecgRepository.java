package com.example.neoproject.repository;

import com.example.neoproject.model.Observationecg;
import com.example.neoproject.model.ObservationecgId;
import com.example.neoproject.model.Sensoreecg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObservationecgRepository extends JpaRepository<Observationecg, Integer> {

    List< Observationecg> findObservationecgByIdsensore(Sensoreecg sensore);
}