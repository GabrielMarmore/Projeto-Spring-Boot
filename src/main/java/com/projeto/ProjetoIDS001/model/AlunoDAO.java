package com.projeto.ProjetoIDS001.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AlunoDAO {
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}

	public void inserirAluno(Aluno aluno) {
		String sql = "INSERT INTO aluno(nome,cpf,colegio,email)" +
	                 " VALUES (?,?,?,?)";
		Object[] obj = new Object[4];
		//primeiro ?
		obj[0] = aluno.getNome();
		//segundo ?
		obj[1] = aluno.getCpf();
		//terceiro ?
		obj[2] = aluno.getColegio();
		//quarto ?
		obj[3] = aluno.getEmail();
		jdbc.update(sql, obj);
	}
	
	public Map<String, Object> getAluno(int id) {
		String sql = "SELECT * FROM aluno WHERE aluno.id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		return jdbc.queryForMap(sql,obj);		
	}
	
	public List<Map<String, Object>> getAlunos() {
		String sql = "SELECT * FROM aluno";
		List<Map<String, Object>> alunos = (List<Map<String, Object>>)jdbc.queryForList(sql);
		return alunos;
	}
	
	public void deleteAluno(int id) {
        String sql = "DELETE FROM aluno WHERE id = ?" ;
        Object[] obj = new Object[1];
        obj[0] = id;
        jdbc.update(sql,obj);
    }
    
    public void atualizarAluno(int id, Aluno aluno) {
		String sql = "UPDATE aluno "
				+    "SET nome = ?, cpf = ?, colegio = ?, email = ?"
				+    "WHERE id = ?" ;
		Object[] obj = new Object[5];
		//primeiro ?
		obj[0] = aluno.getNome();
		//segundo ?
		obj[1] = aluno.getCpf();
		//terceiro ?
		obj[2] = aluno.getColegio();
		//quarto ?
		obj[3] = aluno.getEmail();
		obj[4] = id;
		
		jdbc.update(sql, obj);
	}
}


