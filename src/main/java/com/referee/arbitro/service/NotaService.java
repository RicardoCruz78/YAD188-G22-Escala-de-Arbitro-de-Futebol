package com.referee.arbitro.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.referee.arbitro.model.Nota;

import com.referee.arbitro.repository.NotaRepository;

@Service
public class NotaService {
	@Autowired
	private NotaRepository notaRepo;

	public List<Nota> getAllNotas() {
		List<Nota> list = (List<Nota>) notaRepo.findAll();
		return list;
	}

	public Optional<Nota> getById(Long id) {

		return notaRepo.findById(id);
	}
}