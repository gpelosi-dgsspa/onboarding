package com.shop.comicverse.dto;

import java.math.BigDecimal;
import java.util.List;

import com.shop.comicverse.entity.Fumetto;

import lombok.Data;

@Data
public class InventarioDTO {

	private int idArticolo;
	private List<Fumetto> listaFumetti;
	private BigDecimal prezzoVendita;
	private int giacenza;
}