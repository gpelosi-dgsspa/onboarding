package com.shop.comicverse.entity;

import java.math.BigDecimal;
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
	
	
	enum metodoPagamento{
		CONTANTI, 
		CARTA_DI_CREDITO, 
		BANCOMAT
	}
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "DETTAGLIO_VENDITA", 
    			joinColumns = @JoinColumn(name = "Vendita"), 
    			inverseJoinColumns = @JoinColumn(name = "Dettaglio"))
	private List<Dettaglio> listaDettaglio;
}
