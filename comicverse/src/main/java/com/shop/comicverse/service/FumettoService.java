package com.shop.comicverse.service;

import com.shop.comicverse.dto.FumettoDTO;
import com.shop.comicverse.mapping.FumettoMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.comicverse.entity.Fumetto;
import com.shop.comicverse.repository.FumettoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FumettoService {

	@Autowired
	private FumettoRepository fumettoRepository;
	@Autowired
	private FumettoMapping fumettoMapping;

	public FumettoDTO creaFumetto(FumettoDTO fumettoDTO) {
		Fumetto fumetto = fumettoMapping.convertiDTOinFumetto(fumettoDTO);
		Fumetto newFumetto = fumettoRepository.save(fumetto);
		return fumettoMapping.convertiFumettoinDTO(newFumetto);
	}

	public FumettoDTO cercaFumettoId(Integer id) {
		Optional<Fumetto> fumettoOpt = fumettoRepository.findById(id);
		Fumetto fumetto = fumettoOpt.orElseThrow(() -> new RuntimeException(String.format("Id Fumetto %d non trovato", id)));
		return fumettoMapping.convertiFumettoinDTO(fumetto);
	}

	public List<FumettoDTO> listaFumetti() {
		List<Fumetto> fumetti = fumettoRepository.findAll();
		return fumetti.stream().map(fumettoMapping::convertiFumettoinDTO)
				.collect(Collectors.toList());
	}

	public void cancellaFumetto(Integer id){
		fumettoRepository.deleteById(id);
	}

	public FumettoDTO aggiornaFumetto (FumettoDTO fumettoDTO){
		try {
			cercaFumettoId(fumettoDTO.getIdFumetto());
			Fumetto fumettoUp = fumettoMapping.convertiDTOinFumetto(fumettoDTO);
			Fumetto upFumetto = fumettoRepository.save(fumettoUp);
			return fumettoMapping.convertiFumettoinDTO(upFumetto);
		} catch (Exception e){
			throw new RuntimeException("Aggiornamento fallito");
		}
	}

	public List<Fumetto> fumettiLetteraSpecifica(String lettera) {
		List<Fumetto> listainizialeFumetto = fumettoRepository.fumettiLetteraSpecifica(lettera);
		return listainizialeFumetto;
	}

	public List<Fumetto> fumettiDopoData(LocalDate data) {
		List<Fumetto> listainizialeFumetto = fumettoRepository.fumettiDopoData(data);
		return listainizialeFumetto;
	}

	public Fumetto fumettoPrezzoMassimo() {
		Fumetto fumettoMassimo = fumettoRepository.fumettoPrezzoMassimo();
		return fumettoMassimo;
	}

	public List<Fumetto> fumettiPrezzoSpecifico(Double prezzoMin, Double prezzoMax) {
		List<Fumetto> fumettiRange = fumettoRepository.fumettiPrezzoSpecifico(prezzoMin, prezzoMax);
		return fumettiRange;
	}

}
