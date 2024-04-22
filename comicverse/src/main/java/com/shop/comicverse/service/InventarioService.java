package com.shop.comicverse.service;

import com.shop.comicverse.dto.InventarioDTO;
import com.shop.comicverse.entity.Inventario;
import com.shop.comicverse.mapping.InventarioMapping;
import com.shop.comicverse.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;
    @Autowired
    private InventarioMapping inventarioMapping;

    public InventarioDTO creaInventario(InventarioDTO inventarioDTO) {
        Inventario inventario = inventarioMapping.convertiDTOinInventario(inventarioDTO);
        Inventario newInventario = inventarioRepository.save(inventario);
        return inventarioMapping.convertiInventarioinDTO(newInventario);
    }

    public InventarioDTO cercaInventarioId(Integer id) {
        Optional<Inventario> inventarioOpt = inventarioRepository.findById(id);
        Inventario inventario = inventarioOpt.orElseThrow(() -> new RuntimeException(String.format("Id Inventario %d non trovato", id)));
        return inventarioMapping.convertiInventarioinDTO(inventario);
    }

    public List<InventarioDTO> listaInventari() {
        List<Inventario> inventari = inventarioRepository.findAll();
        return inventari.stream().map(inventarioMapping::convertiInventarioinDTO)
                .collect(Collectors.toList());
    }

    public void cancellaInventario(Integer id){
        inventarioRepository.deleteById(id);
    }

    public InventarioDTO aggiornaInventario (InventarioDTO inventarioDTO){
        try {
            cercaInventarioId(inventarioDTO.getIdArticolo());
            Inventario inventarioUp = inventarioMapping.convertiDTOinInventario(inventarioDTO);
            Inventario upInventario = inventarioRepository.save(inventarioUp);
            return inventarioMapping.convertiInventarioinDTO(upInventario);
        } catch (Exception e){
            throw new RuntimeException("Aggiornamento fallito");
        }
    }
}
