package com.shop.comicverse.mapping;

import com.shop.comicverse.dto.AutoreDTO;
import com.shop.comicverse.dto.GenereDTO;
import com.shop.comicverse.entity.Autore;
import com.shop.comicverse.entity.Genere;
import org.springframework.stereotype.Component;

@Component
public class GenereMapping {

    public Genere convertiDTOinGenere (GenereDTO genereDTO){
        Genere genere = new Genere();
        genere.setIdGenere(genereDTO.getIdGenere());
        genere.setNome(genereDTO.getNome());
        return genere;
    }

    public GenereDTO convertiGenereinDTO (Genere genere){
        GenereDTO genereDTO = new GenereDTO();
        genereDTO.setIdGenere(genere.getIdGenere());
        genereDTO.setNome(genere.getNome());
        return genereDTO;
    }
}
