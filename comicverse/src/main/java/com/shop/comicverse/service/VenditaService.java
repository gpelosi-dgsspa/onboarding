package com.shop.comicverse.service;

import com.shop.comicverse.entity.Vendita;
import com.shop.comicverse.repository.VenditaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class VenditaService {
    @Autowired
    private VenditaRepository venditaRepository;

    public void creaVendita(Vendita vendita) {
        venditaRepository.save(vendita);
    }

    public Optional<Vendita> cercaVenditaId(Integer id) {
        return venditaRepository.findById(id);
    }

    public List<Vendita> listaVendite() {
        return venditaRepository.findAll();
    }

    public void cancellaVendita(Integer id){
        venditaRepository.deleteById(id);
    }
}
