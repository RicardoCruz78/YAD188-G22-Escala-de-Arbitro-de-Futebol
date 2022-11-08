package com.referee.arbitro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "nota")

public class Nota implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "id_escala")
	private Escala escala;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "id_usuario")
	private User user;

	// @Type(type="true_false")
	// @JoinColumn(nullable = false, name = "grau_dificuldade")
	@Column(name = "grau_dificuldade")
	private String dificuldade;

	@Column(name = "controle_emocional")
	private String emocional;

	@Column(name = "uso_som_apito")
	private String som_apito;

	@Column(name = "clareza_comunicacao")
	private String comunicacao;

	@Column(name = "preparo_fisico")
	private String fisico;

	@Column(name = "postura")
	private String postura;

	@Column(name = "observacao")
	private String observacao;

	@Column(name = "nota_arbitro")
	private double nt;
}
