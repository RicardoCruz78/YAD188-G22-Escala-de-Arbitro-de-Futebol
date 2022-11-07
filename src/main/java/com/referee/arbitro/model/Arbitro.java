package com.referee.arbitro.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "arbitro", uniqueConstraints = @UniqueConstraint(columnNames = "cpf"))
public class Arbitro implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(nullable = false, name = "id_login")
	private User user;

	@Column(length = 14, nullable = true)
	private String cpf;

	@Column(length = 17, nullable = true)
	private String telefoneResidencial;

	@Column(length = 10, nullable = true)
	private String dataNascimento;

	@Column(length = 17, nullable = true)
	private String rg;

	@Column(length = 110, nullable = true)
	private String endereco;

	@Column(length = 14, nullable = true)
	private String cep;

	@Column(length = 50, nullable = true)
	private String cidadeNascimento;

	@Column(length = 50, nullable = true)
	private String escolaridade;

	@Column(length = 50, nullable = true)
	private String estado;

	@Column(length = 4, nullable = true)
	private int AnoFormacaoArbitro;

	@Column(length = 50, nullable = true)
	private String estadoCivil;

	@Column(length = 4, nullable = true)
	private double peso;

	@Column(length = 4, nullable = true)
	private double altura;

	@Column(length = 50, nullable = true)
	private String funcao;

	@Column(length = 70, nullable = true)
	private String pix;

	@Column(name = "disponibilidade", nullable = false)
	private String disponibilidade;

}
