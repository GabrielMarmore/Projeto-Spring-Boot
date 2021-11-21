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

import com.projeto.ProjetoIDS001.model.Cliente;
import com.projeto.ProjetoIDS001.model.ClienteService;

@Controller
@ComponentScan("com.projeto.ProjetoIDS001.model")
public class ClienteController {
	
	@Autowired
	private ApplicationContext context;

	@GetMapping("/cliente")
	public String formCliente(Model model) {
		model.addAttribute("cliente",new Cliente());
		return "formcliente";
	}
	
	@PostMapping("/cliente")
	public String postCliente(@ModelAttribute Cliente cli,
			Model model) {
		ClienteService cs = context.getBean(ClienteService.class);
				cs.inserirCliente(cli);
		        return "sucesso";
	}
	
	@GetMapping("/perfil/{id}")
	public String getPerfil(@PathVariable("id") int id, 
			Model model) {
		ClienteService cs = context.getBean(ClienteService.class);
		Map<String, Object> mapa = cs.getCliente(id);
		model.addAttribute("nome", mapa.get("nome"));
		model.addAttribute("cpf", mapa.get("cpf"));
		model.addAttribute("id", id);
		return "perfil";
		
	}
	
	@GetMapping("/clientes")
	public String listar(Model model) {
		ClienteService cdao = context.getBean(ClienteService.class);
	    List<Map<String, Object>> clientes = cdao.getClientes();
	    model.addAttribute("clientes", clientes);
		return "formlista";
	}
	
}
