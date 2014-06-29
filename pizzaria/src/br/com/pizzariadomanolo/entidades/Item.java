package br.com.pizzariadomanolo.entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Item {
	
	private Integer id;
	private Pizza pizza;
	private Integer quantidade;
	
	public int getId() {
		return id;
	}
	
	public int getQuantidade(){
		return quantidade;
	}
	
	public double getValor(){
		return pizza.getPreco();
	}
	
	public void criaItem(Pizza pizza, int quantidade) {
		//this.id = id;
		this.pizza = pizza;
		this.quantidade = quantidade;

	}
	
	public void clear() {
		this.id = null;
		this.pizza = null;
		this.quantidade = null;

	}
	
	public boolean cadastrarItem() {
		Connection conexao;
		PreparedStatement comandoSQL;
		
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pizza", "postgres", "postgres");
			comandoSQL = conexao.prepareStatement("INSERT INTO ITEM VALUES(?, ?)");
			comandoSQL.setString(1, pizza.getNomePizza());
			comandoSQL.setInt(2, quantidade);
			comandoSQL.executeUpdate();
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			return false;
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	

}
