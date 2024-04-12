package com.shop.comicverse.service;

import com.shop.comicverse.entity.Dettaglio;
import com.shop.comicverse.repository.DettaglioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DettaglioService {
    @Autowired
    private DettaglioRepository dettaglioRepository;

    public void creaDettaglio(Dettaglio dettaglio) {
        dettaglioRepository.save(dettaglio);
    }

    public Optional<Dettaglio> cercaDettaglioId(Integer id) {
        return dettaglioRepository.findById(id);
    }

    public List<Dettaglio> listaDettagli() {
        return dettaglioRepository.findAll();
    }

    public void cancellaDettaglio(Integer id){
        dettaglioRepository.deleteById(id);
    }
}
