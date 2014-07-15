package br.com.pizzariadomanolo.DAO.POSTGRES;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.pizzariadomanolo.DAO.ItemDAO;
import br.com.pizzariadomanolo.DAO.PizzaDAO;
import br.com.pizzariadomanolo.entidades.Item;
import br.com.pizzariadomanolo.entidades.Pedido;
import br.com.pizzariadomanolo.entidades.Pizza;
import br.com.pizzariadomanolo.util.BDConnection;

public class ItemDAOPostgres implements ItemDAO {

	
	public boolean cadastrarItem(Integer idPedido, Item item) {
		Connection conexao;
		PreparedStatement comandoSQL;
		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement("INSERT INTO ITEM(nome_pizza, quantidade, pedido_id) VALUES(?, ?, ?)");
			comandoSQL.setString(1, item.getPizza().getNomePizza());
			comandoSQL.setInt(2, item.getQuantidade());
			comandoSQL.setInt(3, idPedido);
			comandoSQL.executeUpdate();
			
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
	@Override
	public ArrayList<Item> getItensByPedido(Pedido pedido) {
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;
		
		ArrayList<Item> itens = new ArrayList<Item>();
		
		PizzaDAO pizzaDAO = new PizzaDAOPostgres();
		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement("SELECT * FROM ITEM WHERE pedido_id = ?");
			comandoSQL.setInt(1, pedido.getId());
			resultado = comandoSQL.executeQuery();
			
			while (resultado.next()) {
				Pizza pizza = new Pizza();
				pizza.setNomePizza(resultado.getString("nome_pizza"));
				pizzaDAO.buscaPizza(pizza);
				
				Item item = new Item();
				item.setId(resultado.getInt("id"));
				item.setPizza(pizza);
				item.setQuantidade(resultado.getInt("quantidade"));
				item.setPedido(pedido);
				
				itens.add(item);
			}
			resultado.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itens;
		

	}

}
