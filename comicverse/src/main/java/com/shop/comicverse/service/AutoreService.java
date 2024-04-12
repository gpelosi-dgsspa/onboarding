package com.shop.comicverse.service;

import com.shop.comicverse.entity.Autore;
import com.shop.comicverse.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AutoreService {
    @Autowired
    private AutoreRepository autoreRepository;

    public void creaAutore(Autore autore) {
        autoreRepository.save(autore);
    }

    public Optional<Autore> cercaAutoreId(Integer id) {
        return autoreRepository.findById(id);
    }

    public List<Autore> listaAutori() {
        return autoreRepository.findAll();
    }

    public void cancellaAutore(Integer id){
        autoreRepository.deleteById(id);
    }
}
