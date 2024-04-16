package com.shop.comicverse.dto;

import lombok.Data;

@Data
public class GenereDTO {

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
