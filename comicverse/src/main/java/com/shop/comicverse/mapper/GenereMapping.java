package com.shop.comicverse.mapper;

import org.springframework.stereotype.Component;

import com.shop.comicverse.dto.GenereDTO;
import com.shop.comicverse.entity.Genere;

@Component
public class GenereMapping {


		public GenereDTO convertiGenereInDTO(Genere genere) {
			GenereDTO dto = new GenereDTO();
			dto.setIdGenere(genere.getIdGenere());
			dto.setNome(genere.getNome());
			return dto;
		}

		public Genere convertiDTOInGenere(GenereDTO generedto) {
			Genere genere = new Genere();
			genere.setIdGenere(generedto.getIdGenere());
			genere.setNome(generedto.getNome());
			return genere;
		}

	}


