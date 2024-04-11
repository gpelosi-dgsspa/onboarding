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
}

