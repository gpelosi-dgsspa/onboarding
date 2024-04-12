package com.shop.comicverse.service;

import com.shop.comicverse.entity.Inventario;
import com.shop.comicverse.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

    public void creaInventario(Inventario inventario) {
        inventarioRepository.save(inventario);
    }

    public Optional<Inventario> cercaInventarioId(Integer id) {
        return inventarioRepository.findById(id);
    }

    public List<Inventario> listaInventari() {
        return inventarioRepository.findAll();
    }

    public void cancellaInventario(Integer id){
        inventarioRepository.deleteById(id);
    }
}
