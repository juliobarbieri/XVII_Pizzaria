package br.com.pizzariadomanolo.entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Pizza {
	
	private String nomePizza;
	private String ingredientes;
	private Float preco;
	
	public String getNomePizza() {
		return nomePizza;
	}
	
	public String getIngredientes() {
		return ingredientes;
	}
	
	public Float getPreco() {
		return preco;
	}
	
	public void criaPizza(String nomePizza, String ingredientes, String preco) {
		this.nomePizza = nomePizza;
		this.ingredientes = ingredientes;
		this.preco = Float.parseFloat(preco);
	}
	
	public void clear() {
		this.nomePizza = null;
		this.ingredientes = null;
		this.preco = null;
	}
	
	public boolean cadastrarPizza() {
		Connection conexao;
		PreparedStatement comandoSQL;
		
		String sql = "INSERT INTO CARDAPIO VALUES(?, ?, ?)";
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pizza", "postgres", "postgres");
			comandoSQL = conexao.prepareStatement(sql);
			comandoSQL.setString(1, nomePizza);
			comandoSQL.setString(2, ingredientes);
			comandoSQL.setString(3, preco.toString());
			comandoSQL.executeUpdate();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			return false;
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	
}
