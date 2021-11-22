package com.projeto.ProjetoIDS001.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscolaService {
	
	@Autowired
	EscolaDAO cdao;
	
	public void inserirEscola(Escola c) {
		cdao.inserirEscola(c);
	}
	
	public Map<String, Object> getEscola(int id) {
		return cdao.getEscola(id);
	}
	
	public List<Map<String, Object>> getEscolas(){
		return cdao.getEscolas();
	}
	
	public void deleteEscola(int id) {
		cdao.deleteEscola(id);
	}
	
	public void atualizarEscola(int id, Escola c){
		cdao.atualizarEscola(id, c);
	}
}