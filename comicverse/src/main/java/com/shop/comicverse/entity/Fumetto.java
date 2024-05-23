package com.shop.comicverse.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "FUMETTO")
public class Fumetto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_FUMETTO")
	private Integer idFumetto;

	@Column(name = "TITOLO")
	private String titolo;

	@Column(name = "EDITORE")
	private String editore;

	@Column(name = "VOLUME")
	private int volume;

	@Column(name = "DATA_PUBBLICAZIONE")
	@Temporal(TemporalType.DATE)
	private Date dataPubblicazione = new Date();

	@Column(name = "DESCRIZIONE")
	private String descrizione;

	@JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "GENERE_FUMETTO", 
    			joinColumns = @JoinColumn(name = "FK_FUMETTO", referencedColumnName = "ID_FUMETTO"),
    			inverseJoinColumns = @JoinColumn(name = "FK_GENERE", referencedColumnName = "ID_GENERE"))
	private List<Genere> listaGeneri;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "FK_AUTORE", referencedColumnName = "ID_AUTORE")
	private Autore autoreFumetto;

}
