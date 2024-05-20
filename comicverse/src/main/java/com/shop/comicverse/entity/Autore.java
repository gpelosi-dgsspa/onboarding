package com.shop.comicverse.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "AUTORE")
public class Autore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AUTORE")
	private Integer idAutore;

	@Column(name= "NOME_COGNOME")
	private String nomeCognome;

	@Column(name = "BIOGRAFIA")
	private String biografia;

	@Column(name = "VIVO")
	private boolean vivo;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "autoreFumetto", cascade = CascadeType.ALL)
	private List<Fumetto> listaFumetti;

}