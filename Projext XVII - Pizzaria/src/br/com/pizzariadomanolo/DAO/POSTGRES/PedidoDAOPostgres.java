package br.com.pizzariadomanolo.DAO.POSTGRES;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.pizzariadomanolo.DAO.ItemDAO;
import br.com.pizzariadomanolo.DAO.PedidoDAO;
import br.com.pizzariadomanolo.entidades.Item;
import br.com.pizzariadomanolo.entidades.Pedido;
import br.com.pizzariadomanolo.util.BDConnection;

public class PedidoDAOPostgres implements PedidoDAO {

	public boolean cadastrarPedido(Pedido pedido) {
		Connection conexao;
		PreparedStatement comandoSQL;
		
		try {
			conexao = BDConnection.getConnection();
			
			Date currentTime = new java.util.Date();
			pedido.setData(new Timestamp(currentTime.getTime()));
			
			comandoSQL = conexao.prepareStatement("INSERT INTO PEDIDO(telefone, data_hora, forma_pagamento, troco) VALUES(?, ?, ?, ?)");
			comandoSQL.setString(1, pedido.getTelefone());
			comandoSQL.setTimestamp(2, pedido.getData());
			comandoSQL.setString(3, pedido.getFormaPagamento());
			comandoSQL.setFloat(4, pedido.getTroco());
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

	@Override
	public ArrayList<Pedido> getPedidosByTelefone(String telefone) {
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;
		
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		
		ItemDAO itemDAO = new ItemDAOPostgres();
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement("SELECT * FROM PEDIDO WHERE telefone = ?");
			comandoSQL.setString(1, telefone);
			resultado = comandoSQL.executeQuery();
			
			while (resultado.next()) {
				Pedido pedido = new Pedido();
				pedido.criaPedido(telefone);
				pedido.setId(resultado.getInt("id"));
				pedido.setData(resultado.getTimestamp("data_hora"));
				pedido.setFormaPagamento(resultado.getString("forma_pagamento"));
				pedido.setTroco(resultado.getFloat("troco"));
				
				pedido.setItens(itemDAO.getItensByPedido(pedido));
				
				pedidos.add(pedido);
				pedido.clear();
			}
			resultado.close();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pedidos;
	}

}
