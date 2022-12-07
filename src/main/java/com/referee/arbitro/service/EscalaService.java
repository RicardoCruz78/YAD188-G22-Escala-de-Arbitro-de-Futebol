package com.referee.arbitro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.referee.arbitro.model.Escala;
import com.referee.arbitro.repository.EscalaRepository;

@Service
public class EscalaService {
	@Autowired
	private EscalaRepository escalaRepo;

	// Listar todas as escalas

	public List<Escala> getAllEscalas() {
		List<Escala> list = (List<Escala>) escalaRepo.findAll();
		return list;
	}

	// Buscar todas os escalas por id

	public Optional<Escala> getById(Long id) {
		return escalaRepo.findById(id);
	}

	public List<Escala> getByKeyword(String keyword) {
		return escalaRepo.findByKeyword(keyword);
	}

}