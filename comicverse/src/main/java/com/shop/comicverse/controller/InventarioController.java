package com.shop.comicverse.controller;

import com.shop.comicverse.dto.DettaglioDTO;
import com.shop.comicverse.dto.InventarioDTO;
import com.shop.comicverse.dto.VenditaDTO;
import com.shop.comicverse.entity.Autore;
import com.shop.comicverse.entity.Fumetto;
import com.shop.comicverse.entity.Inventario;
import com.shop.comicverse.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;
    @Autowired
    private VenditaService venditaService;
    @Autowired
    private DettaglioService dettaglioService;
    @Autowired
    private FumettoService fumettoService;
    @Autowired
    private AutoreService autoreService;

    //CRUD Create
    @PostMapping("/crea-articolo")
    public ResponseEntity<InventarioDTO> creaInventario (@RequestBody InventarioDTO inventarioDTO){
        try {
            InventarioDTO newInventario = inventarioService.creaInventario(inventarioDTO);
            return new ResponseEntity<>(newInventario, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crea-vendita")
    public ResponseEntity<VenditaDTO> creaVendita (@RequestBody VenditaDTO venditaDTO){
        try {
            VenditaDTO newVendita = venditaService.creaVendita(venditaDTO);
            return new ResponseEntity<>(newVendita, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crea-dettaglio")
    public ResponseEntity<DettaglioDTO> creaDettaglio (@RequestBody DettaglioDTO dettaglioDTO){
        try {
            DettaglioDTO newDettaglio = dettaglioService.creaDettaglio(dettaglioDTO);
            return new ResponseEntity<>(newDettaglio, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //CRUD Read
    @GetMapping("/cerca-id-articolo/{id}")
    public ResponseEntity<InventarioDTO> cercaIdInventario (@PathVariable Integer id){
        try {
            InventarioDTO findInventario = inventarioService.cercaInventarioId(id);
            return ResponseEntity.ok(findInventario);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cerca-id-vendita/{id}")
    public ResponseEntity<VenditaDTO> cercaIdVendita (@PathVariable Integer id){
        try {
            VenditaDTO findVendita = venditaService.cercaVenditaId(id);
            return ResponseEntity.ok(findVendita);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cerca-id-dettaglio/{id}")
    public ResponseEntity<DettaglioDTO> cercaIdDettaglio (@PathVariable Integer id){
        try {
            DettaglioDTO findDettaglio = dettaglioService.cercaDettaglioId(id);
            return ResponseEntity.ok(findDettaglio);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //CRUD Display all
    @GetMapping("/lista-articolo")
    public ResponseEntity<List<InventarioDTO>> listaInventario (){
        try {
            List<InventarioDTO> allInventari = inventarioService.listaInventari();
            return new ResponseEntity<>(allInventari, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/lista-vendita")
    public ResponseEntity<List<VenditaDTO>> listaVendita (){
        try {
            List<VenditaDTO> allVendite = venditaService.listaVendite();
            return new ResponseEntity<>(allVendite, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/lista-dettaglio")
    public ResponseEntity<List<DettaglioDTO>> listaDettaglio (){
        try {
            List<DettaglioDTO> allDettagli = dettaglioService.listaDettagli();
            return new ResponseEntity<>(allDettagli, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //CRUD Update
    @PutMapping("/aggiorna-articolo/{id}")
    public ResponseEntity<InventarioDTO> aggiornaInventario (@RequestBody InventarioDTO inventarioDTO, @PathVariable Integer id) {
        try {
            inventarioDTO.setIdArticolo(id);
            InventarioDTO updatedInventario = inventarioService.aggiornaInventario(inventarioDTO);
            return ResponseEntity.ok(updatedInventario);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/aggiorna-vendita/{id}")
    public ResponseEntity<VenditaDTO> aggiornaVendita (@RequestBody VenditaDTO venditaDTO, @PathVariable Integer id) {
        try {
            venditaDTO.setIdVendita(id);
            VenditaDTO updatedVendita = venditaService.aggiornaVendita(venditaDTO);
            return ResponseEntity.ok(updatedVendita);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/aggiorna-dettaglio/{id}")
    public ResponseEntity<DettaglioDTO> aggiornaDettaglio (@RequestBody DettaglioDTO dettaglioDTO, @PathVariable Integer id) {
        try {
            dettaglioDTO.setIdDettaglio(id);
            DettaglioDTO updatedDettaglio = dettaglioService.aggiornaDettaglio(dettaglioDTO);
            return ResponseEntity.ok(updatedDettaglio);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //CRUD Delete
    @DeleteMapping("/elimina-articolo/{id}")
    public ResponseEntity<Void> eliminaInventario (@PathVariable Integer id) {
        try {
            inventarioService.cancellaInventario(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/elimina-vendita/{id}")
    public ResponseEntity<Void> eliminaVendita (@PathVariable Integer id) {
        try {
            venditaService.cancellaVendita(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/elimina-dettaglio/{id}")
    public ResponseEntity<Void> eliminaDettaglio (@PathVariable Integer id) {
        try {
            dettaglioService.cancellaDettaglio(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //CRUD Patch
    @PatchMapping("/aggiorna-articolo/{id}/{prezzoVendita}")
    public ResponseEntity<InventarioDTO> cambiaPrezzoArticolo (@PathVariable Integer id, @PathVariable BigDecimal prezzoVendita){
        try {
            InventarioDTO inventario = inventarioService.cercaInventarioId(id);
            inventario.setPrezzoVendita(prezzoVendita);
            return new ResponseEntity<InventarioDTO>(inventarioService.aggiornaInventario(inventario), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/aggiorna-dettaglio/{id}/{quantita}")
    public ResponseEntity<DettaglioDTO> cambiaQuantitaDettaglio (@PathVariable Integer id, @PathVariable Integer quantita){
        try {
            DettaglioDTO dettaglio = dettaglioService.cercaDettaglioId(id);
            dettaglio.setQuantita(quantita);
            return new ResponseEntity<DettaglioDTO>(dettaglioService.aggiornaDettaglio(dettaglio), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //APIREST
    @GetMapping("/numero-oggetti")
    public ResponseEntity<Integer> numeroOggetti() {
        try {
            return new ResponseEntity<Integer>(inventarioService.numeroOggetti(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/prezzo-medio-vendita")
    public ResponseEntity<Double> prezzoMedioVendita(){
        try {
            return new ResponseEntity<Double>(inventarioService.prezzoMedioVendita(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fumetti-lettera-specifica")
    public ResponseEntity<List<Object>> fumettiLetteraSpecifica(@RequestParam(name = "inizia-con") String lettera){
        try {
            return new ResponseEntity<List<Object>>(fumettoService.fumettiLetteraSpecifica(lettera), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fumetti-dopo-data")
    public ResponseEntity<List<Object>> fumettiDopoData(@RequestParam(name = "pubblicati-dopo") LocalDate data){
        try {
            return new ResponseEntity<List<Object>>(fumettoService.fumettiDopoData(data), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/autori/vivi")
    public ResponseEntity<List<Autore>> autoriVivi(){
        try {
            return new ResponseEntity<List<Autore>>(autoreService.autoriVivi(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/oggetto-min-quantita")
    public ResponseEntity<Object> oggettoMinQuantita(){
        try {
            return new ResponseEntity<Object>(inventarioService.oggettoMinQuantita(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fumetto-prezzo-massimo")
    public ResponseEntity<Object> fumettoPrezzoMassimo() {
        try {
            return new ResponseEntity<Object>(fumettoService.fumettoPrezzoMassimo(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fumetti-prezzo-specifico")
    public ResponseEntity<List<Object>> fumettiPrezzoSpecifico(@RequestParam(name = "prezzo-min") Double prezzoMin, @RequestParam(name = "prezzo-max") Double prezzoMax) {
        try {
            return new ResponseEntity<List<Object>>(fumettoService.fumettiPrezzoSpecifico(prezzoMin, prezzoMax), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
