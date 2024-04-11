package com.shop.comicverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.comicverse.entity.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer>{

}
