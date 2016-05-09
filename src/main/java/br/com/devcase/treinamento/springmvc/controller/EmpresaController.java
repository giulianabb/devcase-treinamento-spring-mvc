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

import br.com.devcase.treinamento.springmvc.dao.EmpresaDAO;
import br.com.devcase.treinamento.springmvc.domain.Empresa;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {
	EmpresaDAO empresaDAO = new EmpresaDAO();
	
	
	@RequestMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		Empresa empresa = empresaDAO.findById(id);
		model.addAttribute(empresa);
		
		return "/WEB-INF/jsp/empresa/view.jsp";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Empresa empresa = empresaDAO.findById(id);
		model.addAttribute(empresa);	
		
		return "/WEB-INF/jsp/empresa/edit.jsp";
	}
	
	
	@RequestMapping("/create")
	public String create(){
		return "/WEB-INF/jsp/empresa/edit.jsp";
	}
	
	@RequestMapping("/save/")
	public String save(Empresa empresa) {
		empresa = empresaDAO.save(empresa);
		Long id = empresa.getId();
		return "redirect:/empresa/view/" + id;
	}
	
	@RequestMapping("/save/{id}")
	public String save(@PathVariable Long id, Empresa empresa) {
		empresa.setId(id);
		empresaDAO.update(empresa);
			
		return "redirect:/empresa/view/" + id;
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		//registra bind para parâmetros do tipo Date aceitarem o formato dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

	}
}
