package com.projeto.ProjetoIDS001.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {
	

@GetMapping("/")
public String principal() {
	return "index";
	}

@GetMapping("/error")
public String erro() {
	return "erro";
	}
}



