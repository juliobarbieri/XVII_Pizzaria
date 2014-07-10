package br.com.pizzariadomanolo.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.pizzariadomanolo.util.BDConnection;

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
	
	public float getTotal() {
		return quantidade * pizza.getPreco();
	}
	
	public Pizza getPizza(){
		return pizza;
	}
	
	public void criaItem(Pizza pizza, int quantidade) {
		this.pizza = new Pizza();
		this.pizza.criaPizza(pizza.getNomePizza(), pizza.getIngredientes(), pizza.getPreco().toString());
		this.quantidade = quantidade;

	}
	
	public void clear() {
		this.id = null;
		this.pizza = null;
		this.quantidade = null;

	}
	
	public boolean cadastrarItem(Integer idPedido) {
		Connection conexao;
		PreparedStatement comandoSQL;
		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement("INSERT INTO ITEM(nome_pizza, quantidade, pedido_id) VALUES(?, ?, ?)");
			comandoSQL.setString(1, pizza.getNomePizza());
			comandoSQL.setInt(2, quantidade);
			comandoSQL.setInt(3, idPedido);
			comandoSQL.executeUpdate();
			
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	

}
