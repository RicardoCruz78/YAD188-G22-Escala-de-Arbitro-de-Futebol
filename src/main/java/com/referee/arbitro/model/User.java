package com.referee.arbitro.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Id
	private Long id;

	public String nome;
	private String email;
	private String telefoneCelular;
	private String password;
	@Column(name = "reset_password_token")
	private String resetPasswordToken;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))

	private Collection<Role> roles;

	public User(String nome, String email, String telefoneCelular, String password, Collection<Role> roles) {
		super();

		this.nome = nome;
		this.email = email;
		this.telefoneCelular = telefoneCelular;
		this.password = password;

		this.roles = roles;
	}

	public Object getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

}