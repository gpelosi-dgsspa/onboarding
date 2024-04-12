package com.shop.comicverse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.comicverse.entity.Fumetto;
import com.shop.comicverse.repository.FumettoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FumettoService {

	@Autowired
	private FumettoRepository fumettoRepository;
	
	public void creaFumetto(Fumetto fumetto) {
		fumettoRepository.save(fumetto);
	}

	public Optional<Fumetto> cercaFumettoId(Integer id) {
		return fumettoRepository.findById(id);
	}

	public List<Fumetto> listaFumetti() {
		return fumettoRepository.findAll();
	}

	public void cancellaFumetto(Integer id){
		fumettoRepository.deleteById(id);
	}

}
