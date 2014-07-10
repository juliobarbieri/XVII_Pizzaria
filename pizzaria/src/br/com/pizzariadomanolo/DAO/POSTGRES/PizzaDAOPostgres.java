package br.com.pizzariadomanolo.DAO.POSTGRES;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import br.com.pizzariadomanolo.entidades.Pizza;
import br.com.pizzariadomanolo.util.BDConnection;

public class PizzaDAOPostgres {
	
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
		} catch (SQLException|NullPointerException e) {
			return false;
		}
		if (preco!=null && ingredientes!=null){
			pizza.criaPizza(pizza.getNomePizza(), ingredientes, preco.toString());
		}
		return true;
	}

}
