package br.com.pizzariamanolo.DAO.POSTGRES;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.pizzariadomanolo.entidades.Item;
import br.com.pizzariadomanolo.util.BDConnection;
import br.com.pizzariamanolo.DAO.ItemDAO;

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

}
