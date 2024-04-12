
package com.shop.comicverse.dto;

import java.util.Date;
import java.util.List;

import com.shop.comicverse.entity.Autore;
import com.shop.comicverse.entity.Genere;

import lombok.Data;

@Data
public class FumettoDTO {

	private Integer idFumetto;
	private String titolo;
	private String editore;
	private int volume;
	private Date dataPubblicazione = new Date();
	private String descrizione;
	private List<Genere> listaGeneri;
	private Autore autoreFumetto;
}
