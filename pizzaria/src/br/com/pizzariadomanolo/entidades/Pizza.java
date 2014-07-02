package br.com.pizzariadomanolo.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.pizzariadomanolo.util.BDConnection;


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
	
	public void setNomePizza(String nomePizza) {
		this.nomePizza = nomePizza;
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
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			comandoSQL.setString(1, nomePizza);
			comandoSQL.setString(2, ingredientes);
			comandoSQL.setString(3, preco.toString());
			comandoSQL.executeUpdate();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
	public boolean buscaPizza() {
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;
		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement("SELECT * FROM CARDAPIO WHERE NOME_PIZZA = ?");
			comandoSQL.setString(1, nomePizza);
			resultado = comandoSQL.executeQuery();
			while (resultado.next()) {
				this.ingredientes = resultado.getString("INGREDIENTES");
				this.preco = Float.parseFloat(resultado.getString("PRECO"));
			}
			resultado.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	
}
