package com.shop.comicverse.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Autore")
public class Autore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAutore;
	
	private String nomeCognome;
	
	private String biografia;
	
	private boolean vivo;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "autoreFumetto", cascade = CascadeType.ALL)
	private List<Fumetto> listaFumetti;
	
}
