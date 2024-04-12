package com.shop.comicverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.comicverse.entity.Dettaglio;

@Repository
public interface DettaglioRepository extends JpaRepository<Dettaglio, Integer>{

}
