package com.shop.comicverse.entity;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "FUMETTO")
public class Fumetto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_FUMETTO")
	private Integer idFumetto;
	
	private String titolo;
	private String editore;
	private int volume;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_PUBBLICAZIONE")
	private Date dataPubblicazione = new Date();
	
	private String descrizione;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "GENERE_FUMETTO", 
    			joinColumns = @JoinColumn(name = "IdFumetto"), 
    			inverseJoinColumns = @JoinColumn(name = "IdGenere"))
	private List<Genere> listaGeneri;
	
	@ManyToOne
	@JoinColumn(name = "idAutore")
	private Autore autoreFumetto;
	

	
}
