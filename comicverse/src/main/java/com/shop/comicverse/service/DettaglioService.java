package com.shop.comicverse.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.comicverse.dto.DettaglioDTO;
import com.shop.comicverse.entity.Dettaglio;
import com.shop.comicverse.mapper.DettaglioMapping;
import com.shop.comicverse.repository.DettaglioRepository;

@Service
public class DettaglioService {

    private final DettaglioRepository dettaglioRepository;
    private final DettaglioMapping dettaglioMapping;

    @Autowired
    public DettaglioService(DettaglioRepository dettaglioRepository) {
        this.dettaglioRepository = dettaglioRepository;
		this.dettaglioMapping = new DettaglioMapping();
    }

//Se l'Optional dettaglioOptional contiene un Dettaglio, assegna questo Dettaglio alla variabile dettaglio.
//Se l'Optional è vuoto (cioè non contiene un Dettaglio), viene lanciata un'eccezione RuntimeException con il messaggio "Dettaglio non trovato".
  
    public DettaglioDTO trovaDettaglioPerId(Long id) {
        Optional<Dettaglio> dettaglioOptional = dettaglioRepository.findById(id);
        Dettaglio dettaglio = dettaglioOptional.orElseThrow(() -> new RuntimeException("Dettaglio non trovato"));
        return dettaglioMapping.convertiDettaglioInDTO(dettaglio);
    }

    public DettaglioDTO salvaDettaglio(DettaglioDTO dettaglioDTO) {
    	Dettaglio dettaglio = dettaglioMapping.convertiDTOInDettaglio(dettaglioDTO);
    	Dettaglio savedDettaglio=dettaglioRepository.save(dettaglio);
    	return dettaglioMapping.convertiDettaglioInDTO(savedDettaglio);
    }

    public DettaglioDTO aggiornaDettaglio(DettaglioDTO dettaglioDTO) {
    	Dettaglio dettaglioToUpdate = dettaglioMapping.convertiDTOInDettaglio(dettaglioDTO);
        if (dettaglioToUpdate.getIdDettaglio() > 0 && dettaglioRepository.existsById((long)dettaglioToUpdate.getIdDettaglio())) {
           Dettaglio updatedDettaglio = dettaglioRepository.save(dettaglioToUpdate);
        	return dettaglioMapping.convertiDettaglioInDTO(updatedDettaglio);
        } else {
            throw new RuntimeException("Dettaglio non trovato per l'aggiornamento");
        }
    }

    public void eliminaDettaglioPerId(Long id) {
        dettaglioRepository.deleteById(id);
    }

    //stream(): converte la collezione di dettagli in uno stream di elementi. 
    //.map(dettaglioMapping::convertiDettaglioInDTO): operazione di mappatura su uno stream. Il metodo map prende ciascun elemento dello stream (in questo caso, ciascun oggetto Dettaglio dalla lista dettagli) e applica la funzione convertiDettaglioInDTO del mapper dettaglioMapping a ciascun elemento.
    //.collect(Collectors.toList()): Questo è un'operazione raccoglie gli elementi mappati (cioè gli oggetti DettaglioDTO) in una lista. Utilizzando Collectors.toList(), gli elementi vengono raccolti e restituiti come una lista di DettaglioDTO
   
    public List<DettaglioDTO> trovaTuttiDettagli() {
    	List<Dettaglio> dettagli = dettaglioRepository.findAll();
        return dettagli.stream()
        		.map(dettaglioMapping::convertiDettaglioInDTO)
        		.collect(Collectors.toList());
    }
}
