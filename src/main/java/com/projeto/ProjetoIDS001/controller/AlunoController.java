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

import com.projeto.ProjetoIDS001.model.Aluno;
import com.projeto.ProjetoIDS001.model.AlunoService;

@Controller
@ComponentScan("com.projeto.ProjetoIDS001.model")
public class AlunoController {
	
	@Autowired
	private ApplicationContext context;

	@GetMapping("/aluno")
	public String formAluno(Model model) {
		model.addAttribute("aluno",new Aluno());
		return "formaluno";
	}
	
	@PostMapping("/aluno")
	public String postAluno(@ModelAttribute Aluno cli,
			Model model) {
		AlunoService cs = context.getBean(AlunoService.class);
				cs.inserirAluno(cli);
		        return "sucesso";
	}
	
	@GetMapping("/perfil/{id}")
	public String getPerfil(@PathVariable("id") int id, 
			Model model) {
		AlunoService cs = context.getBean(AlunoService.class);
		Map<String, Object> mapa = cs.getAluno(id);
		model.addAttribute("nome", mapa.get("nome"));
		model.addAttribute("cpf", mapa.get("cpf"));
		model.addAttribute("id", id);
		return "perfil";
		
	}
	
	@GetMapping("/alunos")
	public String listar(Model model) {
		AlunoService cdao = context.getBean(AlunoService.class);
	    List<Map<String, Object>> alunos = cdao.getAlunos();
	    model.addAttribute("alunos", alunos);
		return "formlista";
	}
	
}
