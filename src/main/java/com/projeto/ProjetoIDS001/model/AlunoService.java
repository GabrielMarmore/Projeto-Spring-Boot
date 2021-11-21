package com.projeto.ProjetoIDS001.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
	
	@Autowired
	AlunoDAO cdao;
	
	public void inserirAluno(Aluno c) {
		cdao.inserirAluno(c);
	}
	
	public Map<String, Object> getAluno(int id) {
		return cdao.getAluno(id);
	}
	
	public List<Map<String, Object>> getAlunos(){
		return cdao.getAlunos();
	}
}