package com.shop.comicverse.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "DETTAGLIO_VENDITA")
public class Dettaglio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DETTAGLIO")
	private Integer idDettaglio;

	@ManyToOne
	@JoinColumn(name = "FK_VENDITA")
	private Vendita vendita;

	@ManyToOne
	@JoinColumn(name = "FK_ARTICOLO")
	private Inventario articolo;

	@Column(name = "QUANTITA")
	private Integer quantita;

}
