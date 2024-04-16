package com.shop.comicverse.dto;

import java.math.BigDecimal;
import java.util.List;

import com.shop.comicverse.entity.Dettaglio;
import com.shop.comicverse.entity.Fumetto;

import lombok.Data;

@Data
public class InventarioDTO {

    private int idArticolo;
    private Fumetto fumetto;
    private BigDecimal prezzoVendita;
    private int giacenza;
    private List<Dettaglio> dettaglioLista;

    public int getIdArticolo() {
        return idArticolo;
    }

    public void setIdArticolo(int idArticolo) {
        this.idArticolo = idArticolo;
    }

    public Fumetto getFumetto() {
        return fumetto;
    }

    public void setFumetto(Fumetto fumetto) {
        this.fumetto = fumetto;
    }

    public BigDecimal getPrezzoVendita() {
        return prezzoVendita;
    }

    public void setPrezzoVendita(BigDecimal prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
    }

    public int getGiacenza() {
        return giacenza;
    }

    public void setGiacenza(int giacenza) {
        this.giacenza = giacenza;
    }

    public List<Dettaglio> getDettaglioLista() {
        return dettaglioLista;
    }

    public void setDettaglioLista(List<Dettaglio> dettaglioLista) {
        this.dettaglioLista = dettaglioLista;
    }
}
