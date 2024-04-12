package com.shop.comicverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.comicverse.entity.Vendita;

@Repository
public interface VenditaRepository extends JpaRepository<Vendita, Integer>{

}
