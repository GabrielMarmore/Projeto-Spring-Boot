package com.projeto.ProjetoIDS001.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
	
	@Autowired
	FuncionarioDAO cdao;
	
	public void inserirFuncionario(Funcionario c) {
		cdao.inserirFuncionario(c);
	}
	
	public Map<String, Object> getFuncionario(int id) {
		return cdao.getFuncionario(id);
	}
	
	public List<Map<String, Object>> getFuncionarios(){
		return cdao.getFuncionarios();
	}
}