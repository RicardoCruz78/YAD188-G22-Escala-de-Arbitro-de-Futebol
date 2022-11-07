package com.referee.arbitro.web.dto;

public class UserRegistrationDto {
	private String cpf;
	private String nome;
	private String email;
	private String password;
	private String telefoneResidencial;	
	private String telefoneCelular;
	private String dataNascimento;
	private String rg; 
	private String endereco;	
	private String cep;
	private String cidadeNascimento;	
	private String escolaridade;
	private String estado;	
	private String AnoFormacaoArbitro;
	private String estadoCivil;	
	private String peso; 	
	private String altura;	
	private String funcao;
	private String pix;
	public UserRegistrationDto() {
	
}

	public UserRegistrationDto(String cpf,String email, String nome, String password, String telefoneResidencial,
			String telefoneCelular,  String dataNascimento, String rg, String endereco, String cep,
			String cidadeNascimento, String escolaridade, String estado, String anoFormacaoArbitro, String estadoCivil,
			String peso, String altura, String funcao, String pix) {
		super();
		this.cpf = cpf;
		this.email = email;
		this.nome = nome;
		this.password = password;
		this.telefoneResidencial = telefoneResidencial;
		this.telefoneCelular = telefoneCelular;		
		this.dataNascimento = dataNascimento;
		this.rg = rg;
		this.endereco = endereco;
		this.cep = cep;
		this.cidadeNascimento = cidadeNascimento;
		this.escolaridade = escolaridade;
		this.estado = estado;
		AnoFormacaoArbitro = anoFormacaoArbitro;
		this.estadoCivil = estadoCivil;
		this.peso = peso;
		this.altura = altura;
		this.funcao = funcao;
		this.pix = pix;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidadeNascimento() {
		return cidadeNascimento;
	}

	public void setCidadeNascimento(String cidadeNascimento) {
		this.cidadeNascimento = cidadeNascimento;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAnoFormacaoArbitro() {
		return AnoFormacaoArbitro;
	}

	public void setAnoFormacaoArbitro(String anoFormacaoArbitro) {
		AnoFormacaoArbitro = anoFormacaoArbitro;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getPix() {
		return pix;
	}

	public void setPix(String pix) {
		this.pix = pix;
	}
	

}
