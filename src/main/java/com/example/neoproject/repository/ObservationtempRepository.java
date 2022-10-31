package com.example.neoproject.repository;

import com.example.neoproject.model.Observationtemp;
import com.example.neoproject.model.ObservationtempId;
import com.example.neoproject.model.Sensoretemp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObservationtempRepository extends JpaRepository<Observationtemp, Integer> {

    List<Observationtemp> findObservationtempByIdsensore(Sensoretemp sensore);

}