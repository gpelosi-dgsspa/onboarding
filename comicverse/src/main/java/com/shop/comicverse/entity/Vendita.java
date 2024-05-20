package com.shop.comicverse.entity;

import com.shop.comicverse.things.MetodoPagamento;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "VENDITA")
public class Vendita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VENDITA")
	private Integer idVendita;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_ORDINE")
	private Date dataOrdine = new Date();

	@Column(name = "TOTALE_ORDINE")
	private BigDecimal totaleOrdine;

	@Column(name = "METODO_PAGAMENTO")
	@Enumerated(EnumType.STRING)
	private MetodoPagamento metodoPagamento;

}
