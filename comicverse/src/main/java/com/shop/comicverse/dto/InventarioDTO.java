package com.shop.comicverse.dto;

import java.math.BigDecimal;
import java.util.List;

import com.shop.comicverse.entity.Dettaglio;
import com.shop.comicverse.entity.Fumetto;

import lombok.Data;

@Data
public class InventarioDTO {

	private Integer idArticolo;
	private Fumetto fumetto;
	private BigDecimal prezzoVendita;
	private int giacenza;
	private List<Dettaglio> dettaglioLista;
}
