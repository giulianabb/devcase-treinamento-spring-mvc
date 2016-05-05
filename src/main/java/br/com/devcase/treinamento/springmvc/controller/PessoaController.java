package br.com.devcase.treinamento.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.devcase.treinamento.springmvc.dao.PessoaDAO;
import br.com.devcase.treinamento.springmvc.domain.Pessoa;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	private PessoaDAO pessoaDAO = new PessoaDAO();
	

	@RequestMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		Pessoa pessoa = pessoaDAO.findById(id);
		model.addAttribute("pessoa", pessoa);
		
		return "/WEB-INF/jsp/pessoa/view.jsp";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Pessoa pessoa = pessoaDAO.findById(id);
		model.addAttribute("pessoa", pessoa);

		return "/WEB-INF/jsp/pessoa/edit.jsp";
	}
	
	@RequestMapping("/create")
	public String create() {
		return "/WEB-INF/jsp/pessoa/edit.jsp";
	}

	/**
	 * Salva uma pessoa nova
	 * @param nome
	 * @param idade
	 * @return
	 */
	@RequestMapping("/save/")
	public String save(Pessoa pessoa) {
		pessoa = pessoaDAO.save(pessoa);
		return "redirect:/pessoa/view/" + pessoa.getId();
	}
	
	/**
	 * Atualiza uma pessoa
	 * @param id
	 * @param nome
	 * @param idade
	 * @return
	 */
	@RequestMapping("/save/{id}")
	public String save(@PathVariable Long id, Pessoa pessoa) {
		pessoa.setId(id);
		pessoaDAO.update(pessoa);
		return "redirect:/pessoa/view/" + id;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		//registra bind para parâmetros do tipo Date aceitarem o formato dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

	}
}
