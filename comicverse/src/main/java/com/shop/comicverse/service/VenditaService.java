package com.shop.comicverse.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.comicverse.dto.VenditaDTO;
import com.shop.comicverse.entity.Vendita;
import com.shop.comicverse.mapper.VenditaMapping;
import com.shop.comicverse.repository.VenditaRepository;

@Service
public class VenditaService {

	private final VenditaRepository venditaRepository;
	private final VenditaMapping venditaMapping;

	@Autowired
	public VenditaService(VenditaRepository venditaRepository, VenditaMapping venditaMapping) {
		this.venditaRepository = venditaRepository;
		this.venditaMapping = venditaMapping;
	}

	public VenditaDTO trovaVenditaPerId(Long id) {
		Optional<Vendita> venditaOptional = venditaRepository.findById(id);
		Vendita vendita = venditaOptional.orElseThrow(() -> new RuntimeException("Vendita non trovato"));
		return venditaMapping.convertiVenditaInDTO(vendita);
	}

	public VenditaDTO salvaVendita(VenditaDTO venditaDTO) {
		Vendita vendita = venditaMapping.convertiDTOInVendita(venditaDTO);
		vendita.setDataOrdine(new Date());
		Vendita savedVendita = venditaRepository.save(vendita);
		return venditaMapping.convertiVenditaInDTO(savedVendita);
	}

	public VenditaDTO aggiornaVendita(VenditaDTO venditaDTO) {
		Vendita venditaToUpdate = venditaMapping.convertiDTOInVendita(venditaDTO);
		if (venditaToUpdate.getIdVendita() > 0 && venditaRepository.existsById((long) venditaToUpdate.getIdVendita())) {
			Vendita updatedVendita = venditaRepository.save(venditaToUpdate);
			return venditaMapping.convertiVenditaInDTO(updatedVendita);
		} else {
			throw new RuntimeException("Vendita non trovata per l'aggiornamento");
		}
	}

	public void eliminaVenditaPerId(Long id) {
		venditaRepository.deleteById(id);
	}

	public List<VenditaDTO> trovaTutteVendite() {
		List<Vendita> vendite = venditaRepository.findAll();
		return vendite.stream().map(venditaMapping::convertiVenditaInDTO).collect(Collectors.toList());
	}
}