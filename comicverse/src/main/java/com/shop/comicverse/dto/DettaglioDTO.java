package com.shop.comicverse.dto;

import com.shop.comicverse.entity.Inventario;
import lombok.Data;

@Data
public class DettaglioDTO {
    private Integer idDettaglio;
    private Inventario articolo;
    private int quantita;
}
