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
import com.projeto.ProjetoIDS001.model.Funcionario;
import com.projeto.ProjetoIDS001.model.FuncionarioService;

@Controller
@ComponentScan("com.projeto.ProjetoIDS001.model")
public class FuncionarioController {
	
	@Autowired
	private ApplicationContext context;

	@GetMapping("/funcionario")
	public String formFuncionario(Model model) {
		model.addAttribute("funcionario",new Funcionario());
		return "formfuncionario";
	}
	
	@PostMapping("/funcionario")
	public String postFuncionario(@ModelAttribute Funcionario cli,
			Model model) {
		FuncionarioService cs = context.getBean(FuncionarioService.class);
				cs.inserirFuncionario(cli);
		        return "sucesso";
	}
	
	@GetMapping("/perfilfunc/{id}")
	public String getPerfil(@PathVariable("id") int id, 
			Model model) {
		FuncionarioService cs = context.getBean(FuncionarioService.class);
		Map<String, Object> mapa = cs.getFuncionario(id);
		model.addAttribute("nome", mapa.get("nome"));
		model.addAttribute("cpf", mapa.get("cpf"));
		model.addAttribute("colegio", mapa.get("colegio"));
		model.addAttribute("id", id);
		return "perfil";
		
	}
	
	@GetMapping("/funcionarios")
	public String listar(Model model) {
		FuncionarioService cdao = context.getBean(FuncionarioService.class);
	    List<Map<String, Object>> funcionarios = cdao.getFuncionarios();
	    model.addAttribute("funcionarios", funcionarios);
		return "formlistafunc";
	}
	
	@PostMapping("/apagar/funcionario/{id}")
	public String apagarFuncionario(@PathVariable("id") int id) {
		FuncionarioService cdao = context.getBean(FuncionarioService.class);
		cdao.deleteFuncionario(id);
		return "redirect:/funcionarios";
	}
	
	@GetMapping("/updfunc/{id}")
	public String formAtualizar(@PathVariable("id") int id, Model model) {
		FuncionarioService cdao = context.getBean(FuncionarioService.class);
		Map<String,Object> regs = cdao.getFuncionario(id);
		Funcionario cli = new Funcionario(id,regs.get("nome").toString(),regs.get("cpf").toString(),regs.get("colegio").toString());
		model.addAttribute("funcionario",cli);
		model.addAttribute("id",id);
		return "formupdfuncionario";
	}
	
	@PostMapping("/updfunc/{id}")
	public String atualizarFuncionario(@PathVariable("id") int id, 
			                       Model model,
			                       @ModelAttribute Funcionario cli) {
		FuncionarioService cdao = context.getBean(FuncionarioService.class);
		cdao.atualizarFuncionario(id, cli);
		return "redirect:/funcionarios";
	}
	
}

	

