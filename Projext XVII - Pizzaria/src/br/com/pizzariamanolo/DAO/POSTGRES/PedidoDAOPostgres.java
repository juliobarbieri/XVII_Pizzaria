package br.com.pizzariamanolo.DAO.POSTGRES;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import br.com.pizzariadomanolo.entidades.Item;
import br.com.pizzariadomanolo.entidades.Pedido;
import br.com.pizzariadomanolo.util.BDConnection;
import br.com.pizzariamanolo.DAO.PedidoDAO;

public class PedidoDAOPostgres implements PedidoDAO {

	public boolean cadastrarPedido(Pedido pedido) {
		Connection conexao;
		PreparedStatement comandoSQL;
		
		try {
			conexao = BDConnection.getConnection();
			
			Date currentTime = new java.util.Date();
			pedido.setData(new Timestamp(currentTime.getTime()));
			
			comandoSQL = conexao.prepareStatement("INSERT INTO PEDIDO(telefone, data_hora) VALUES(?, ?)");
			comandoSQL.setString(1, pedido.getTelefone());
			comandoSQL.setTimestamp(2, pedido.getData());
			comandoSQL.executeUpdate();
			
			cadastraItens(pedido);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean cadastraItens(Pedido pedido) {
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;
		ItemDAOPostgres itensBD = new ItemDAOPostgres();
		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement("SELECT * FROM PEDIDO WHERE telefone = ? and data_hora = ?");
			comandoSQL.setString(1, pedido.getTelefone());
			comandoSQL.setTimestamp(2, pedido.getData());
			resultado = comandoSQL.executeQuery();
			
			while (resultado.next()) {
				pedido.setId(resultado.getInt("id"));
			}
			resultado.close();
			
			List<Item> itens = pedido.getItens();
			
			for (Item item : itens) {
				itensBD.cadastrarItem(pedido.getId(), item);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

}
