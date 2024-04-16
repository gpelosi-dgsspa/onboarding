package com.shop.comicverse.service;

import com.shop.comicverse.dto.AutoreDTO;
import com.shop.comicverse.entity.Autore;
import com.shop.comicverse.mapper.AutoreMapping;
import com.shop.comicverse.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutoreService {

    private final AutoreRepository autoreRepository;
    private final AutoreMapping autoreMapping;

    @Autowired
    public AutoreService(AutoreRepository autoreRepository, AutoreMapping autoreMapping) {
        this.autoreRepository = autoreRepository;
        this.autoreMapping=autoreMapping; 
        }

    public AutoreDTO salvaAutore(AutoreDTO autoreDTO) {
        Autore autore = autoreMapping.convertiDTOInAutore(autoreDTO);
        Autore savedAutore = autoreRepository.save(autore);
        return autoreMapping.convertiAutoreInDTO(savedAutore);
    }

    public AutoreDTO aggiornaAutore(AutoreDTO autoreDTO) {
        Autore autoreToUpdate = autoreMapping.convertiDTOInAutore(autoreDTO);
        if (autoreToUpdate.getIdAutore() > 0 && autoreRepository.existsById((long)autoreToUpdate.getIdAutore())) {
            Autore updatedAutore = autoreRepository.save(autoreToUpdate);
            return autoreMapping.convertiAutoreInDTO(updatedAutore);
        } else {
            throw new RuntimeException("Autore non trovato per l'aggiornamento");
        }
    }

    public AutoreDTO trovaAutorePerId(Long id) {
        Optional<Autore> autoreOptional = autoreRepository.findById(id);
        Autore autore = autoreOptional.orElseThrow(() -> new RuntimeException("Autore non trovato"));
        return autoreMapping.convertiAutoreInDTO(autore);
    }

    public void eliminaAutorePerId(Long id) {
        autoreRepository.deleteById(id);
    }

    public List<AutoreDTO> trovaTuttiAutori() {
        List<Autore> autori = autoreRepository.findAll();
        return autori.stream()
                .map(autoreMapping::convertiAutoreInDTO)
                .collect(Collectors.toList());
    }


    
}
