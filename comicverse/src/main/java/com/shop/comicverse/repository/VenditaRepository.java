package com.shop.comicverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.comicverse.entity.Vendita;

@Repository
public interface VenditaRepository extends JpaRepository<Vendita, Integer>{

    @Query(value = "SELECT SUM(v.TOTALE_ORDINE) " +
            "FROM VENDITA v", nativeQuery = true)
    Double totale();

    @Query(value = "SELECT COUNT(*) " +
            "FROM VENDITA v", nativeQuery = true)
    Integer numeroOrdini();

    @Query(value = "SELECT AVG(v.TOTALE_ORDINE) " +
            "FROM VENDITA v", nativeQuery = true)
    Double importoMedioOrdine();

    @Query(value = "SELECT SUM(dv.QUANTITA) " +
            "FROM DETTAGLIO_VENDITA dv", nativeQuery = true)
    Integer numeroArticoliVenduti();
}
