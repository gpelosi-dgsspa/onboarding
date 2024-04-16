package com.shop.comicverse.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.shop.comicverse.dto.VenditaDTO;
import com.shop.comicverse.entity.Vendita;

@Component
public class VenditaMapping {

	public VenditaDTO convertiVenditaInDTO(Vendita vendita) {
	    VenditaDTO dto = new VenditaDTO();
	    dto.setIdVendita(vendita.getIdVendita());
	    dto.setDataOrdine(vendita.getDataOrdine());
	    dto.setTotaleOrdine(vendita.getTotaleOrdine());
	    dto.setMetodoPagamento(vendita.getMetodoPagamento());
	    
	    if (vendita.getListaDettaglio() != null) {
	        DettaglioMapping dettaglioMapping = new DettaglioMapping(); // Creazione dell'istanza
	        dto.setListaDettaglio(
	            vendita.getListaDettaglio().stream()
	                .map(dettaglioMapping::convertiDettaglioInDTO) // Utilizzo dell'istanza per chiamare il metodo non statico
	                .collect(Collectors.toList())
	        );
	    }
	    
	    return dto;
	}


	public Vendita convertiDTOInVendita(VenditaDTO venditaDTO) {
	    Vendita vendita = new Vendita();
	    vendita.setIdVendita(venditaDTO.getIdVendita());
	    vendita.setDataOrdine(venditaDTO.getDataOrdine());
	    vendita.setTotaleOrdine(venditaDTO.getTotaleOrdine());
	    vendita.setMetodoPagamento(venditaDTO.getMetodoPagamento());
	    
	    if (venditaDTO.getListaDettaglio() != null) {
	        DettaglioMapping dettaglioMapping = new DettaglioMapping();
	        vendita.setListaDettaglio(
	            venditaDTO.getListaDettaglio().stream()
	                .map(dettaglioMapping::convertiDTOInDettaglio)
	                .collect(Collectors.toList())
	        );
	    }
	    
	    return vendita;
	}

}
