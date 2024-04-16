package com.shop.comicverse.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.comicverse.dto.FumettoDTO;
import com.shop.comicverse.entity.Fumetto;
import com.shop.comicverse.mapper.FumettoMapping;
import com.shop.comicverse.repository.FumettoRepository;

@Service
public class FumettoService {

    private final FumettoRepository fumettoRepository;
    private final FumettoMapping fumettoMapping;
   

    @Autowired
    public FumettoService(FumettoRepository fumettoRepository, FumettoMapping fumettoMapping) {
        this.fumettoRepository = fumettoRepository;
		this.fumettoMapping = fumettoMapping;
    }
    
    public FumettoDTO trovaFumettoPerId(Long id) {
        Optional<Fumetto> fumettoOptional = fumettoRepository.findById(id);
        Fumetto fumetto = fumettoOptional.orElseThrow(()-> new RuntimeException("Fumetto non trovato"));
        return fumettoMapping.convertiFumettoInDTO(fumetto);
    }
    
    public FumettoDTO salvaFumetto(FumettoDTO fumettoDTO) {
    	Fumetto fumetto = fumettoMapping.convertiDTOInFumetto(fumettoDTO);
    	Fumetto savedFumetto= fumettoRepository.save(fumetto);
        return fumettoMapping.convertiFumettoInDTO(savedFumetto);
    }
    
    public FumettoDTO aggiornaFumetto(FumettoDTO fumettoDTO) {
    	Fumetto fumettoToUpdate = fumettoMapping.convertiDTOInFumetto(fumettoDTO);
        if (fumettoToUpdate.getIdFumetto()>0&& fumettoRepository.existsById((long)fumettoToUpdate.getIdFumetto())) {
        	Fumetto updatedFumetto = fumettoRepository.save(fumettoToUpdate);
        	return fumettoMapping.convertiFumettoInDTO(updatedFumetto);
        }else {
            throw new RuntimeException("Fumetto non trovato per l'aggiornamento");
        }
    }

    public void eliminaFumettoPerId(Long id) {
        fumettoRepository.deleteById(id);
    }

    public List<FumettoDTO> trovaTuttiFumetti() {
    	List<Fumetto> fumetti = fumettoRepository.findAll();
    	   return fumetti.stream()
                   .map(fumettoMapping::convertiFumettoInDTO)
                   .collect(Collectors.toList());
       }
}
