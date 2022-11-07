package com.referee.arbitro.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.referee.arbitro.model.Role;
import com.referee.arbitro.model.User;
import com.referee.arbitro.repository.UserRepository;
import com.referee.arbitro.web.UserRegistrationController;
import com.referee.arbitro.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    } 
// aqui
  
	@Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getNome(),registrationDto.getEmail(),registrationDto.getTelefoneCelular(),  passwordEncoder.encode(registrationDto.getPassword()), 
                Arrays.asList(new Role("ROLE_USER"))); 

        return userRepository.save(user); 

    }
    //olhar aqui
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }


    @Autowired
    private UserRepository userRepo;

    // Listar todos os user

    public List<User> getAllUsers() {
        List<User> list = (List<User>) userRepo.findAll();
        return list;
    }

    // Buscar todos os user por id

    public Optional<User> getById(Long id) {

        return userRepo.findById(id);
    }
    
    @Override
    public User getByEmail(String email) {
    	return userRepo.findByEmail(email);
    }


    public User getUserLogged() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      //  auth.getPrincipal().
        Long id = ((Role) auth).getId();

        return userRepo.findById(id).get();
    }

    @SuppressWarnings("unlikely-arg-type")
	public Boolean userLoggedContainAuthority(String authority) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getAuthorities().contains(authority);
    }

	@Override
	public User save(UserRegistrationController registrationDto) {
		// TODO Auto-generated method stub
		return null;
	}
}