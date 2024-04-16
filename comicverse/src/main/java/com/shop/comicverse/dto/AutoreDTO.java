package com.shop.comicverse.dto;

import java.util.List;

import com.shop.comicverse.entity.Fumetto;

import lombok.Data;

@Data
public class AutoreDTO {

	private int idAutore;
	private String nomeCognome;
	private String biografia;
	private boolean vivo;
	private List<Fumetto> listaFumetti;
	public int getIdAutore() {
		return idAutore;
	}
	public void setIdAutore(int idAutore) {
		this.idAutore = idAutore;
	}
	public String getNomeCognome() {
		return nomeCognome;
	}
	public void setNomeCognome(String nomeCognome) {
		this.nomeCognome = nomeCognome;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	public boolean isVivo() {
		return vivo;
	}
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	public List<Fumetto> getListaFumetti() {
		return listaFumetti;
	}
	public void setListaFumetti(List<Fumetto> listaFumetti) {
		this.listaFumetti = listaFumetti;
	}
	
	
	
}

