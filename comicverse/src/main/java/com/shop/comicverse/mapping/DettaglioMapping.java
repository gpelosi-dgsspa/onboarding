package com.shop.comicverse.mapping;

import com.shop.comicverse.dto.DettaglioDTO;
import com.shop.comicverse.entity.Dettaglio;
import org.springframework.stereotype.Component;

@Component
public class DettaglioMapping {

    public Dettaglio convertiDTOinDettaglio (DettaglioDTO dettaglioDTO){
        Dettaglio dettaglio = new Dettaglio();
        dettaglio.setIdDettaglio(dettaglioDTO.getIdDettaglio());
        dettaglio.setQuantita(dettaglioDTO.getQuantita());
        dettaglio.setOggetto(dettaglioDTO.getOggetto());
        return dettaglio;
    }

    public DettaglioDTO convertiDettaglioinDTO (Dettaglio dettaglio){
        DettaglioDTO dettaglioDTO = new DettaglioDTO();
        dettaglioDTO.setIdDettaglio(dettaglio.getIdDettaglio());
        dettaglioDTO.setQuantita(dettaglio.getQuantita());
        dettaglioDTO.setOggetto(dettaglio.getOggetto());
        return dettaglioDTO;
    }
}
