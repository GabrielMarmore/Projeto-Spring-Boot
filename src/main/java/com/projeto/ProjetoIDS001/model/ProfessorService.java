package com.projeto.ProjetoIDS001.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
	
	@Autowired
	ProfessorDAO cdao;
	
	public void inserirProfessor(Professor c) {
		cdao.inserirProfessor(c);
	}
	
	public Map<String, Object> getProfessor(int id) {
		return cdao.getProfessor(id);
	}
	
	public List<Map<String, Object>> getProfessores(){
		return cdao.getProfessores();
	}
	
	public void deleteProfessor(int id) {
		cdao.deleteProfessor(id);
	}
	
	public void atualizarProfessor(int id, Professor c){
		cdao.atualizarProfessor(id, c);
	}
}