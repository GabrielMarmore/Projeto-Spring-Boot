package com.projeto.ProjetoIDS001.model;

public class Cliente {
	
	private int id;
	private String nome, cpf;
	
	public Cliente() {
		
	}
    
	public Cliente(int id, String nome, String cpf) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public int getId() {
		return id;
	}
    
	public void setId(int id) {
		this.id = id;
	}
    
	public String getNome() {
		return nome;
	}

    public void setNome(String nome) {
    	this.nome = nome;
    }

    public String getCpf() {
    	return cpf;
    }

    public void setCpf(String cpf) {
    	this.cpf = cpf;
    }
}
