package com.shop.comicverse.mapper;

import org.springframework.stereotype.Component;

import com.shop.comicverse.dto.FumettoDTO;
import com.shop.comicverse.entity.Fumetto;

@Component
public class FumettoMapping {

	public FumettoDTO convertiFumettoInDTO(Fumetto fumetto) {
		FumettoDTO dto = new FumettoDTO();
		dto.setIdFumetto(fumetto.getIdFumetto());
		dto.setTitolo(fumetto.getTitolo());
		dto.setEditore(fumetto.getEditore());
		dto.setVolume(fumetto.getVolume());
		dto.setDataPubblicazione(fumetto.getDataPubblicazione());
		dto.setDescrizione(fumetto.getDescrizione());
		dto.setListaGeneri(fumetto.getListaGeneri());
		dto.setAutoreFumetto(fumetto.getAutoreFumetto());
		return dto;
	}

	public Fumetto convertiDTOInFumetto(FumettoDTO dto) {
		Fumetto fumetto = new Fumetto();
		fumetto.setIdFumetto(dto.getIdFumetto());
		fumetto.setTitolo(dto.getTitolo());
		fumetto.setEditore(dto.getEditore());
		fumetto.setVolume(dto.getVolume());
		fumetto.setDataPubblicazione(dto.getDataPubblicazione());
		fumetto.setDescrizione(dto.getDescrizione());
		fumetto.setListaGeneri(dto.getListaGeneri());
		fumetto.setAutoreFumetto(dto.getAutoreFumetto());
		return fumetto;
	}
}
