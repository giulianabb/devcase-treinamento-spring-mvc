package br.com.devcase.treinamento.springmvc.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import br.com.devcase.treinamento.springmvc.domain.Pessoa;

@Repository
public class PessoaDAO {
	public Pessoa findById(Long id) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("João");
		pessoa.setDataNascimento(new Date(System.currentTimeMillis() - 1000*60*60*24*300));
		return pessoa;
	}
	
	public Pessoa save(Pessoa pessoa) {
		pessoa.setId(143L);
		return pessoa;
	}
	
	public Pessoa update(Pessoa pessoa) {
		return pessoa;
	}

}
