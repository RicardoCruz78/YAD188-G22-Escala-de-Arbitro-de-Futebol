package com.referee.arbitro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "escala")

public class Escala implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(nullable = false, name = "arbitro")
	private User arbitro;

	// @Type(type="true_false")
	@JoinColumn(nullable = true, name = "id_Confirmação")
	private String ativo;

	@ManyToOne
	@JoinColumn(nullable = false, name = "assistente1")
	private User arbitro1;

	@JoinColumn(nullable = true, name = "id_Confirmação1")
	private String ativo1;

	@ManyToOne
	@JoinColumn(nullable = false, name = "assistente2")
	private User arbitro2;

	@JoinColumn(nullable = false, name = "id_Confirmação2")
	private String ativo2;

	@ManyToOne
	@JoinColumn(nullable = false, name = "quarto_arbitro")
	private User quartoArbitro;

	@JoinColumn(nullable = true, name = "id_Confirmação3")
	private String ativo3;
	
	@Column(length = 70, nullable = true)
	private String categoria;

	@Column(length = 70, nullable = true)
	private String timeMandante;

	@Column(length = 70, nullable = true)
	private String timeVisitante;

	
	@Column(length = 15, nullable = true)
	private String data;

	@Column(length = 70, nullable = true)
	private String endereco;

	@Column(length = 90, nullable = true)
	private String nomeEstadio;

	@Column(length = 70, nullable = true)
	private String horario;

	@Column(length = 70, nullable = true)
	private String cidade;

	@Column(length = 70, nullable = true)
	private String estado;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}