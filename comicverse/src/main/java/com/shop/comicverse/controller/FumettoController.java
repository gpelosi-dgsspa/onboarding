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

import java.util.List;

@RestController
@RequestMapping("/fumetti")
public class FumettoController {

    @Autowired
    private FumettoService fumettoService;
    @Autowired
    private AutoreService autoreService;
    @Autowired
    private GenereService genereService;

    //CRUD Create
    @PostMapping("/crea-fumetto")
    public ResponseEntity<FumettoDTO> creaFumetto (@RequestBody FumettoDTO fumettoDTO){
        FumettoDTO newFumetto = fumettoService.creaFumetto(fumettoDTO);
        return new ResponseEntity<>(newFumetto, HttpStatus.CREATED);
    }

    @PostMapping("/crea-autore")
    public ResponseEntity<AutoreDTO> creaAutore (@RequestBody AutoreDTO autoreDTO){
        AutoreDTO newAutore = autoreService.creaAutore(autoreDTO);
        return new ResponseEntity<>(newAutore, HttpStatus.CREATED);
    }

    @PostMapping("/crea-genere")
    public ResponseEntity<GenereDTO> creaGenere (@RequestBody GenereDTO genereDTO){
        GenereDTO newGenere = genereService.creaGenere(genereDTO);
        return new ResponseEntity<>(newGenere, HttpStatus.CREATED);
    }

    //CRUD Read
    @GetMapping("/cerca-id-fumetto/{id}")
    public ResponseEntity<FumettoDTO> cercaIdFumetto (@PathVariable Integer id){
        FumettoDTO findFumetto = fumettoService.cercaFumettoId(id);
        return ResponseEntity.ok(findFumetto);
    }

    @GetMapping("/cerca-id-autore/{id}")
    public ResponseEntity<AutoreDTO> cercaIdAutore (@PathVariable Integer id){
        AutoreDTO findAutore = autoreService.cercaAutoreId(id);
        return ResponseEntity.ok(findAutore);
    }

    @GetMapping("/cerca-id-genere/{id}")
    public ResponseEntity<GenereDTO> cercaIdGenere (@PathVariable Integer id){
        GenereDTO findGenere = genereService.cercaGenereId(id);
        return ResponseEntity.ok(findGenere);
    }

    //CRUD Display all
    @GetMapping("/lista-fumetto")
    public ResponseEntity<List<FumettoDTO>> listaFumetti (){
        List<FumettoDTO> allFumetti = fumettoService.listaFumetti();
        return new ResponseEntity<>(allFumetti, HttpStatus.OK);
    }

    @GetMapping("/lista-autore")
    public ResponseEntity<List<AutoreDTO>> listaAutori (){
        List<AutoreDTO> allAutori = autoreService.listaAutori();
        return new ResponseEntity<>(allAutori, HttpStatus.OK);
    }

    @GetMapping("/lista-genere")
    public ResponseEntity<List<GenereDTO>> listaGeneri (){
        List<GenereDTO> allGeneri = genereService.listaGeneri();
        return new ResponseEntity<>(allGeneri, HttpStatus.OK);
    }

    //CRUD Update
    @PutMapping("/aggiorna-fumetto/{id}")
    public ResponseEntity<FumettoDTO> aggiornaFumetto (@RequestBody FumettoDTO fumettoDTO, @PathVariable Integer id) {
        fumettoDTO.setIdFumetto(id);
        FumettoDTO updatedFumetto = fumettoService.aggiornaFumetto(fumettoDTO);
        return ResponseEntity.ok(updatedFumetto);
    }

    @PutMapping("/aggiorna-autore/{id}")
    public ResponseEntity<AutoreDTO> aggiornaAutore (@RequestBody AutoreDTO autoreDTO, @PathVariable Integer id) {
        autoreDTO.setIdAutore(id);
        AutoreDTO updatedAutore = autoreService.aggiornaAutore(autoreDTO);
        return ResponseEntity.ok(updatedAutore);
    }

    @PutMapping("/aggiorna-genere/{id}")
    public ResponseEntity<GenereDTO> aggiornaGenere (@RequestBody GenereDTO genereDTO, @PathVariable Integer id) {
        genereDTO.setIdGenere(id);
        GenereDTO updatedGenere = genereService.aggiornaGenere(genereDTO);
        return ResponseEntity.ok(updatedGenere);
    }

    //CRUD Delete
    @DeleteMapping("/elimina-fumetto/{id}")
    public ResponseEntity<Void> eliminaFumetto (@PathVariable Integer id) {
        fumettoService.cancellaFumetto(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/elimina-autore/{id}")
    public ResponseEntity<Void> eliminaAutore (@PathVariable Integer id) {
        autoreService.cancellaAutoredaId(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/elimina-genere/{id}")
    public ResponseEntity<Void> eliminaGenere (@PathVariable Integer id) {
        genereService.cancellaGenere(id);
        return ResponseEntity.noContent().build();
    }

    //CRUD Patch
    @PatchMapping("/aggiorna-fumetto/{id}/{volume}")
    public ResponseEntity<FumettoDTO> cambiaVolumiFumetto (@PathVariable Integer id, @PathVariable Integer volumi){
        try {
            FumettoDTO fumetto = fumettoService.cercaFumettoId(id);
            fumetto.setVolume(volumi);
            return new ResponseEntity<FumettoDTO>(fumettoService.aggiornaFumetto(fumetto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/aggiorna-autore/{id}/{vivo}")
    public ResponseEntity<AutoreDTO> cambiaVivoAutore (@PathVariable Integer id, @PathVariable Boolean vivo){
        try {
            AutoreDTO autore = autoreService.cercaAutoreId(id);
            autore.setVivo(vivo);
            return new ResponseEntity<AutoreDTO>(autoreService.aggiornaAutore(autore), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
