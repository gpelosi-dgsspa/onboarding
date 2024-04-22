package com.shop.comicverse.mapping;

import com.shop.comicverse.dto.InventarioDTO;
import com.shop.comicverse.entity.Inventario;
import org.springframework.stereotype.Component;

@Component
public class InventarioMapping {

    public Inventario convertiDTOinInventario(InventarioDTO inventarioDTO) {
        Inventario inventario = new Inventario();
        inventario.setIdArticolo(inventarioDTO.getIdArticolo());
        inventario.setFumetto(inventarioDTO.getFumetto());
        inventario.setPrezzoVendita(inventarioDTO.getPrezzoVendita());
        inventario.setGiacenza(inventarioDTO.getGiacenza());
        inventario.setDettaglioLista(inventarioDTO.getDettaglioLista());
        return inventario;
    }

    public InventarioDTO convertiInventarioinDTO(Inventario inventario) {
        InventarioDTO inventarioDTO = new InventarioDTO();
        inventarioDTO.setIdArticolo(inventario.getIdArticolo());
        inventarioDTO.setFumetto(inventario.getFumetto());
        inventarioDTO.setPrezzoVendita(inventario.getPrezzoVendita());
        inventarioDTO.setGiacenza(inventario.getGiacenza());
        inventarioDTO.setDettaglioLista(inventario.getDettaglioLista());
        return inventarioDTO;
    }
}