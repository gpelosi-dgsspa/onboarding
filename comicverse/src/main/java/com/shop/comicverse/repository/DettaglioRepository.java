package com.shop.comicverse.repository;

import com.shop.comicverse.entity.Dettaglio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DettaglioRepository extends JpaRepository<Dettaglio, Integer>{

}
