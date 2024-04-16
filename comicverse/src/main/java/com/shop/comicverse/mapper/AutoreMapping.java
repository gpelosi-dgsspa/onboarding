package com.shop.comicverse.mapper;

import org.springframework.stereotype.Component;

import com.shop.comicverse.dto.AutoreDTO;
import com.shop.comicverse.entity.Autore;

@Component
public class AutoreMapping {

	public Autore convertiDTOInAutore(AutoreDTO autoreDTO) {
        Autore autore = new Autore();
        autore.setIdAutore(autoreDTO.getIdAutore());
        autore.setNomeCognome(autoreDTO.getNomeCognome());
        autore.setBiografia(autoreDTO.getBiografia());
        autore.setVivo(autoreDTO.isVivo());
        return autore;
    }

    public AutoreDTO convertiAutoreInDTO(Autore autore) {
        AutoreDTO autoreDTO = new AutoreDTO();
        autoreDTO.setIdAutore(autore.getIdAutore());
        autoreDTO.setNomeCognome(autore.getNomeCognome());
        autoreDTO.setBiografia(autore.getBiografia());
        autoreDTO.setVivo(autore.isVivo());
        return autoreDTO;
    }
}
