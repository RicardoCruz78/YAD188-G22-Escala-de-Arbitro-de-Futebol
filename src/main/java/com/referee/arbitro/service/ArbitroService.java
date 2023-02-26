package com.referee.arbitro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.referee.arbitro.model.Arbitro;
import com.referee.arbitro.repository.ArbitroRepository;

@Service
public class ArbitroService {
	@Autowired
	private ArbitroRepository arb;

	// Listar todos os arbitros

	public List<Arbitro> getAllArbitros() {
		List<Arbitro> list = (List<Arbitro>) arb.findAll();
		return list;
	}

	// Buscar todos os arbitros por id

	public Optional<Arbitro> getById(Long id) {
		return arb.findById(id);
	}

	public List<Arbitro> getByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return arb.findByKeyword(keyword);
	}

}
