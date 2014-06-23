package br.com.pizzariadomanolo.entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cliente {
	
	private String telefone;
	private String nome;
	private String endereco;

	public String getTelefone() {
		return telefone;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void criaCliente(String nome, String telefone, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	public void clear() {
		this.nome = null;
		this.telefone = null;
		this.endereco = null;
	}
	
	public void cadastrarCliente() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conexao;
		PreparedStatement comandoSQL;
		
		String sql = "INSERT INTO CLIENTE VALUES(?, ?, ?)";		
		Class.forName("org.postgresql.Driver").newInstance();
		conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pizza", "postgres", "postgres");
		comandoSQL = conexao.prepareStatement(sql);
		comandoSQL.setString(1, telefone);
		comandoSQL.setString(2, nome);
		comandoSQL.setString(3, endereco);
		comandoSQL.executeUpdate();

	}
}
