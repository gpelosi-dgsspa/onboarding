package com.shop.comicverse.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.comicverse.dto.InventarioDTO;
import com.shop.comicverse.entity.Inventario;
import com.shop.comicverse.mapper.InventarioMapping;
import com.shop.comicverse.repository.InventarioRepository;

@Service
public class InventarioService {

    private final InventarioRepository inventarioRepository;
    private final InventarioMapping inventarioMapping;

    @Autowired
    public InventarioService(InventarioRepository inventarioRepository, InventarioMapping inventarioMapping) {
        this.inventarioRepository = inventarioRepository;
		this.inventarioMapping = inventarioMapping;
    }

    public InventarioDTO trovaArticoloPerId(Integer id) {
        Optional<Inventario> inventarioOptional = inventarioRepository.findById(id);
        Inventario inventario = inventarioOptional.orElseThrow(() -> new RuntimeException("Articolo non trovato"));
        return inventarioMapping.convertiInventarioInDTO(inventario);
    }

    public InventarioDTO salvaArticolo(InventarioDTO articoloDTO) {
    	Inventario inventario = inventarioMapping.convertiDTOInInventario(articoloDTO);
    	Inventario savedInventario = inventarioRepository.save(inventario);
        return inventarioMapping.convertiInventarioInDTO(savedInventario);
    }

    public InventarioDTO aggiornaArticolo(InventarioDTO articoloDTO) {
    	Inventario inventarioToUpdate = inventarioMapping.convertiDTOInInventario(articoloDTO);
        if (inventarioToUpdate.getIdArticolo() != null && inventarioRepository.existsById(inventarioToUpdate.getIdArticolo())) {
           Inventario updatedInventario = inventarioRepository.save(inventarioToUpdate);
        	return inventarioMapping.convertiInventarioInDTO(updatedInventario);
        } else {
            throw new RuntimeException("Articolo non trovato per l'aggiornamento");
        }
    }

    public void eliminaArticoloPerId(Integer id) {
        inventarioRepository.deleteById(id);
    }

    public List<InventarioDTO> trovaTuttiArticoli() {
    	List<Inventario> inventari = inventarioRepository.findAll();
        return inventari.stream()
                .map(inventarioMapping::convertiInventarioInDTO)
                .collect(Collectors.toList());
    }
}
