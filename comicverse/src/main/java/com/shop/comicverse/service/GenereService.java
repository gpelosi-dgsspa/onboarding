package com.shop.comicverse.service;

import com.shop.comicverse.entity.Genere;
import com.shop.comicverse.repository.GenereRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class GenereService {
    @Autowired
    private GenereRepository genereRepository;

    public void creaGenere(Genere genere) {
        genereRepository.save(genere);
    }

    public Optional<Genere> cercaGenereId(Integer id) {
        return genereRepository.findById(id);
    }

    public List<Genere> listaGeneri() {
        return genereRepository.findAll();
    }

    public void cancellaGenere(Integer id){
        genereRepository.deleteById(id);
    }
}
