package com.shop.comicverse.controller;

import com.shop.comicverse.service.VenditaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendite")
public class VenditeController {

    @Autowired
    private VenditaService venditaService;

    //APIREST
    @GetMapping("/totale")
    public Double totale(){
        return venditaService.totale();
    }

    @GetMapping("/numero-ordini")
    public Integer numeroOrdini(){
        return venditaService.numeroOrdini();
    }

    @GetMapping("/importo-medio-ordine")
    public Double importoMedioOrdine(){
        return venditaService.importoMedioOrdine();
    }

    @GetMapping("/numero-articoli-venduti")
    public Integer numeroArticoliVenduti(){
        return venditaService.numeroArticoliVenduti();
    }
}
