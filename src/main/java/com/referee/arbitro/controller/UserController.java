package com.referee.arbitro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.referee.arbitro.model.User;
import com.referee.arbitro.repository.UserRepository;
import com.referee.arbitro.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserService service;

	// --------------Listar user----------------------//
	@GetMapping("/listaUser")
	public String listaUser(Model model) {
		List<User> user = (List<User>) userRepo.findAll();
		model.addAttribute("user", user);
		return "user/listaUser";

	}

	// ------------------Buscar User por adm --------------------
	@SuppressWarnings("unused")
	@RequestMapping(path = { "/listaUser" })
	public String listarTodos(User user, Model model, String keyword, Long id) {
		if (keyword != null) {
			// Optional<User> list = service.getById(id);
			List<User> list = service.getByKeyword(keyword);
			model.addAttribute("list", list);
			// model.addAttribute("codigo", id);
		} else {
			List<User> list = service.getAllUsers();
			model.addAttribute("list", list);
		}
		return "user/listaUser";
	}

	// ------------------Buscar o Id do usuário digitando o nome
	// --------------------
	@RequestMapping(path = { "/buscarId" })
	public String buscarId(User user, Model model, String keyword, Long id) {
		if (keyword != null) {
			List<User> list = service.getByKeyword(keyword);
			model.addAttribute("list", list);
		} else {
			List<User> list = service.getAllUsers();
			model.addAttribute("list", list);
		}
		return "user/buscarId";
	}

	// ============================Buscando com Validação=================

	@GetMapping("/user/{id}")
	public String busca(@PathVariable Long id, Model model) {
		Optional<User> userr = userRepo.findById(id);
		try {
			model.addAttribute("user", userr.get());

		} catch (Exception er) {
			return "redirect:user/editarLogin/";
		}
		return "user/editarLogin";
	}

	// ===========Atualizando============//

	@PostMapping("/user/{id}/atualizar")
	public String atualizar(@PathVariable("id") Long id, User user) {

		if (!userRepo.existsById(id)) {
			return "redirect:/listaUser";
		}

		userRepo.save(user);
		return "redirect:/listaUser";

	}

	// ------------- excluindo --------------//
	@GetMapping("/user/{id}/excluir")
	public String excluir(@PathVariable Long id) {

		userRepo.deleteById(id);
		return "redirect:/listaUser";
	}

}
