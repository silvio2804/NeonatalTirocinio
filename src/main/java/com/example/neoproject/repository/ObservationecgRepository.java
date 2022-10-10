package com.example.neoproject.repository;

import com.example.neoproject.model.Observationecg;
import com.example.neoproject.model.ObservationecgId;
import com.example.neoproject.model.Sensore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObservationecgRepository extends JpaRepository<Observationecg, ObservationecgId> {

    List< Observationecg> findObservationecgByIdsensore(Sensore sensore);
}