package br.com.devcase.treinamento.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	/**
	 * Visualiza os dados da pessoa de acordo com o id
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model) throws Exception {
		Pessoa pessoa = pessoaDAO.findById(id);
		model.addAttribute("pessoa", pessoa);
		
		return "/WEB-INF/jsp/pessoa/view.jsp";
	}
	
	/**
	 * Edita os dados da pessoa de acordo com o id
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) throws Exception {
		Pessoa pessoa = pessoaDAO.findById(id);
		model.addAttribute("pessoa", pessoa);

		return "/WEB-INF/jsp/pessoa/edit.jsp";
	}
	
	/**
	 * Cria uma nova pessoa no sistema
	 * @return
	 */
	@RequestMapping("/create")
	public String create() {
		return "/WEB-INF/jsp/pessoa/edit.jsp";
	}

	/**
	 * Salva uma pessoa nova
	 * @param nome
	 * @param idade
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save/")
	public String save(Pessoa pessoa) throws Exception {
		pessoa = pessoaDAO.save(pessoa);
		return "redirect:/pessoa/view/" + pessoa.getId();
	}
	
	/**
	 * Atualiza uma pessoa
	 * @param id
	 * @param nome
	 * @param idade
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save/{id}")
	public String save(@PathVariable Long id, Pessoa pessoa) throws Exception {
		pessoa.setId(id);
		pessoaDAO.update(pessoa);
		return "redirect:/pessoa/view/" + id;
	}
	
	@RequestMapping("/list")
	public String list(Model model) throws Exception {
		model.addAttribute("list", pessoaDAO.findAll());
		model.addAttribute("find", false);
		
		return "/WEB-INF/jsp/pessoa/list.jsp";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id) throws Exception {
		pessoaDAO.delete(id);		
		return "redirect:/pessoa/list/";
	}
	
	@RequestMapping("/filter")
	public String find() {
		return "/WEB-INF/jsp/pessoa/find.jsp";
	}
	
	@RequestMapping("/find/name/")
	public String findName(Model model, String nome) throws Exception {
		model.addAttribute("list", pessoaDAO.findName(nome));
		model.addAttribute("find", true);
		return "/WEB-INF/jsp/pessoa/list.jsp";
	}
	
	@RequestMapping("/find/address/")
	public String findAddress(Model model, String endereco) throws Exception {
		model.addAttribute("list", pessoaDAO.findAddress(endereco));
		model.addAttribute("find", true);
		return "/WEB-INF/jsp/pessoa/list.jsp";
	}
	
	@RequestMapping("/find/birthday/")
	public String findBirthday(Model model, String nascimento) throws Exception {
		model.addAttribute("list", pessoaDAO.findBirthday(nascimento));
		model.addAttribute("find", true);
		return "/WEB-INF/jsp/pessoa/list.jsp";
	}
	

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		//registra bind para parâmetros do tipo Date aceitarem o formato dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

	}
}
