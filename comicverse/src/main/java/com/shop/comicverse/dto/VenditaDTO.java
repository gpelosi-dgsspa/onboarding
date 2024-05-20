package com.shop.comicverse.dto;

import com.shop.comicverse.entity.Dettaglio;
import com.shop.comicverse.things.MetodoPagamento;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class VenditaDTO {

	private Integer idVendita;
	private Date dataOrdine = new Date();
	private BigDecimal totaleOrdine;
	private MetodoPagamento metodoPagamento;
	private List<Dettaglio> listaDettaglio;
}
