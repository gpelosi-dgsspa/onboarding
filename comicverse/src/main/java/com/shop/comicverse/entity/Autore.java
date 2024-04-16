package com.shop.comicverse.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Autore")
public class Autore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAutore;
	
	private String nomeCognome;
	
	private String biografia;
	
	private boolean vivo;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "autoreFumetto", cascade = CascadeType.ALL)
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
