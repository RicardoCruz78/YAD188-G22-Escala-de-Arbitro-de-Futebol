package com.referee.arbitro.resource;

import java.time.Instant;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.referee.arbitro.model.Arbitro;
import com.referee.arbitro.repository.ArbitroRepository;
import com.referee.arbitro.resource.exception.StandardError;
import com.referee.arbitro.service.ArbitroService;

@RestController
@RequestMapping(value = "arbitros")
public class ArbitroResource {
	@Autowired
	private ArbitroRepository arbitroRepo;
	
	@Autowired
	private ArbitroService arbitroService;
	
	@GetMapping
	public List<Arbitro> findAll(){
		List <Arbitro> result = (List<Arbitro>) arbitroRepo.findAll();
		return result;
	}
	
	@GetMapping (value = "/{id}")
	public ResponseEntity <Arbitro>findById(@PathVariable Long id){
		
		Arbitro result =  arbitroService.findById(id);
		return ResponseEntity.ok().body(result);
	}

		

	
	@PostMapping 
	public Arbitro findById(@RequestBody Arbitro arbitro){
		Arbitro result =  arbitroRepo.save(arbitro);
		return result;
	}
	
}
