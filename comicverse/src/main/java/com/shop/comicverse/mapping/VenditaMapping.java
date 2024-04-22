package com.shop.comicverse.mapping;

import com.shop.comicverse.dto.VenditaDTO;
import com.shop.comicverse.entity.Vendita;
import org.springframework.stereotype.Component;

@Component
public class VenditaMapping {
    public Vendita convertiDTOinVendita (VenditaDTO venditaDTO) {
        Vendita vendita = new Vendita();
        vendita.setIdVendita(venditaDTO.getIdVendita());
        vendita.setDataOrdine(venditaDTO.getDataOrdine());
        vendita.setTotaleOrdine(venditaDTO.getTotaleOrdine());
        vendita.setListaDettaglio(venditaDTO.getListaDettaglio());
        return vendita;
    }

    public VenditaDTO convertiVenditainDTO (Vendita vendita) {
        VenditaDTO venditaDTO = new VenditaDTO();
        venditaDTO.setIdVendita(vendita.getIdVendita());
        venditaDTO.setDataOrdine(vendita.getDataOrdine());
        venditaDTO.setTotaleOrdine(vendita.getTotaleOrdine());
        venditaDTO.setListaDettaglio(vendita.getListaDettaglio());
        return venditaDTO;
    }
}
