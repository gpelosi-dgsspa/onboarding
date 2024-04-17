package com.shop.comicverse.service;

import com.shop.comicverse.dto.AutoreDTO;
import com.shop.comicverse.dto.VenditaDTO;
import com.shop.comicverse.entity.Autore;
import com.shop.comicverse.entity.Vendita;
import com.shop.comicverse.mapping.VenditaMapping;
import com.shop.comicverse.repository.VenditaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VenditaService {
    @Autowired
    private VenditaRepository venditaRepository;
    private VenditaMapping venditaMapping;

    public VenditaDTO creaVendita(VenditaDTO venditaDTO) {
        Vendita vendita = venditaMapping.convertiDTOinVendita(venditaDTO);
        Vendita newVendita = venditaRepository.save(vendita);
        return venditaMapping.convertiVenditainDTO(newVendita);
    }

    public VenditaDTO cercaVenditaId(Integer id) {
        Optional<Vendita> venditaOpt = venditaRepository.findById(id);
        Vendita vendita = venditaOpt.orElseThrow(() -> new RuntimeException(String.format("Id Vendita %d non trovato", id)));
        return venditaMapping.convertiVenditainDTO(vendita);
    }

    public List<VenditaDTO> listaVendite() {
        List<Vendita> vendite = venditaRepository.findAll();
        return vendite.stream().map(venditaMapping::convertiVenditainDTO)
                .collect(Collectors.toList());
    }

    public void cancellaVendita(Integer id){
        venditaRepository.deleteById(id);
    }

    public VenditaDTO aggiornaVendita (VenditaDTO venditaDTO){
        try {
            cercaVenditaId(venditaDTO.getIdVendita());
            Vendita venditaUp = venditaMapping.convertiDTOinVendita(venditaDTO);
            Vendita upVendita = venditaRepository.save(venditaUp);
            return venditaMapping.convertiVenditainDTO(upVendita);
        } catch (Exception e){
            throw new RuntimeException("Aggiornamento fallito");
        }
    }
}
