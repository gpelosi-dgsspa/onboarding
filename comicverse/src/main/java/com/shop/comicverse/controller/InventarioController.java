package com.shop.comicverse.controller;

import com.shop.comicverse.dto.*;
import com.shop.comicverse.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestione-inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;
    @Autowired
    private VenditaService venditaService;
    @Autowired
    private DettaglioService dettaglioService;

    //CRUD Create
    @PostMapping("/crea-articolo")
    public ResponseEntity<InventarioDTO> creaInventario (@RequestBody InventarioDTO inventarioDTO){
        InventarioDTO newInventario = inventarioService.creaInventario(inventarioDTO);
        return new ResponseEntity<>(newInventario, HttpStatus.CREATED);
    }

    @PostMapping("/crea-vendita")
    public ResponseEntity<VenditaDTO> creaVendita (@RequestBody VenditaDTO venditaDTO){
        VenditaDTO newVendita = venditaService.creaVendita(venditaDTO);
        return new ResponseEntity<>(newVendita, HttpStatus.CREATED);
    }

    @PostMapping("/crea-dettaglio")
    public ResponseEntity<DettaglioDTO> creaDettaglio (@RequestBody DettaglioDTO dettaglioDTO){
        DettaglioDTO newDettaglio = dettaglioService.creaDettaglio(dettaglioDTO);
        return new ResponseEntity<>(newDettaglio, HttpStatus.CREATED);
    }

    //CRUD Read
    @GetMapping("/cerca-id-articolo/{id}")
    public ResponseEntity<InventarioDTO> cercaIdInventario (@PathVariable Integer id){
        InventarioDTO findInventario = inventarioService.cercaInventarioId(id);
        return ResponseEntity.ok(findInventario);
    }

    @GetMapping("/cerca-id-vendita/{id}")
    public ResponseEntity<VenditaDTO> cercaIdVendita (@PathVariable Integer id){
        VenditaDTO findVendita = venditaService.cercaVenditaId(id);
        return ResponseEntity.ok(findVendita);
    }

    @GetMapping("/cerca-id-dettaglio/{id}")
    public ResponseEntity<DettaglioDTO> cercaIdDettaglio (@PathVariable Integer id){
        DettaglioDTO findDettaglio = dettaglioService.cercaDettaglioId(id);
        return ResponseEntity.ok(findDettaglio);
    }

    //CRUD Display all
    @GetMapping("/lista-articolo")
    public ResponseEntity<List<InventarioDTO>> listaInventario (){
        List<InventarioDTO> allInventari = inventarioService.listaInventari();
        return new ResponseEntity<>(allInventari, HttpStatus.OK);
    }

    @GetMapping("/lista-vendita")
    public ResponseEntity<List<VenditaDTO>> listaVendita (){
        List<VenditaDTO> allVendite = venditaService.listaVendite();
        return new ResponseEntity<>(allVendite, HttpStatus.OK);
    }

    @GetMapping("/lista-dettaglio")
    public ResponseEntity<List<DettaglioDTO>> listaDettaglio (){
        List<DettaglioDTO> allDettagli = dettaglioService.listaDettagli();
        return new ResponseEntity<>(allDettagli, HttpStatus.OK);
    }

    //CRUD Update
    @PutMapping("/aggiorna-articolo/{id}")
    public ResponseEntity<InventarioDTO> aggiornaInventario (@RequestBody InventarioDTO inventarioDTO, @PathVariable Integer id) {
        inventarioDTO.setIdArticolo(id);
        InventarioDTO updatedInventario = inventarioService.aggiornaInventario(inventarioDTO);
        return ResponseEntity.ok(updatedInventario);
    }

    @PutMapping("/aggiorna-vendita/{id}")
    public ResponseEntity<VenditaDTO> aggiornaVendita (@RequestBody VenditaDTO venditaDTO, @PathVariable Integer id) {
        venditaDTO.setIdVendita(id);
        VenditaDTO updatedVendita = venditaService.aggiornaVendita(venditaDTO);
        return ResponseEntity.ok(updatedVendita);
    }

    @PutMapping("/aggiorna-dettaglio/{id}")
    public ResponseEntity<DettaglioDTO> aggiornaDettaglio (@RequestBody DettaglioDTO dettaglioDTO, @PathVariable Integer id) {
        dettaglioDTO.setIdDettaglio(id);
        DettaglioDTO updatedDettaglio = dettaglioService.aggiornaDettaglio(dettaglioDTO);
        return ResponseEntity.ok(updatedDettaglio);
    }

    //CRUD Delete
    @DeleteMapping("/elimina-articolo/{id}")
    public ResponseEntity<Void> eliminaInventario (@PathVariable Integer id) {
        inventarioService.cancellaInventario(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/elimina-vendita/{id}")
    public ResponseEntity<Void> eliminaVendita (@PathVariable Integer id) {
        venditaService.cancellaVendita(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/elimina-dettaglio/{id}")
    public ResponseEntity<Void> eliminaDettaglio (@PathVariable Integer id) {
        dettaglioService.cancellaDettaglio(id);
        return ResponseEntity.noContent().build();
    }
}
