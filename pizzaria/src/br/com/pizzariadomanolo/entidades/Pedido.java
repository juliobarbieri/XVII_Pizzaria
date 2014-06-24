package br.com.pizzariadomanolo.entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Pedido {

	private String telefone;
	private Date data;
	private String nomePizza;
	private Integer quantidade;
	
	public String getTelefone() {
		return telefone;
	}
	
	public Date getData() {
		return data;
	}
	
	public String getNomePizza() {
		return nomePizza;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void criaPedido(String telefone, String nomePizza, int quantidade) {
		this.telefone = telefone;
		this.nomePizza = nomePizza;
		this.quantidade = quantidade;

	}

	public void clear() {
		this.telefone = null;
		this.nomePizza = null;
		this.quantidade = null;

	}
	
	public boolean cadastrarPedido() {
		Connection conexao;
		PreparedStatement comandoSQL;
		
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pizza", "postgres", "postgres");
			comandoSQL = conexao.prepareStatement("INSERT INTO PEDIDO VALUES(?, current_timestamp, ?, ?)");
			comandoSQL.setString(1, telefone);
			comandoSQL.setString(2, nomePizza);
			comandoSQL.setInt(3, quantidade);
			comandoSQL.executeUpdate();
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			return false;
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
	
}
