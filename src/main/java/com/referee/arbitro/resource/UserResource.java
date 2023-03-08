package com.referee.arbitro.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.referee.arbitro.model.User;
import com.referee.arbitro.repository.UserRepository;

@RestController
@RequestMapping(value = "users")
public class UserResource {
	@Autowired
	private UserRepository userRepo;
	@GetMapping
	public List<User> findAll(){
		List <User> result = (List<User>) userRepo.findAll();
		return result;
	}
	
	@GetMapping (value = "/{id}")
	public User findById(@PathVariable Long id){
		User result =  userRepo.findById(id).get();
		return result;
	}
	
	
	@PostMapping 
	public User findById(@RequestBody User user){
		User result =  userRepo.save(user);
		return result;
	}
	
}
