package com.shop.comicverse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.comicverse.dto.DettaglioDTO;
import com.shop.comicverse.dto.InventarioDTO;
import com.shop.comicverse.dto.VenditaDTO;
import com.shop.comicverse.service.DettaglioService;
import com.shop.comicverse.service.InventarioService;
import com.shop.comicverse.service.VenditaService;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    private final InventarioService articoloService;
    private final VenditaService venditaService;
    private final DettaglioService dettaglioService;

    @Autowired
    public InventarioController(InventarioService articoloService, VenditaService venditaService, DettaglioService dettaglioService) {
        this.articoloService = articoloService;
        this.venditaService = venditaService;
        this.dettaglioService = dettaglioService;
    }

    // Endpoint per gestire operazioni sugli articoli

    @PostMapping("/crea-articolo")
    public ResponseEntity<InventarioDTO> creaArticolo(@RequestBody InventarioDTO articoloDTO) {
    	InventarioDTO nuovoArticolo = articoloService.salvaArticolo(articoloDTO);
        return new ResponseEntity<>(nuovoArticolo, HttpStatus.CREATED);
    }

    @GetMapping("/cerca-articolo-per-id/{id}")
    public ResponseEntity<InventarioDTO> getArticoloById(@PathVariable Integer id) {
    	InventarioDTO articoloDTO = articoloService.trovaArticoloPerId(id);
        return ResponseEntity.ok(articoloDTO);
    }

    @PutMapping("/aggiorna-articolo/{id}")
    public ResponseEntity<InventarioDTO> aggiornaArticolo(@PathVariable Integer id, @RequestBody InventarioDTO articoloDTO) {
        articoloDTO.setIdArticolo(id);
        InventarioDTO articoloAggiornato = articoloService.aggiornaArticolo(articoloDTO);
        return ResponseEntity.ok(articoloAggiornato);
    }

    @DeleteMapping("/elimina-articolo/{id}")
    public ResponseEntity<Void> eliminaArticolo(@PathVariable Integer id) {
        articoloService.eliminaArticoloPerId(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint per gestire operazioni sulle vendite

    @PostMapping("/crea-vendita")
    public ResponseEntity<VenditaDTO> creaVendita(@RequestBody VenditaDTO venditaDTO) {
        VenditaDTO nuovaVendita = venditaService.salvaVendita(venditaDTO);
        return new ResponseEntity<>(nuovaVendita, HttpStatus.CREATED);
    }

    @GetMapping("/cerca-vendita-per-id/{id}")
    public ResponseEntity<VenditaDTO> getVenditaById(@PathVariable Long id) {
        VenditaDTO venditaDTO = venditaService.trovaVenditaPerId(id);
        return ResponseEntity.ok(venditaDTO);
    }

    @PutMapping("/aggiorna-vendita/{id}")
    public ResponseEntity<VenditaDTO> aggiornaVendita(@PathVariable Integer id, @RequestBody VenditaDTO venditaDTO) {
        venditaDTO.setIdVendita(id);
        VenditaDTO venditaAggiornata = venditaService.aggiornaVendita(venditaDTO);
        return ResponseEntity.ok(venditaAggiornata);
    }

    @DeleteMapping("/elimina-vendite/{id}")
    public ResponseEntity<Void> eliminaVendita(@PathVariable Long id) {
        venditaService.eliminaVenditaPerId(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint per gestire operazioni sui dettagli

    @PostMapping("/crea-dettaglo")
    public ResponseEntity<DettaglioDTO> creaDettaglio(@RequestBody DettaglioDTO dettaglioDTO) {
        DettaglioDTO nuovoDettaglio = dettaglioService.salvaDettaglio(dettaglioDTO);
        return new ResponseEntity<>(nuovoDettaglio, HttpStatus.CREATED);
    }

    @GetMapping("/cerca-dettaglio-per-id/{id}")
    public ResponseEntity<DettaglioDTO> getDettaglioById(@PathVariable Long id) {
        DettaglioDTO dettaglioDTO = dettaglioService.trovaDettaglioPerId(id);
        return ResponseEntity.ok(dettaglioDTO);
    }

    @PutMapping("/aggiorna-dettaglo/{id}")
    public ResponseEntity<DettaglioDTO> aggiornaDettaglio(@PathVariable Integer id, @RequestBody DettaglioDTO dettaglioDTO) {
        dettaglioDTO.setIdDettaglio(id);
        DettaglioDTO dettaglioAggiornato = dettaglioService.aggiornaDettaglio(dettaglioDTO);
        return ResponseEntity.ok(dettaglioAggiornato);
    }

    @DeleteMapping("/elimina-dettaglo/{id}")
    public ResponseEntity<Void> eliminaDettaglio(@PathVariable Long id) {
        dettaglioService.eliminaDettaglioPerId(id);
        return ResponseEntity.noContent().build();
    }
}
