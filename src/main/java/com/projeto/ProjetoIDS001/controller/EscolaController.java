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

import com.projeto.ProjetoIDS001.model.Escola;
import com.projeto.ProjetoIDS001.model.EscolaService;

@Controller
@ComponentScan("com.projeto.ProjetoIDS001.model")
public class EscolaController {
	
	@Autowired
	private ApplicationContext context;

	@GetMapping("/escola")
	public String formEscola(Model model) {
		model.addAttribute("escola",new Escola());
		return "formescola";
	}
	
	@PostMapping("/escola")
	public String postEscola(@ModelAttribute Escola cli,
			Model model) {
		EscolaService cs = context.getBean(EscolaService.class);
				cs.inserirEscola(cli);
		        return "sucesso";
	}
	
	@GetMapping("/perfilescola/{id}")
	public String getPerfil(@PathVariable("id") int id, 
			Model model) {
		EscolaService cs = context.getBean(EscolaService.class);
		Map<String, Object> mapa = cs.getEscola(id);
		model.addAttribute("nome", mapa.get("nome"));
		model.addAttribute("codigo", mapa.get("codigo"));
		model.addAttribute("id", id);
		return "perfil";
		
	}
	
	@GetMapping("/escolas")
	public String listar(Model model) {
		EscolaService cdao = context.getBean(EscolaService.class);
	    List<Map<String, Object>> escolas = cdao.getEscolas();
	    model.addAttribute("escolas", escolas);
		return "formlistaescola";
	}
	
}