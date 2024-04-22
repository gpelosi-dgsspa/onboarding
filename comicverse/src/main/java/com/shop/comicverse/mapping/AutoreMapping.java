package com.shop.comicverse.mapping;

import com.shop.comicverse.dto.AutoreDTO;
import com.shop.comicverse.entity.Autore;
import org.springframework.stereotype.Component;

@Component
public class AutoreMapping {

    public Autore convertiDTOinAutore (AutoreDTO autoreDTO){
        Autore autore = new Autore();
        autore.setIdAutore(autoreDTO.getIdAutore());
        autore.setNomeCognome(autoreDTO.getNomeCognome());
        autore.setBiografia(autoreDTO.getBiografia());
        autore.setVivo(autoreDTO.isVivo());
        autore.setListaFumetti(autoreDTO.getListaFumetti());
        return autore;
    }

    public AutoreDTO convertiAutoreinDTO (Autore autore){
        AutoreDTO autoreDTO = new AutoreDTO();
        autoreDTO.setIdAutore(autore.getIdAutore());
        autoreDTO.setNomeCognome(autore.getNomeCognome());
        autoreDTO.setBiografia(autore.getBiografia());
        autoreDTO.setVivo(autore.isVivo());
        autoreDTO.setListaFumetti(autore.getListaFumetti());
        return autoreDTO;
    }
}
