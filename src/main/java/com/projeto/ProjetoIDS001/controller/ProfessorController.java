package com.projeto.ProjetoIDS001.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projeto.ProjetoIDS001.model.Professor;
import com.projeto.ProjetoIDS001.model.ProfessorService;

@Controller
@ComponentScan("com.projeto.ProjetoIDS001.model")
public class ProfessorController {
	
	@Autowired
	private ApplicationContext context;

	@GetMapping("/professor")
	public String formProfessor(Model model) {
		model.addAttribute("professor",new Professor());
		return "formprofessor";
	}
	
	@PostMapping("/professor")
	public String postProfessor(@ModelAttribute Professor cli,
			Model model) {
		ProfessorService cs = context.getBean(ProfessorService.class);
				cs.inserirProfessor(cli);
		        return "sucesso";
	}
	
	@GetMapping("/perfilprof/{id}")
	public String getPerfil(@PathVariable("id") int id, 
			Model model) {
		ProfessorService cs = context.getBean(ProfessorService.class);
		Map<String, Object> mapa = cs.getProfessor(id);
		model.addAttribute("nome", mapa.get("nome"));
		model.addAttribute("cpf", mapa.get("cpf"));
		model.addAttribute("id", id);
		return "perfil";
		
	}
	
	@GetMapping("/professores")
	public String listar(Model model) {
		ProfessorService cdao = context.getBean(ProfessorService.class);
	    List<Map<String, Object>> professores = cdao.getProfessores();
	    model.addAttribute("professores", professores);
		return "formlistaprof";
	}
	
}