package com.shop.comicverse.service;

import com.shop.comicverse.dto.GenereDTO;
import com.shop.comicverse.entity.Genere;
import com.shop.comicverse.mapping.GenereMapping;
import com.shop.comicverse.repository.GenereRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GenereService {
    @Autowired
    private GenereRepository genereRepository;
    private GenereMapping genereMapping;

    public GenereDTO creaGenere(GenereDTO genereDTO) {
        Genere genere = genereMapping.convertiDTOinGenere(genereDTO);
        Genere newGenere = genereRepository.save(genere);
        return genereMapping.convertiGenereinDTO(newGenere);
    }

    public GenereDTO cercaGenereId(Integer id) {
        Optional<Genere> genereOpt = genereRepository.findById(id);
        Genere genere = genereOpt.orElseThrow(() -> new RuntimeException(String.format("Id Genere %d non trovato", id)));
        return genereMapping.convertiGenereinDTO(genere);
    }

    public List<GenereDTO> listaGeneri() {
        List<Genere> generi = genereRepository.findAll();
        return generi.stream().map(genereMapping::convertiGenereinDTO)
                .collect(Collectors.toList());
    }

    public void cancellaGenere(Integer id){
        genereRepository.deleteById(id);
    }

    public GenereDTO aggiornaGenere (GenereDTO genereDTO){
        try {
            cercaGenereId(genereDTO.getIdGenere());
            Genere genereUp = genereMapping.convertiDTOinGenere(genereDTO);
            Genere upGenere = genereRepository.save(genereUp);
            return genereMapping.convertiGenereinDTO(upGenere);
        } catch (Exception e){
            throw new RuntimeException("Aggiornamento fallito");
        }
    }
}
