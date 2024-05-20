package com.shop.comicverse.repository;

import com.shop.comicverse.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
            "JOIN FUMETTO f ON f.ID_FUMETTO = i.FK_FUMETTO " +
            "GROUP BY f.TITOLO", nativeQuery = true)
    Inventario oggettoMinQuantita();

}
