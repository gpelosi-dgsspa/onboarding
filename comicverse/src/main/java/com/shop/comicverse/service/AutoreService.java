package com.shop.comicverse.service;

import com.shop.comicverse.dto.AutoreDTO;
import com.shop.comicverse.entity.Autore;
import com.shop.comicverse.mapping.AutoreMapping;
import com.shop.comicverse.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutoreService {
    @Autowired
    private AutoreRepository autoreRepository;
    @Autowired
    private AutoreMapping autoreMapping;

    public AutoreDTO creaAutore(AutoreDTO autoreDTO) {
        Autore autore = autoreMapping.convertiDTOinAutore(autoreDTO);
        Autore newAutore = autoreRepository.save(autore);
        return autoreMapping.convertiAutoreinDTO(newAutore);
    }

    public AutoreDTO cercaAutoreId(Integer id) {
        Optional<Autore> autoreOpt = autoreRepository.findById(id);
        Autore autore = autoreOpt.orElseThrow(() -> new RuntimeException(String.format("Id Autore %d non trovato", id)));
        return autoreMapping.convertiAutoreinDTO(autore);
    }

    public List<AutoreDTO> listaAutori() {
        List<Autore> autori = autoreRepository.findAll();
        return autori.stream().map(autoreMapping::convertiAutoreinDTO)
                .collect(Collectors.toList());
    }

    public void cancellaAutoredaId(Integer id){
        autoreRepository.deleteById(id);
    }

    public AutoreDTO aggiornaAutore (AutoreDTO autoreDTO){
        try {
            cercaAutoreId(autoreDTO.getIdAutore());
            Autore autoreUp = autoreMapping.convertiDTOinAutore(autoreDTO);
            Autore upAutore = autoreRepository.save(autoreUp);
            return autoreMapping.convertiAutoreinDTO(upAutore);
        } catch (Exception e){
            throw new RuntimeException("Aggiornamento fallito");
        }
    }

    public List<Autore> autoriVivi() {
        List<Autore> autoriVivi = autoreRepository.autoriVivi();
        return autoriVivi;
    }
}
