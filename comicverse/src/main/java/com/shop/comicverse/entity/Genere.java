package com.shop.comicverse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "GENERE")
public class Genere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_GENERE")
	private Integer idGenere;

	@Column(name = "NOME")
	private String nome;

}
