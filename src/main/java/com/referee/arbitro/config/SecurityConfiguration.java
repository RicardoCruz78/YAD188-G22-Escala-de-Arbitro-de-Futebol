package com.referee.arbitro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.referee.arbitro.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter { 

	@Autowired
	private UserService userService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable()
		
         .authorizeRequests()
         
         
         
         //.antMatchers(HttpMethod.GET, "/listaUser").hasRole("ADMIN")
        // .antMatchers(HttpMethod.GET, "/registration").hasRole("ADMIN")
        // .antMatchers(HttpMethod.GET, "/listaArbitro").hasRole("ADMIN")      
          .antMatchers(HttpMethod.GET, "/arbitro/{id}/excluir").hasRole("ADMIN")
         // .antMatchers(HttpMethod.POST, "/arbitro/{id}/atualizar").hasRole("ADMIN")
          .antMatchers(HttpMethod.GET, "/escala/novaEscala").hasRole("ADMIN")
          .antMatchers(HttpMethod.GET, "/escala/{id}").hasRole("ADMIN")
          .antMatchers(HttpMethod.GET, "/escala/{id}/excluir").hasRole("ADMIN") 
          .antMatchers(HttpMethod.GET, "/listaNotas").hasRole("ADMIN") 
          
          .antMatchers(HttpMethod.GET, "/escala/listaEscala").hasRole("ADMIN") 
          
          
          
         .anyRequest().authenticated()
         .and()
         .formLogin()
         
        
         .loginPage("/login")
         .loginPage("/registration")
         .permitAll() 
         .and()
         
         .logout()
         .permitAll();
		 
	}
	
}