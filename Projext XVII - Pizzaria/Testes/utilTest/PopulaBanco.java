package utilTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.pizzariadomanolo.DAO.POSTGRES.ClienteDAOPostgres;
import br.com.pizzariadomanolo.entidades.Cliente;
import br.com.pizzariadomanolo.util.BDConnection;

public class PopulaBanco {
	private ClienteDAOPostgres cdao = new ClienteDAOPostgres();
	private Cliente cliente = new Cliente();
	
	public void inserir(){
				
		cliente.criaCliente("nome", "123456", "endereco", String.valueOf(123));
		cliente.setSenha("123");
		cdao.cadastrarCliente(cliente);
	}

	public boolean remover(){
		Connection conexao;
		PreparedStatement comandoSQL;
		
		String sql = "DELETE FROM CLIENTE WHERE telefone = ?;";		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			comandoSQL.setString(1, "123456");
			comandoSQL.executeUpdate();
		} catch (SQLException e) {
			 return false;
		}
		return true;
	}
	public static void main(String[] args) {
		PopulaBanco pop = new PopulaBanco();
		pop.remover();
	}
}
