package com.shop.comicverse.mapper;

import org.springframework.stereotype.Component;

import com.shop.comicverse.dto.InventarioDTO;
import com.shop.comicverse.entity.Inventario;

@Component
public class InventarioMapping {

	
	 public InventarioDTO convertiInventarioInDTO(Inventario inventario) {
	        InventarioDTO dto = new InventarioDTO();
	        dto.setIdArticolo(inventario.getIdArticolo());
	        dto.setFumetto(inventario.getFumetto());
	        dto.setPrezzoVendita(inventario.getPrezzoVendita());
	        dto.setGiacenza(inventario.getGiacenza());
	        dto.setDettaglioLista(inventario.getDettaglioLista());
	        return dto;
	    }
	 public Inventario convertiDTOInInventario(InventarioDTO dto) {
		    Inventario inventario = new Inventario();
		    inventario.setIdArticolo(dto.getIdArticolo());
		    inventario.setFumetto(dto.getFumetto());
		    inventario.setPrezzoVendita(dto.getPrezzoVendita());
		    inventario.setGiacenza(dto.getGiacenza());
		    inventario.setDettaglioLista(dto.getDettaglioLista());
		    return inventario;
		}

	 
}
