package com.shop.comicverse.repository;

import com.shop.comicverse.entity.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Integer>{
    @Query(value = "SELECT a.NOME_COGNOME " +
            "FROM AUTORE a " +
            "WHERE a.vivo = true", nativeQuery = true)
    List<Autore> autoriVivi();
}
