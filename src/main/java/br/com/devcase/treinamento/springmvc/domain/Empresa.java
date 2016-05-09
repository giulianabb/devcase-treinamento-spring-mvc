package br.com.devcase.treinamento.springmvc.domain;

import java.util.Date;

public class Empresa {
	private Long id;
	private String nome;
	private Date dataDeCriacao;
	private Long funcionarios;
	
	public Long getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(Long funcionarios) {
		this.funcionarios = funcionarios;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataDeCriacao() {
		return dataDeCriacao;
	}
	public void setDataDeCriacao(Date dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}
	
	
}
