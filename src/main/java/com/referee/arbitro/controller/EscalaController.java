package com.referee.arbitro.controller;

import org.springframework.security.core.userdetails.*;
import java.util.List;
import java.util.Optional;

import com.referee.arbitro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.referee.arbitro.model.Escala;

import com.referee.arbitro.repository.EscalaRepository;

import com.referee.arbitro.service.EscalaService;

@Controller
public class EscalaController {
	@Autowired
	private EscalaRepository escalaRepo;

	@Autowired
	private EscalaService service;

	@Autowired
	private UserService userService;

	// --------------Listar escala----------------------//

	@GetMapping("/listaEscala")
	public String listarEscala(Model model) {
		Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(o);
		com.referee.arbitro.model.User user = userService.getByEmail(((User) o).getUsername());
		List<Escala> escala = escalaRepo.filtrar(user.getId());
		model.addAttribute("escala", escala);
		return "escala/listaEscala";

	}

	// --------------Listar escalas----------------------//
	@GetMapping("/listaEscalas")
	public String listaEscalas(Model model) {
		List<Escala> escala = (List<Escala>) escalaRepo.findByOrderByIdDesc();

		model.addAttribute("escala", escala);
		return "escala/listaEscala";

	}

	// ------------------Pesquisar escala --------------------
	@RequestMapping(path = { "/listaEscala" })
	public String pesquisarEscala(Escala escala, Model model, Long id) {
		if (id != null) {
			Optional<Escala> list = service.getById(id);
			model.addAttribute("list", list);

		} else {
			List<Escala> list = service.getAllEscalas();
			model.addAttribute("list", list);
		}
		return "escala/listaEscalas";
	}

	// ------------------Pesquisar escalas --------------------
	@RequestMapping(path = { "/listaEscalas" })
	public String pesquisarEscalas(Escala escala, Model model, String keyword) {
		if (keyword != null) {
			List<Escala> list = service.getByKeyword(keyword);
			model.addAttribute("list", list);

		} else {
			List<Escala> list = service.getAllEscalas();
			model.addAttribute("list", list);
		}
		return "escala/listaEscalas";
	}

	// -------------tela do formulario cadastrar escala -------------//

	@GetMapping("/escala/novaEscala")
	public String novaEscala() {
		return "escala/novaEscala";
	}

	// -----------cadastrando-------------------

	@PostMapping("/escala/criar")
	public String criar(Escala escala) {
		escalaRepo.save(escala);
		return "redirect:/listaEscalas";
	}

	// --------------------buscar escala -----------------------//
	@GetMapping("/escala/{id}")
	public String busca(@PathVariable Long id, Model model) {
		Optional<Escala> escalaa = escalaRepo.findById(id);
		try {
			model.addAttribute("escala", escalaa.get());

		} catch (Exception er) {
			return "redirect:escala/editarEscala";
		}
		return "escala/editarEscala";
	}

	// ------------atualizando ---------------//
	@PostMapping("/escala/{id}/atualizar")
	public String atualizar(@PathVariable("id") Long id, Escala escala) {

		if (!escalaRepo.existsById(id)) {
			return "redirect:/listaEscala";
		}
		escalaRepo.save(escala);
		return "redirect:/listaEscalas";

	}

	// ------------------------excluindo-----------------------//

	@GetMapping("/escala/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		escalaRepo.deleteById(id);
		return "redirect:/listaEscalas";
	}

	// --------------------confirmar escala -----------------------//
	@GetMapping("/confirmar/{id}")
	public String buscar(@PathVariable Long id, Model model) {
		Optional<Escala> escalaa = escalaRepo.findById(id);
		try {
			model.addAttribute("escala", escalaa.get());

		} catch (Exception er) {
			return "redirect:escala/confirmarEscala";
		}
		return "escala/confirmarEscala";
	}

	// ------------atualizando ---------------//
	@PostMapping("/escala/{id}/confirmar")
	public String atualizarr(@PathVariable("id") Long id, Escala escala) {

		if (!escalaRepo.existsById(id)) {
			return "redirect:/listaEscala";
		}
		escalaRepo.save(escala);
		return "redirect:/listaEscala";

	}

}