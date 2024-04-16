
package com.shop.comicverse.dto;

import java.util.Date;
import java.util.List;

import com.shop.comicverse.entity.Autore;
import com.shop.comicverse.entity.Genere;

import lombok.Data;

@Data
public class FumettoDTO {

	private int idFumetto;
	private String titolo;
	private String editore;
	private int volume;
	private Date dataPubblicazione = new Date();
	private String descrizione;
	private List<Genere> listaGeneri;
	private Autore autoreFumetto;
	public int getIdFumetto() {
		return idFumetto;
	}
	public void setIdFumetto(int idFumetto) {
		this.idFumetto = idFumetto;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getEditore() {
		return editore;
	}
	public void setEditore(String editore) {
		this.editore = editore;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public Date getDataPubblicazione() {
		return dataPubblicazione;
	}
	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public List<Genere> getListaGeneri() {
		return listaGeneri;
	}
	public void setListaGeneri(List<Genere> listaGeneri) {
		this.listaGeneri = listaGeneri;
	}
	public Autore getAutoreFumetto() {
		return autoreFumetto;
	}
	public void setAutoreFumetto(Autore autoreFumetto) {
		this.autoreFumetto = autoreFumetto;
	}
	
	
	
}
