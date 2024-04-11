package com.shop.comicverse.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Dettaglio")
public class Dettaglio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDettaglio;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_ARTICOLO")
	private Inventario oggetto;
	
	private int quantita;
}
