package com.shop.comicverse.entity;

import java.math.BigDecimal;
import java.util.List;

//
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "INVENTARIO")
public class Inventario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ARTICOLO")
	private Integer idArticolo;
	
	//il mio fk fumetto a cosa fa riferimento? all'id della tabella che sto chiamando
	@OneToOne
	@JoinColumn(name = "FK_FUMETTO", referencedColumnName = "ID_FUMETTO")
	private Fumetto fumetto;
	
	@Column(name = "PREZZO_VENDITA")
	private BigDecimal prezzoVendita;

	@Column(name = "GIACENZA")
	private Integer giacenza;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "oggetto", cascade = CascadeType.ALL)
    private List<Dettaglio> dettaglioLista;


	public Integer getIdArticolo() {
		return idArticolo;
	}


	public void setIdArticolo(Integer idArticolo) {
		this.idArticolo = idArticolo;
	}


	public Fumetto getFumetto() {
		return fumetto;
	}


	public void setFumetto(Fumetto fumetto) {
		this.fumetto = fumetto;
	}


	public BigDecimal getPrezzoVendita() {
		return prezzoVendita;
	}


	public void setPrezzoVendita(BigDecimal prezzoVendita) {
		this.prezzoVendita = prezzoVendita;
	}


	public Integer getGiacenza() {
		return giacenza;
	}


	public void setGiacenza(Integer giacenza) {
		this.giacenza = giacenza;
	}


	public List<Dettaglio> getDettaglioLista() {
		return dettaglioLista;
	}


	public void setDettaglioLista(List<Dettaglio> dettaglioLista) {
		this.dettaglioLista = dettaglioLista;
	}
	
	
	
}
