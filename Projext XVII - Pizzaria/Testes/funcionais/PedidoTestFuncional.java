package funcionais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.*;



public class PedidoTestFuncional {
	
	Date currentTime = new java.util.Date();
	Timestamp data = new Timestamp(currentTime.getTime()); 
	ItemTestFuncional item = new ItemTestFuncional();
	
	@Test
	public void cadastrarPedido() {
		Connection conexao;
				
		try {
			
			conexao = ConexaoBancoTeste.obterConexao();
			assertNotNull(criaTabelaPedido(conexao).executeUpdate());
			assertNotNull(inserePedido(conexao).executeUpdate());
			assertEquals(contadorLinhasPedido(conexao),1);
			deletarTabelaPedido(conexao);
			
		} catch (SQLException e) {
			//e.printStackTrace();
			
			System.err.println(e + ", erro no cadastro do pedido");
			
		}
		
	}
	
	@Test
	public void cadastraItens() {
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;
		
		try {
			conexao = ConexaoBancoTeste.obterConexao();
			assertNotNull(item.criaTabela(conexao).executeUpdate());
			assertNotNull(criaTabelaPedido(conexao).executeUpdate());
			assertNotNull(inserePedido(conexao).executeUpdate());
			comandoSQL = conexao.prepareStatement("SELECT * FROM PEDIDO WHERE telefone = ? and data_hora = ?");
			comandoSQL.setString(1, "123456");
			comandoSQL.setTimestamp(2, data);
			resultado = comandoSQL.executeQuery();
			int	id=0;
			while (resultado.next()) {
			id = resultado.getInt("id");
			}
			assertEquals(id,1);
			deletarTabelaPedido(conexao);
			item.deletarTabela(conexao);					
			resultado.close();
			
			
			
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println(e + ", erro no cadastro do item");

		}
	}
	
	public PreparedStatement inserePedido(Connection conexao) throws SQLException{		
		PreparedStatement comandoSQL;
		String sql = "INSERT INTO PEDIDO VALUES(?,?,?);";	
		comandoSQL = conexao.prepareStatement(sql);
		comandoSQL.setInt(1, 1);
		comandoSQL.setString(2, "123456");
		comandoSQL.setTimestamp(3, data);
	
		return comandoSQL;		
	}
	
	public void deletarTabelaPedido(Connection conexao) throws SQLException{
		String deletaTabela = "DROP TABLE PEDIDO;";	
		conexao.createStatement().executeUpdate(deletaTabela);
	}
	



	
	
	public int contadorLinhasPedido(Connection conexao) throws SQLException{		
		String verificaInsercao = "SELECT COUNT (TELEFONE) FROM PEDIDO;";
		
		ResultSet comandoSQL = conexao.prepareStatement(verificaInsercao).executeQuery();
		int contador = 0;
		while (comandoSQL.next()) {
			contador = comandoSQL.getInt("count");
			}
		
		return contador;
	}
	
	public PreparedStatement criaTabelaPedido(Connection conexao) throws SQLException{
		String tableCliente = "CREATE TABLE PEDIDO (ID serial, TELEFONE varchar, data_hora timestamp);";
		PreparedStatement comandoSQL = conexao.prepareStatement(tableCliente);	
		
		return comandoSQL;		
	}
	


}
