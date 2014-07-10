package br.com.pizzariamanolo.DAO.POSTGRES;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.pizzariadomanolo.entidades.Cliente;
import br.com.pizzariadomanolo.util.BDConnection;
import br.com.pizzariamanolo.DAO.ClienteDAO;

public class ClienteDAOPostgres implements ClienteDAO {

	public boolean cadastrarCliente(Cliente cliente) {
		Connection conexao;
		PreparedStatement comandoSQL;
		
		String sql = "INSERT INTO CLIENTE VALUES(?, ?, ?, ?)";		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			comandoSQL.setString(1, cliente.getTelefone());
			comandoSQL.setString(2, cliente.getTelefone());
			comandoSQL.setString(3, cliente.getEndereco());
			comandoSQL.setString(4, cliente.getSenha());
			comandoSQL.executeUpdate();
		} catch (SQLException e) {
			return false;
		}
		return true;

	}
	
	public boolean verificaExistenciaCliente(String telefone) {
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;
		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement("SELECT * FROM CLIENTE WHERE TELEFONE = ?");
			comandoSQL.setString(1, telefone);
			resultado = comandoSQL.executeQuery();
			return resultado.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validaCliente(Cliente cliente, String senha) {
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;
		String senhaBD=null, nome=null, endereco=null;
		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement("SELECT * FROM CLIENTE WHERE TELEFONE = ?");
			comandoSQL.setString(1, cliente.getTelefone());
			resultado = comandoSQL.executeQuery();
			while (resultado.next()) {
				nome = resultado.getString("NOME");
				endereco = resultado.getString("ENDERECO");
				senhaBD = resultado.getString("SENHA");				
			}
			resultado.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		if (senha != null && senha.equals(senhaBD)) {
			cliente.criaCliente(nome, cliente.getTelefone(), endereco, senhaBD);
			return true;
		}
		else {			
			return false;
		}

	}

}
