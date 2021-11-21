package com.projeto.ProjetoIDS001.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDAO {
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}

	public void inserirCliente(Cliente cliente) {
		String sql = "INSERT INTO cliente(nome,cpf)" +
	                 " VALUES (?,?)";
		Object[] obj = new Object[2];
		//primeiro ?
		obj[0] = cliente.getNome();
		//segundo ?
		obj[1] = cliente.getCpf();
		jdbc.update(sql, obj);
	}
	
	public Map<String, Object> getCliente(int id) {
		String sql = "SELECT * FROM cliente WHERE cliente.id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		return jdbc.queryForMap(sql,obj);		
	}
	
	public List<Map<String, Object>> getClientes() {
		String sql = "SELECT * FROM cliente";
		List<Map<String, Object>> clientes = (List<Map<String, Object>>)jdbc.queryForList(sql);
		return clientes;
	}
}


