package com.shop.comicverse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.comicverse.entity.Fumetto;
import com.shop.comicverse.repository.FumettoRepository;

@Service
public class FumettoService {

	@Autowired
	private FumettoRepository fumettoRepository;
	
	public void creaFumetto(Fumetto fumetto) {
		fumettoRepository.save(fumetto);
	}
}
