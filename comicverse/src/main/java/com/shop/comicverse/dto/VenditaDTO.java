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
	private List<String> metodoPagamento = Arrays.asList("CONTANTI", "CARTA_DI_CREDITO", "BANCOMAT");
	private List<DettaglioDTO> listaDettaglio;

	public int getIdVendita() {
		return idVendita;
	}

	public void setIdVendita(int idVendita) {
		this.idVendita = idVendita;
	}

	public Date getDataOrdine() {
		return dataOrdine;
	}

	public void setDataOrdine(Date dataOrdine) {
		this.dataOrdine = dataOrdine;
	}

	public BigDecimal getTotaleOrdine() {
		return totaleOrdine;
	}

	public void setTotaleOrdine(BigDecimal totaleOrdine) {
		this.totaleOrdine = totaleOrdine;
	}

	public List<String> getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(List<String> metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public List<DettaglioDTO> getListaDettaglio() {
		return listaDettaglio;
	}

	public void setListaDettaglio(List<DettaglioDTO> listaDettaglio) {
		this.listaDettaglio = listaDettaglio;
	}

}
