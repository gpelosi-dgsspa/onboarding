package com.shop.comicverse.repository;

import com.shop.comicverse.entity.Fumetto;
import com.shop.comicverse.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shop.comicverse.entity.Autore;

import java.util.List;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Integer>{
    @Query(value = "SELECT a.NOME_COGNOME " +
            "FROM AUTORE a " +
            "WHERE a.vivo = true", nativeQuery = true)
    List<Autore> autoriVivi();
}
