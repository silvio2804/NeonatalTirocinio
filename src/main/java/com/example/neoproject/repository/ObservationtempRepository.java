package com.example.neoproject.repository;

import com.example.neoproject.model.Observationtemp;
import com.example.neoproject.model.ObservationtempId;
import com.example.neoproject.model.Sensoretemp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;

public interface ObservationtempRepository extends JpaRepository<Observationtemp, Integer> {

    List<Observationtemp> findObservationtempByIdsensore(Integer idSensore);
    List<Observationtemp> findByIdsensore_Idpostoletto_Id(Integer id);

    @Query(value = "SELECT o FROM Observationtemp o WHERE o.idsensore= ?1 " +
            "AND o.id.dataRilevazione = (SELECT max(o.id.dataRilevazione) FROM Observationtemp o)")
    Observationtemp findLastObservationTemp(Sensoretemp sensoretemp);

    /*@Query(value = "SELECT Observationtemp FROM Observationtemp o WHERE o.id.dataRilevazione BETWEEN :startdate AND :endate")
    List<Observationtemp> findByFilters(@Param("startdate") String dataInizio, @Param("endate") String dataFine);*/
    List<Observationtemp> findById_DataRilevazioneBetween(Instant dataRilevazioneStart, Instant dataRilevazioneEnd);

    void deleteByIdsensore(Sensoretemp idsensore);
}