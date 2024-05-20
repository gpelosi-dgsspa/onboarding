package com.shop.comicverse.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

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
	private int giacenza;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "articolo", cascade = CascadeType.ALL)
    private List<Dettaglio> dettaglioLista;

}
