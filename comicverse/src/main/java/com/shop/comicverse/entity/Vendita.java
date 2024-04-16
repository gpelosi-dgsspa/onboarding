package com.shop.comicverse.entity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "Vendita")
public class Vendita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVendita;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_ORDINE")
	private Date dataOrdine = new Date();

	private BigDecimal totaleOrdine;

	private List<String> metodoPagamento = Arrays.asList("CONTANTI", "CARTA_DI_CREDITO", "BANCOMAT");

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "DETTAGLIO_VENDITA", joinColumns = @JoinColumn(name = "Vendita"), inverseJoinColumns = @JoinColumn(name = "Dettaglio"))
	private List<Dettaglio> listaDettaglio;

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

	public List<Dettaglio> getListaDettaglio() {
		return listaDettaglio;
	}

	public void setListaDettaglio(List<Dettaglio> listaDettaglio) {
		this.listaDettaglio = listaDettaglio;
	}

	public List<String> getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(List<String> metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

}
