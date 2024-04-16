package com.shop.comicverse.mapper;

import org.springframework.stereotype.Component;

import com.shop.comicverse.dto.DettaglioDTO;
import com.shop.comicverse.entity.Dettaglio;
import com.shop.comicverse.entity.Inventario;

@Component
public class DettaglioMapping {


	    public DettaglioDTO convertiDettaglioInDTO(Dettaglio dettaglio) {
	        DettaglioDTO dettaglioDTO = new DettaglioDTO();
	        dettaglioDTO.setIdDettaglio(dettaglio.getIdDettaglio());
	        dettaglioDTO.setIdOggetto(dettaglio.getOggetto() != null ? dettaglio.getOggetto().getIdArticolo() : 0);
	        dettaglioDTO.setQuantita(dettaglio.getQuantita());
	        return dettaglioDTO;
	    }

	    public Dettaglio convertiDTOInDettaglio(DettaglioDTO dettaglioDTO) {
	        Dettaglio dettaglio = new Dettaglio();
	        dettaglio.setIdDettaglio(dettaglioDTO.getIdDettaglio());
	        if (dettaglioDTO.getIdOggetto() > 0) {
	            Inventario oggetto = new Inventario();
	            oggetto.setIdArticolo(dettaglioDTO.getIdOggetto());
	            dettaglio.setOggetto(oggetto);
	        }
	        dettaglio.setQuantita(dettaglioDTO.getQuantita());
	        return dettaglio;
	    }
	}


