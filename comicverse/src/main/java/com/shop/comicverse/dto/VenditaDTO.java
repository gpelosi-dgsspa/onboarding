package com.shop.comicverse.dto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.shop.comicverse.entity.Dettaglio;

import lombok.Data;

@Data
public class VenditaDTO {

	private int idVendita;
	private Date dataOrdine = new Date();
	private BigDecimal totaleOrdine;
	/*enum metodoPagamento{
	CONTANTI, 
	CARTA_DI_CREDITO, 
	BANCOMAT
	}*/
	private List<String> metodoPagamento = Arrays.asList("CONTANTI", "CARTA_DI_CREDITO", "BANCOMAT");
	private List<Dettaglio> listaDettaglio;
}
