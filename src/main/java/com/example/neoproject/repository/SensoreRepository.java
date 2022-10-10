package com.example.neoproject.repository;

import com.example.neoproject.model.Postoletto;
import com.example.neoproject.model.Sensore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface SensoreRepository extends JpaRepository<Sensore, Integer> {

    @Query("select s from Sensore s where s.idpostoletto = ?1")
    List <Sensore> findSensoreByIdpostoletto(Postoletto postoletto); //dammi tutti i sensori relativi al letto

    //Set<Sensore> findSensoreByIdpostoletto(Postoletto postoletto);

    @Query("select s from Sensore s where s.id = ?1")
    Sensore findSensoreById(Integer id );

}