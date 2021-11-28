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
		model.addAttribute("colegio", mapa.get("colegio"));
		model.addAttribute("email", mapa.get("email"));
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
	
	@PostMapping("/apagar/professor/{id}")
	public String apagarProfessor(@PathVariable("id") int id) {
		ProfessorService cdao = context.getBean(ProfessorService.class);
		cdao.deleteProfessor(id);
		return "redirect:/professores";
	}
	
	@GetMapping("/updprof/{id}")
	public String formAtualizar(@PathVariable("id") int id, Model model) {
		ProfessorService cdao = context.getBean(ProfessorService.class);
		Map<String,Object> regs = cdao.getProfessor(id);
		Professor cli = new Professor(id,regs.get("nome").toString(),regs.get("cpf").toString(),regs.get("colegio").toString(),regs.get("email").toString());
		model.addAttribute("professor",cli);
		model.addAttribute("id",id);
		return "formupdprofessor";
	}
	
	@PostMapping("/updprof/{id}")
	public String atualizarProfessor(@PathVariable("id") int id, 
			                       Model model,
			                       @ModelAttribute Professor cli) {
		ProfessorService cdao = context.getBean(ProfessorService.class);
		cdao.atualizarProfessor(id, cli);
		return "redirect:/professores";
	}
	
}

	
