package com.shop.comicverse.controller;

import com.shop.comicverse.dto.AutoreDTO;
import com.shop.comicverse.dto.FumettoDTO;
import com.shop.comicverse.dto.GenereDTO;
import com.shop.comicverse.service.AutoreService;
import com.shop.comicverse.service.FumettoService;
import com.shop.comicverse.service.GenereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gestione-entita")
public class FumettoController {

    private final FumettoService fumettoService;
    private final AutoreService autoreService;
    private final GenereService genereService;

    @Autowired
    public FumettoController(FumettoService fumettoService, AutoreService autoreService, GenereService genereService) {
        this.fumettoService = fumettoService;
        this.autoreService = autoreService;
        this.genereService = genereService;
    }

    // Endpoint per gestire operazioni sui Fumetti

    @PostMapping("/crea-fumetto")
    public ResponseEntity<FumettoDTO> creaFumetto(@RequestBody FumettoDTO fumettoDTO) {
        FumettoDTO nuovoFumetto = fumettoService.salvaFumetto(fumettoDTO);
        return new ResponseEntity<>(nuovoFumetto, HttpStatus.CREATED);
    }

    @GetMapping("/cerca-fumetto-per-id/{id}")
    public ResponseEntity<FumettoDTO> getFumettoById(@PathVariable Long id) {
        FumettoDTO fumettoDTO = fumettoService.trovaFumettoPerId(id);
        return ResponseEntity.ok(fumettoDTO);
    }

    @PutMapping("/aggiorna-fumetto/{id}")
    public ResponseEntity<FumettoDTO> aggiornaFumetto(@PathVariable Integer id, @RequestBody FumettoDTO fumettoDTO) {
        fumettoDTO.setIdFumetto(id);
        FumettoDTO fumettoAggiornato = fumettoService.aggiornaFumetto(fumettoDTO);
        return ResponseEntity.ok(fumettoAggiornato);
    }

    @DeleteMapping("/elimina-fumetto/{id}")
    public ResponseEntity<Void> eliminaFumetto(@PathVariable Long id) {
        fumettoService.eliminaFumettoPerId(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint per gestire operazioni sugli Autori

    @PostMapping("/crea-autori")
    public ResponseEntity<AutoreDTO> creaAutore(@RequestBody AutoreDTO autoreDTO) {
        AutoreDTO nuovoAutore = autoreService.salvaAutore(autoreDTO);
        return new ResponseEntity<>(nuovoAutore, HttpStatus.CREATED);
    }

    @GetMapping("/cerca-autore-per-id/{id}")
    public ResponseEntity<AutoreDTO> getAutoreById(@PathVariable Long id) {
        AutoreDTO autoreDTO = autoreService.trovaAutorePerId(id);
        return ResponseEntity.ok(autoreDTO);
    }

    @PutMapping("/aggiorna-autore/{id}")
    public ResponseEntity<AutoreDTO> aggiornaAutore(@PathVariable Integer id, @RequestBody AutoreDTO autoreDTO) {
        autoreDTO.setIdAutore(id);
        AutoreDTO autoreAggiornato = autoreService.aggiornaAutore(autoreDTO);
        return ResponseEntity.ok(autoreAggiornato);
    }

    @DeleteMapping("/elimina-autore/{id}")
    public ResponseEntity<Void> eliminaAutore(@PathVariable Long id) {
        autoreService.eliminaAutorePerId(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint per gestire operazioni sui Generi

    @PostMapping("/crea-genere")
    public ResponseEntity<GenereDTO> creaGenere(@RequestBody GenereDTO genereDTO) {
        GenereDTO nuovoGenere = genereService.salvaGenere(genereDTO);
        return new ResponseEntity<>(nuovoGenere, HttpStatus.CREATED);
    }

    @GetMapping("/cerca-genere-per-id/{id}")
    public ResponseEntity<GenereDTO> getGenereById(@PathVariable Long id) {
        GenereDTO genereDTO = genereService.trovaGenerePerId(id);
        return ResponseEntity.ok(genereDTO);
    }

    @PutMapping("/aggiorna-genere/{id}")
    public ResponseEntity<GenereDTO> aggiornaGenere(@PathVariable Integer id, @RequestBody GenereDTO genereDTO) {
        genereDTO.setIdGenere(id);
        GenereDTO genereAggiornato = genereService.aggiornaGenere(genereDTO);
        return ResponseEntity.ok(genereAggiornato);
    }

    @DeleteMapping("/elimina-genere/{id}")
    public ResponseEntity<Void> eliminaGenere(@PathVariable Long id) {
        genereService.eliminaGenerePerId(id);
        return ResponseEntity.noContent().build();
    }
}
