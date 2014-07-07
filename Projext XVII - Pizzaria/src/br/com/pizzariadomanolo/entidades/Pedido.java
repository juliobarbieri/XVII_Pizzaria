package br.com.pizzariadomanolo.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.pizzariadomanolo.util.BDConnection;

public class Pedido {
	
	private Integer id;
	private String telefone;
	private Timestamp data;
	
	private List<Item> itens;
	
	public Integer getId() {
		return id;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public Timestamp getData() {
		return data;
	}
	
	public List<Item> getItens() {
		return itens;
	}
	
	public void criaPedido(String telefone) {
		this.telefone = telefone;
		
		this.itens = new ArrayList<Item>();
	}

	public void clear() {
		this.telefone = null;
		this.itens = null;
	}
	
	public void adicionarItem(Pizza pizza, int quantidade) {
		Item item = new Item();
		item.criaItem(pizza, quantidade);
		itens.add(item);
	}

	public boolean cadastrarPedido() {
		Connection conexao;
		PreparedStatement comandoSQL;
		
		try {
			conexao = BDConnection.getConnection();
			
			Date currentTime = new java.util.Date();
			data = new Timestamp(currentTime.getTime());
			
			comandoSQL = conexao.prepareStatement("INSERT INTO PEDIDO(telefone, data_hora) VALUES(?, ?)");
			comandoSQL.setString(1, telefone);
			comandoSQL.setTimestamp(2, data);
			comandoSQL.executeUpdate();
			
			cadastraItens();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private boolean cadastraItens() {
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;
		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement("SELECT * FROM PEDIDO WHERE telefone = ? and data_hora = ?");
			comandoSQL.setString(1, telefone);
			comandoSQL.setTimestamp(2, data);
			resultado = comandoSQL.executeQuery();
			
			while (resultado.next()) {
				id = resultado.getInt("id");
			}
			resultado.close();
			
			for (Item item : itens) {
				item.cadastrarItem(id);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
	
}
