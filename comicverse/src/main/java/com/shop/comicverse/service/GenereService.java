package com.shop.comicverse.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.comicverse.dto.GenereDTO;
import com.shop.comicverse.entity.Genere;
import com.shop.comicverse.mapper.GenereMapping;
import com.shop.comicverse.repository.GenereRepository;

@Service
public class GenereService {

    private final GenereRepository genereRepository;
    private final GenereMapping genereMapping;

    @Autowired
    public GenereService(GenereRepository genereRepository, GenereMapping genereMapping) {
        this.genereRepository = genereRepository;
		this.genereMapping = genereMapping;
    }

    public GenereDTO trovaGenerePerId(Long id) {
        Optional<Genere> genereOptional = genereRepository.findById(id);
        Genere genere = genereOptional.orElseThrow(() -> new RuntimeException("Genere non trovato"));
        return genereMapping.convertiGenereInDTO(genere);
    }

    public GenereDTO salvaGenere(GenereDTO genereDTO) {
    	Genere genere = genereMapping.convertiDTOInGenere(genereDTO);
    	Genere savedGenere = genereRepository.save(genere);
        return genereMapping.convertiGenereInDTO(savedGenere);
    }

    public GenereDTO aggiornaGenere(GenereDTO genereDTO) {
    	Genere genereToUpdate = genereMapping.convertiDTOInGenere(genereDTO);
        if (genereToUpdate.getIdGenere() > 0 && genereRepository.existsById((long)genereToUpdate.getIdGenere())) {
            Genere updatedGenere = genereRepository.save(genereToUpdate);
        	return genereMapping.convertiGenereInDTO(updatedGenere);
        } else {
            throw new RuntimeException("Genere non trovato per l'aggiornamento");
        }
    }

    public void eliminaGenerePerId(Long id) {
        genereRepository.deleteById(id);
    }

    public List<GenereDTO> trovaTuttiGeneri() {
    	 List<Genere> generi = genereRepository.findAll();
         return generi.stream()
                 .map(genereMapping::convertiGenereInDTO)
                 .collect(Collectors.toList());    }
}
