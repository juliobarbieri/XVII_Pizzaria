package br.com.pizzariadomanolo.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.pizzariadomanolo.util.BDConnection;

public class Cliente {
	
	private String telefone;
	private String nome;
	private String endereco;

	public String getTelefone() {
		return telefone;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void criaCliente(String nome, String telefone, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	public void clear() {
		this.nome = null;
		this.telefone = null;
		this.endereco = null;
	}
	
	public boolean cadastrarCliente() {
		Connection conexao;
		PreparedStatement comandoSQL;
		
		String sql = "INSERT INTO CLIENTE VALUES(?, ?, ?)";		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			comandoSQL.setString(1, telefone);
			comandoSQL.setString(2, nome);
			comandoSQL.setString(3, endereco);
			comandoSQL.executeUpdate();
		} catch (SQLException e) {
			return false;
		}
		return true;

	}
	
	public boolean buscaCliente() {
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;
		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement("SELECT * FROM CLIENTE WHERE TELEFONE = ?");
			comandoSQL.setString(1, telefone);
			resultado = comandoSQL.executeQuery();
			while (resultado.next()) {
				nome	 = resultado.getString("NOME");
				endereco = resultado.getString("ENDERECO");
			}
			resultado.close();
		} catch (SQLException e) {
			return false;
		}
		return true;

	}
}
