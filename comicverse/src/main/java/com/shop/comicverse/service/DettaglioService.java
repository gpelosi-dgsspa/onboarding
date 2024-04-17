package com.shop.comicverse.service;

import com.shop.comicverse.dto.DettaglioDTO;
import com.shop.comicverse.entity.Dettaglio;
import com.shop.comicverse.mapping.DettaglioMapping;
import com.shop.comicverse.repository.DettaglioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DettaglioService {
    @Autowired
    private DettaglioRepository dettaglioRepository;
    private DettaglioMapping dettaglioMapping;

    public DettaglioDTO creaDettaglio(DettaglioDTO dettaglioDTO) {
        Dettaglio dettaglio = dettaglioMapping.convertiDTOinDettaglio(dettaglioDTO);
        Dettaglio newDettaglio = dettaglioRepository.save(dettaglio);
        return dettaglioMapping.convertiDettaglioinDTO(newDettaglio);
    }

    public DettaglioDTO cercaDettaglioId(Integer id) {
        Optional<Dettaglio> dettaglioOpt = dettaglioRepository.findById(id);
        Dettaglio dettaglio = dettaglioOpt.orElseThrow(() -> new RuntimeException(String.format("Id Dettaglio %d non trovato", id)));
        return dettaglioMapping.convertiDettaglioinDTO(dettaglio);
    }

    public List<DettaglioDTO> listaDettagli() {
        List<Dettaglio> dettagli = dettaglioRepository.findAll();
        return dettagli.stream().map(dettaglioMapping::convertiDettaglioinDTO)
                .collect(Collectors.toList());
    }

    public void cancellaDettaglio(Integer id){
        dettaglioRepository.deleteById(id);
    }

    public DettaglioDTO aggiornaDettaglio (DettaglioDTO dettaglioDTO){
        try {
            cercaDettaglioId(dettaglioDTO.getIdDettaglio());
            Dettaglio dettaglioUp = dettaglioMapping.convertiDTOinDettaglio(dettaglioDTO);
            Dettaglio upDettaglio = dettaglioRepository.save(dettaglioUp);
            return dettaglioMapping.convertiDettaglioinDTO(upDettaglio);
        } catch (Exception e){
            throw new RuntimeException("Aggiornamento fallito");
        }
    }
}
