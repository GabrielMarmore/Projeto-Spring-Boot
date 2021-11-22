package com.projeto.ProjetoIDS001.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProfessorDAO {
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}

	public void inserirProfessor(Professor professor) {
		String sql = "INSERT INTO professor(nome,cpf)" +
	                 " VALUES (?,?)";
		Object[] obj = new Object[2];
		//primeiro ?
		obj[0] = professor.getNome();
		//segundo ?
		obj[1] = professor.getCpf();
		jdbc.update(sql, obj);
	}
	
	public Map<String, Object> getProfessor(int id) {
		String sql = "SELECT * FROM professor WHERE professor.id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		return jdbc.queryForMap(sql,obj);		
	}
	
	public List<Map<String, Object>> getProfessores() {
		String sql = "SELECT * FROM professor";
		List<Map<String, Object>> professores = (List<Map<String, Object>>)jdbc.queryForList(sql);
		return professores;
	}
	
	public void deleteProfessor(int id) {
        String sql = "DELETE FROM professor WHERE id = ?" ;
        Object[] obj = new Object[1];
        obj[0] = id;
        jdbc.update(sql,obj);
    }
    
    public void atualizarProfessor(int id, Professor professor) {
		String sql = "UPDATE professor "
				+    "SET nome = ?, cpf = ? "
				+    "WHERE id = ?" ;
		Object[] obj = new Object[3];
		//primeiro ?
		obj[0] = professor.getNome();
		//segundo ?
		obj[1] = professor.getCpf();
		obj[2] = id;
		jdbc.update(sql, obj);
	}
}