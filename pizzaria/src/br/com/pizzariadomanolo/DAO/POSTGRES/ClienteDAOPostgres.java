package br.com.pizzariadomanolo.DAO.POSTGRES;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.pizzariadomanolo.DAO.ClienteDAO;
import br.com.pizzariadomanolo.entidades.Cliente;
import br.com.pizzariadomanolo.util.BDConnection;

public class ClienteDAOPostgres implements ClienteDAO {

	public boolean cadastrarCliente(Cliente cliente) {
		Connection conexao;
		PreparedStatement comandoSQL;
		
		String sql = "INSERT INTO CLIENTE VALUES(?, ?, ?)";		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			comandoSQL.setString(1, cliente.getTelefone());
			comandoSQL.setString(2, cliente.getNome());
			comandoSQL.setString(3, cliente.getEndereco());
			comandoSQL.executeUpdate();
		} catch (SQLException e) {
			return false;
		}
		return true;

	}
	

	
	public boolean buscaCliente(Cliente cliente) {
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;
		String nome=null, endereco=null;
		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement("SELECT * FROM CLIENTE WHERE TELEFONE = ?");
			comandoSQL.setString(1, cliente.getTelefone());
			resultado = comandoSQL.executeQuery();
			while (resultado.next()) {
				nome = resultado.getString("NOME");
				endereco = resultado.getString("ENDERECO");
							
			}
			resultado.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
			
		cliente.criaCliente(nome, cliente.getTelefone(), endereco);	
		return true;
		
	}

}
