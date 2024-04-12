package com.shop.comicverse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Genere")
public class Genere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGenere;
	
	private String nome;
}
