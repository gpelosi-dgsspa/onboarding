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
	private int idGenere;
	
	private String nome;

	public int getIdGenere() {
		return idGenere;
	}

	public void setIdGenere(int idGenere) {
		this.idGenere = idGenere;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
