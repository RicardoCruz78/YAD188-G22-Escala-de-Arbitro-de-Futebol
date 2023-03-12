package com.referee.arbitro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.referee.arbitro.model.Arbitro;
import com.referee.arbitro.repository.ArbitroRepository;
import com.referee.arbitro.service.ArbitroService;
import com.referee.arbitro.service.UserService;

@Controller
public class ArbitroController {

	@Autowired
	private ArbitroRepository arb; 
	@Autowired
	private UserService userService;
	@Autowired
	private ArbitroService service;

	// ------------------Listar --------------------------------------------

	@GetMapping("/listaArbitro")
	public String listaArbitro(Model model) {

		Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(o);
		com.referee.arbitro.model.User user = userService.getByEmail(((User) o).getUsername());
		List<Arbitro> arbitro = arb.filtrar(user.getId());
		model.addAttribute("arbitro", arbitro);

		return "arbitro/listaArbitro";

	}

	// ------------------Listar todos arbitros
	// --------------------------------------------
/*
	@GetMapping("/listaArbitros")
	public String listaArbitros(Model model) {
		List<Arbitro> arbitro = (List<Arbitro>) arb.findByOrderByIdDesc();

		model.addAttribute("arbitro", arbitro);
		return "arbitro/listaArbitros";

	}
*/
	// ------------------Buscar arbitro --------------------
	@RequestMapping(path = { "/listaArbitro" })
	public String listarTodos(Arbitro arbitro, Model model, Long id) {
		if (id != null) {
			Optional<Arbitro> list = service.getById(id);
			model.addAttribute("list", list);

		} else {
			List<Arbitro> list = service.getAllArbitros();
			model.addAttribute("list", list);
		}
		return "arbitro/listaArbitro";
	}

	/*
	 * // ------------------Buscar arbitrosssss --------------------
	 * 
	 * @RequestMapping(path = { "/listaArbitros" }) public String
	 * listarTodoss(Arbitro arbitro, Model model, Long id) { if (id != null) {
	 * Optional<Arbitro> list = service.getById(id); model.addAttribute("list",
	 * list);
	 * 
	 * } else { List<Arbitro> list = service.getAllArbitros();
	 * model.addAttribute("list", list); } return "arbitro/listaArbitros"; }
	 * 
	 */
	// ------------------Buscar Id do arbitro --------------------
	@RequestMapping(path = { "/listaArbitros" })
	public String buscarDisponibilidde(Arbitro arbitro, Model model, String keyword, Long id) {
		if (keyword != null) {
			List<Arbitro> list = service.getByKeyword(keyword);
			model.addAttribute("list", list);
		} else {
			List<Arbitro> list = service.getAllArbitros();
			model.addAttribute("list", list);
		}
		return "arbitro/listaArbitros";
	}

//===================Tela do formulario cadastrar=====================================================================
	@GetMapping("arbitro/novoArbitro")
	public String novoArbitro() {
		return "arbitro/novoArbitro";
	}
	// ============================Cadastrando===========================================================

	@PostMapping("/arbitro/criar")
	public String criar(Arbitro arbitro) {
		arb.save(arbitro);
		return "redirect:/listaArbitro";
	}

	// ============================Buscando arbitro pelo id=================

	@GetMapping("/arbitro/{id}")
	public String busca(@PathVariable Long id, Model model) {
		Optional<Arbitro> arbi = arb.findById(id);
		try {
			model.addAttribute("arbitro", arbi.get());

		} catch (Exception er) {
			return "redirect:arbitro/editar/";
		}
		return "arbitro/editar";
	}

	// ===============================Atualizando
	// --------------------------------------

	@PostMapping("/arbitro/{id}/atualizar")
	public String atualizar(@PathVariable Long id, Arbitro arbitro) {

		if (!arb.existsById(id)) {
			return "redirect:/listaArbitro";
		}

		arb.save(arbitro);
		return "redirect:/listaArbitro";

	}

	@GetMapping("/arbitro/{id}/excluir")
	public String excluir(@PathVariable Long id) {

		arb.deleteById(id);
		return "redirect:/listaArbitro";
	}

}
