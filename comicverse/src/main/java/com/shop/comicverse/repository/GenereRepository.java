package com.shop.comicverse.repository;

import com.shop.comicverse.entity.Genere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenereRepository extends JpaRepository<Genere, Integer>{

}
