package com.shop.comicverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.comicverse.entity.Genere;

@Repository
public interface GenereRepository extends JpaRepository<Genere, Long>{

}
