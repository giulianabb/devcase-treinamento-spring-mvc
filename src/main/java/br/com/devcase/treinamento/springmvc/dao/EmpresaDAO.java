package br.com.devcase.treinamento.springmvc.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import br.com.devcase.treinamento.springmvc.domain.Empresa;

@Repository
public class EmpresaDAO {
	
	public Empresa findById(Long id) {
		Empresa empresa = new Empresa();
		empresa.setNome("Padaria do Manuel");
		empresa.setDataDeCriacao(new Date());
		empresa.setId(id);
		
		return empresa;		
	}
	
	public Empresa save(Empresa empresa) {
		empresa.setId(5L);
		
		return empresa;		
	}
	
	public Empresa update(Empresa empresa) {
		return empresa;
	}
}
