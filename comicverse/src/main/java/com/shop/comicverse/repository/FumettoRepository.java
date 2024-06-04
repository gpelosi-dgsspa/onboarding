package com.shop.comicverse.repository;

import com.shop.comicverse.entity.Fumetto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FumettoRepository extends JpaRepository<Fumetto, Integer>{
    @Query(value = "SELECT f.TITOLO " +
            "FROM FUMETTO f " +
            "WHERE f.TITOLO LIKE :a%", nativeQuery = true)
    List<Object> fumettiLetteraSpecifica(@Param("a") String lettera);

    @Query(value = "SELECT f.TITOLO, f.DATA_PUBBLICAZIONE " +
            "FROM FUMETTO f " +
            "WHERE f.DATA_PUBBLICAZIONE > :data", nativeQuery = true)
    List<Object> fumettiDopoData(@Param("data") LocalDate data);

    @Query(value = "SELECT f.TITOLO, MAX(i.PREZZO_VENDITA) " +
            "FROM FUMETTO f " +
            "JOIN INVENTARIO i ON f.ID_FUMETTO = i.FK_FUMETTO " +
            "GROUP BY f.TITOLO", nativeQuery = true)
    Object fumettoPrezzoMassimo();

    @Query(value = "SELECT f.TITOLO, i.PREZZO_VENDITA " +
            "FROM FUMETTO f " +
            "JOIN INVENTARIO i ON f.ID_FUMETTO = i.FK_FUMETTO " +
            "WHERE i.PREZZO_VENDITA BETWEEN :min AND :max", nativeQuery = true)
    List<Object> fumettiPrezzoSpecifico(@Param("min") Double prezzoMin, @Param("max") Double prezzoMax);
}
