package com.shop.comicverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.comicverse.entity.Autore;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Long>{

}