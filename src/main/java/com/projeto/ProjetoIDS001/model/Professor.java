package com.projeto.ProjetoIDS001.model;

public class Professor {
	
	private int id;
	private String nome, cpf, colegio, email;
	
	public Professor() {
		
	}
    
	public Professor(int id, String nome, String cpf, String colegio, String email) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.colegio = colegio;
		this.email = email;
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
    
    public String getColegio() {
    	return colegio;
    }

    public void setColegio(String colegio) {
    	this.colegio = colegio;
    }
    
    public String getEmail() {
    	return email;
    }

    public void setEmail(String email) {
    	this.email = email;
    }
}
