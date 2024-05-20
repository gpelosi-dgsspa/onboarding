package com.shop.comicverse.dto;

import com.shop.comicverse.entity.Fumetto;
import lombok.Data;

import java.util.List;

@Data
public class AutoreDTO {

	private Integer idAutore;
	private String nomeCognome;
	private String biografia;
	private boolean vivo;
	private List<Fumetto> listaFumetti;
}

