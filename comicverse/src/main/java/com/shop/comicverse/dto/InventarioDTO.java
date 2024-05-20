package com.shop.comicverse.dto;

import com.shop.comicverse.entity.Dettaglio;
import com.shop.comicverse.entity.Fumetto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class InventarioDTO {

	private Integer idArticolo;
	private Fumetto fumetto;
	private BigDecimal prezzoVendita;
	private int giacenza;
	private List<Dettaglio> dettaglioLista;
}
