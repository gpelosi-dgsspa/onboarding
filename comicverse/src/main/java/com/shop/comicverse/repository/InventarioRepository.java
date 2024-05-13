package com.shop.comicverse.repository;

import com.shop.comicverse.dto.InventarioDTO;
import com.shop.comicverse.entity.Fumetto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shop.comicverse.entity.Inventario;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer>{

    @Query(value = "SELECT COUNT(*) " +
                    "FROM INVENTARIO i", nativeQuery = true)
    Integer numeroOggetti();

    @Query(value = "SELECT AVG(i.PREZZO_VENDITA)" +
                    "FROM INVENTARIO i", nativeQuery = true)
    Double prezzoMedioVendita();

    @Query(value = "SELECT f.TITOLO, MIN(d.QUANTITA) " +
            "FROM INVENTARIO i " +
            "JOIN DETTAGLIO_VENDITA d ON d.FK_ARTICOLO = i.ID_ARTICOLO " +
            "JOIN FUMETTO f ON i.FK_FUMETTO = f.ID_FUMETTO ", nativeQuery = true)
    Inventario oggettoMinQuantita();
}
