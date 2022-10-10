package com.example.neoproject.repository;

import com.example.neoproject.model.Neonato;
import com.example.neoproject.model.Postoletto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface PostolettoRepository extends JpaRepositoryImplementation<Postoletto, Integer> {

    @Query("select p from Postoletto p where p.neonatoes = ?1")
    Postoletto findPostolettoByNeonatoes(Neonato neonato);

    @Query("select p from Postoletto p where p.id = ?1")
    Postoletto findPostolettoById(Integer id);
}