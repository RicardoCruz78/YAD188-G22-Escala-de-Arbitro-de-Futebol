package com.referee.arbitro.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.referee.arbitro.model.Arbitro;
import com.referee.arbitro.repository.ArbitroRepository;

@RestController
@RequestMapping(value = "arbitros")
public class ArbitroResource {
	@Autowired
	private ArbitroRepository arbitroRepo;
	
	@GetMapping
	public List<Arbitro> findAll(){
		List <Arbitro> result = (List<Arbitro>) arbitroRepo.findAll();
		return result;
	}
	
	@GetMapping (value = "/{id}")
	public Arbitro findById(@PathVariable Long id){
		Arbitro result =  arbitroRepo.findById(id).get();
		return result;
	}
	
	
	@PostMapping 
	public Arbitro findById(@RequestBody Arbitro arbitro){
		Arbitro result =  arbitroRepo.save(arbitro);
		return result;
	}
	
}
