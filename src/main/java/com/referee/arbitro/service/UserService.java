package com.referee.arbitro.service;


import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.referee.arbitro.model.User;
import com.referee.arbitro.web.UserRegistrationController;
import com.referee.arbitro.web.dto.UserRegistrationDto;


@Service
public interface UserService extends UserDetailsService {
    User save(UserRegistrationController registrationDto);

    Optional<User> getById(Long id);

    List<User> getAllUsers();
    
    User getByEmail(String email);

    User getUserLogged();

    Boolean userLoggedContainAuthority(String authority);

	User save(UserRegistrationDto registrationDto);
}