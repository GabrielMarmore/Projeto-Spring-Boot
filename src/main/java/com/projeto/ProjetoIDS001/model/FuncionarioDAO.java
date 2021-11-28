package com.projeto.ProjetoIDS001.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FuncionarioDAO {
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}

	public void inserirFuncionario(Funcionario funcionario) {
		String sql = "INSERT INTO funcionario(nome,cpf,colegio)" +
	                 " VALUES (?,?,?)";
		Object[] obj = new Object[3];
		//primeiro ?
		obj[0] = funcionario.getNome();
		//segundo ?
		obj[1] = funcionario.getCpf();
		//terceiro ?
		obj[2] = funcionario.getColegio();
		jdbc.update(sql, obj);
	}
	
	public Map<String, Object> getFuncionario(int id) {
		String sql = "SELECT * FROM funcionario WHERE funcionario.id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		return jdbc.queryForMap(sql,obj);		
	}
	
	public List<Map<String, Object>> getFuncionarios() {
		String sql = "SELECT * FROM funcionario";
		List<Map<String, Object>> funcionarios = (List<Map<String, Object>>)jdbc.queryForList(sql);
		return funcionarios;
	}
	
	public void deleteFuncionario(int id) {
        String sql = "DELETE FROM funcionario WHERE id = ?" ;
        Object[] obj = new Object[1];
        obj[0] = id;
        jdbc.update(sql,obj);
    }
    
    public void atualizarFuncionario(int id, Funcionario funcionario) {
		String sql = "UPDATE funcionario "
				+    "SET nome = ?, cpf = ?, colegio = ? "
				+    "WHERE id = ?" ;
		Object[] obj = new Object[4];
		//primeiro ?
		obj[0] = funcionario.getNome();
		//segundo ?
		obj[1] = funcionario.getCpf();
		// terceiro ?
		obj[2] = funcionario.getColegio();
		obj[3] = id;
		jdbc.update(sql, obj);
	}
}
