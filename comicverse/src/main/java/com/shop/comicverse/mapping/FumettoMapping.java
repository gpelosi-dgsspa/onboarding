package com.shop.comicverse.mapping;

import com.shop.comicverse.dto.FumettoDTO;
import com.shop.comicverse.entity.Fumetto;
import org.springframework.stereotype.Component;

@Component
public class FumettoMapping {
    public Fumetto convertiDTOinFumetto (FumettoDTO fumettoDTO){
        Fumetto fumetto = new Fumetto();
        fumetto.setIdFumetto(fumettoDTO.getIdFumetto());
        fumetto.setTitolo(fumettoDTO.getTitolo());
        fumetto.setEditore(fumettoDTO.getEditore());
        fumetto.setVolume(fumettoDTO.getVolume());
        fumetto.setDataPubblicazione(fumettoDTO.getDataPubblicazione());
        fumetto.setDescrizione(fumettoDTO.getDescrizione());
        //fumetto.setListaGeneri(fumettoDTO.getListaGeneri());
        //fumetto.setAutoreFumetto(fumettoDTO.getAutoreFumetto());
        return fumetto;
    }

    public FumettoDTO convertiFumettoinDTO (Fumetto fumetto){
        FumettoDTO fumettoDTO = new FumettoDTO();
        fumettoDTO.setIdFumetto(fumetto.getIdFumetto());
        fumettoDTO.setTitolo(fumetto.getTitolo());
        fumettoDTO.setEditore(fumetto.getEditore());
        fumettoDTO.setVolume(fumetto.getVolume());
        fumettoDTO.setDataPubblicazione(fumetto.getDataPubblicazione());
        fumettoDTO.setDescrizione(fumetto.getDescrizione());
        //fumettoDTO.setListaGeneri(fumetto.getListaGeneri());
        //fumettoDTO.setAutoreFumetto(fumetto.getAutoreFumetto());
        return fumettoDTO;
    }
}
