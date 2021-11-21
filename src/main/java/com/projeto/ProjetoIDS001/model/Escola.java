package com.projeto.ProjetoIDS001.model;

public class Escola {
	
	private int id;
	private String nome, codigo;
	
	public Escola() {
		
	}
    
	public Escola(int id, String nome, String codigo) {
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
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

    public String getCodigo() {
    	return codigo;
    }

    public void setCodigo(String codigo) {
    	this.codigo = codigo;
    }
}