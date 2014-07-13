package br.com.pizzariadomanolo.DAO.POSTGRES;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.pizzariadomanolo.DAO.PizzaDAO;
import br.com.pizzariadomanolo.entidades.Pizza;
import br.com.pizzariadomanolo.util.BDConnection;

public class PizzaDAOPostgres implements PizzaDAO {
	
	public boolean cadastrarPizza(Pizza pizza) {
		Connection conexao;
		PreparedStatement comandoSQL;
		
		String sql = "INSERT INTO CARDAPIO VALUES(?, ?, ?)";
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			comandoSQL.setString(1, pizza.getNomePizza());
			comandoSQL.setString(2, pizza.getIngredientes());
			comandoSQL.setString(3, pizza.getPreco().toString());
			comandoSQL.executeUpdate();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
	public ArrayList<Pizza> retireveAll() {
		Connection conexao;
		Statement comandoSQL;
		ResultSet resultado;
		
		ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.createStatement();
			resultado = comandoSQL.executeQuery("SELECT * FROM CARDAPIO");
			while (resultado.next()) {
				String nomePizza = resultado.getString("NOME_PIZZA");
				String ingredientes = resultado.getString("INGREDIENTES");
				Float preco = Float.parseFloat(resultado.getString("PRECO"));
				
				Pizza p = new Pizza();
				p.criaPizza(nomePizza, ingredientes, preco.toString());
				
				pizzas.add(p);
			}
			resultado.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pizzas;

	}
	
	public boolean buscaPizza(Pizza pizza) {
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;
		String ingredientes = null;
		Float preco = null;
		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement("SELECT * FROM CARDAPIO WHERE NOME_PIZZA = ?");
			comandoSQL.setString(1,pizza.getNomePizza());
			resultado = comandoSQL.executeQuery();
			while (resultado.next()) {
				ingredientes = resultado.getString("INGREDIENTES");
				preco = Float.parseFloat(resultado.getString("PRECO"));
			}
			resultado.close();
		} catch (SQLException e) {
			return false;
		}
		
		pizza.criaPizza(pizza.getNomePizza(), ingredientes, preco.toString());
		return true;
	}

}
