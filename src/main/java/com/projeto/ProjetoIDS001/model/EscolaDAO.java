package com.projeto.ProjetoIDS001.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EscolaDAO {
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}

	public void inserirEscola(Escola escola) {
		String sql = "INSERT INTO escola(nome,codigo)" +
	                 " VALUES (?,?)";
		Object[] obj = new Object[2];
		//primeiro ?
		obj[0] = escola.getNome();
		//segundo ?
		obj[1] = escola.getCodigo();
		jdbc.update(sql, obj);
	}
	
	public Map<String, Object> getEscola(int id) {
		String sql = "SELECT * FROM escola WHERE escola.id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		return jdbc.queryForMap(sql,obj);		
	}
	
	public List<Map<String, Object>> getEscolas() {
		String sql = "SELECT * FROM escola";
		List<Map<String, Object>> escolas = (List<Map<String, Object>>)jdbc.queryForList(sql);
		return escolas;
	}
	
	public void deleteEscola(int id) {
        String sql = "DELETE FROM escola WHERE id = ?" ;
        Object[] obj = new Object[1];
        obj[0] = id;
        jdbc.update(sql,obj);
    }
    
    public void atualizarEscola(int id, Escola escola) {
		String sql = "UPDATE escola "
				+    "SET nome = ?, codigo = ? "
				+    "WHERE id = ?" ;
		Object[] obj = new Object[3];
		//primeiro ?
		obj[0] = escola.getNome();
		//segundo ?
		obj[1] = escola.getCodigo();
		obj[2] = id;
		jdbc.update(sql, obj);
	}
}