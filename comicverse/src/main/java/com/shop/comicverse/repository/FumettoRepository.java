package com.shop.comicverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.comicverse.entity.Fumetto;

@Repository
public interface FumettoRepository extends JpaRepository<Fumetto, Integer>{

}