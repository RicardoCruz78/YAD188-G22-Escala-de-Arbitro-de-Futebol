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
import com.referee.arbitro.model.Nota;
import com.referee.arbitro.repository.NotaRepository;
import com.referee.arbitro.service.NotaService;
import com.referee.arbitro.service.UserService;

@Controller
public class NotaController {

	@Autowired
	private NotaRepository notaRepo;

	@Autowired
	private NotaService service;

	@Autowired
	private UserService userService;
	@SuppressWarnings("unused")
	@Autowired
	private NotaService notaService;

	// -------------tela do formulario cadastrar escala -------------//

	@GetMapping("/nota/novaNota")
	public String novaNota() {
		return "nota/novaNota";
	}

	// -----------cadastrando-------------------

	@PostMapping("/nota/criar")
	public String criarNota(Nota nota) {
		notaRepo.save(nota);
		return "redirect:/listaNotas";
	}

	// ------------------Listar todas Notas
	// --------------------------------------------

	@GetMapping("/listaNotas")
	public String listaNotas(Model model) {
		List<Nota> nota = (List<Nota>) notaRepo.findByOrderByIdDesc();

		model.addAttribute("nota", nota);
		return "nota/listaNotas";

	}

	// --------------Listar nota----------------------//

	@GetMapping("/listaNota")
	public String listaNota(Model model) {

		// System.out.println(user);

		Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		System.out.println(o);

		com.referee.arbitro.model.User user = userService.getByEmail(((User) o).getUsername());

		List<Nota> nota = (List<Nota>) notaRepo.filtrar(user.getId());

		model.addAttribute("nota", nota);

		return "nota/listaNota";

	}

	// ------------------------excluindo-----------------------//

	@GetMapping("/nota/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		notaRepo.deleteById(id);
		return "redirect:/listaNotas";
	}

	// ------------------Buscar notas --------------------
	@RequestMapping(path = { "/listaNotas" })
	public String buscarNotas(Nota nota, Model model, Long id) {
		if (id != null) {
			Optional<Nota> list = service.getById(id);
			model.addAttribute("list", list);

		} else {
			List<Nota> list = service.getAllNotas();
			model.addAttribute("list", list);
		}
		return "nota/listaNotas";
	}

	// ============================Buscando para alterar=================

	@GetMapping("/nota/{id}")
	public String buscaNota(@PathVariable Long id, Model model) {
		Optional<Nota> notaa = notaRepo.findById(id);
		try {
			model.addAttribute("nota", notaa.get());

		} catch (Exception er) {
			return "redirect:nota/editar/";
		}
		return "nota/editarNota";
	}

	// ===============================Atualizando
	// --------------------------------------

	@PostMapping("/nota/{id}/atualizar")
	public String atualizar(@PathVariable Long id, Nota nota) {

		if (!notaRepo.existsById(id)) {
			return "redirect:/listaNota";
		}

		notaRepo.save(nota);
		return "redirect:/listaNota";

	}

	// -------------------------------

	@GetMapping("/visualizar/{id}")
	public String visualizar(@PathVariable Long id, Model model) {
		Optional<Nota> notaa = notaRepo.findById(id);
		try {
			model.addAttribute("nota", notaa.get());

		} catch (Exception er) {
			return "redirect:nota/visualizar";
		}
		return "nota/visualizarNota";
	}

	// ===============================Atualizando
	// --------------------------------------

	@PostMapping("/nota/{id}/visualizar")
	public String visualizarNota(@PathVariable Long id, Nota nota) {

		if (!notaRepo.existsById(id)) {
			return "redirect:/listaVisualizar";
		}

		notaRepo.save(nota);
		return "redirect:/listaVisualizar";

	}

}
