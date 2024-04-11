package com.shop.comicverse.entity;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Inventario")
public class Inventario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ARTICOLO")
	private int idArticolo;
	
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "fumetto_id") //@PrimaryKeyJoinColumn(name="idFumetto",
	 * referencedColumnName="idFumetto") private Fumetto fumetto;
	 */
	
	@Column(name = "PREZZO_VENDITA")
	private BigDecimal prezzoVendita;
	
	@Column(name = "GIACENZA")
	private int giacenza;
}
