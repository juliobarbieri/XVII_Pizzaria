package funcionais;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.*;


public class PizzaTestFuncional {
	
	@Test
	public void cadastrarPizza() {
		try{
		Connection conexao = ConexaoBancoTeste.obterConexao();
		assertNotNull(criaTabelaCardapio(conexao).executeUpdate());
		assertNotNull(inserirPizza(conexao).executeUpdate());
		assertEquals(1,contadorLinhas(conexao));
		deletarTabelaCardapio(conexao);
		
		} catch (SQLException e) {
			System.err.println(e + ", problema no cadastro da pizza");
		}
	}
		
	
	@Test
	public void buscaPizza() {
			try{
			Connection conexao = ConexaoBancoTeste.obterConexao();
			assertNotNull(criaTabelaCardapio(conexao).executeUpdate());
			assertNotNull(inserirPizza(conexao).executeUpdate());
			
			ResultSet resultado = buscarPizza(conexao).executeQuery();
			String ingredientes ="";
			Float preco = null;
			while (resultado.next()) {
				ingredientes = resultado.getString("INGREDIENTES");
				preco = Float.parseFloat(resultado.getString("PRECO"));
			}
			
			assertEquals(ingredientes , "ingredientes");
			assertEquals(preco,10,0);
			deletarTabelaCardapio(conexao);
			
			} catch (SQLException e) {
				System.err.println(e + " , problema em buscar pizza");
			}
		
	}
	
	public PreparedStatement inserePizza(Connection conexao) throws SQLException{		
		String sql = "INSERT INTO CARDAPIO VALUES(?, ?, ?)";			
		PreparedStatement comandoSQL = conexao.prepareStatement(sql);
		
		comandoSQL.setString(1, "123456");
		comandoSQL.setString(2, "nome");
		comandoSQL.setString(3, "endereco");
		
		return comandoSQL;		
	}
	
	public int contadorLinhas(Connection conexao) throws SQLException{		
		String verificaInsercao = "SELECT COUNT (nome_pizza) FROM CARDAPIO;";
		
		ResultSet comandoSQL = conexao.prepareStatement(verificaInsercao).executeQuery();
		int contador = 0;
		while (comandoSQL.next()) {
			contador = comandoSQL.getInt("count");
			}
		
		return contador;
		
	}
	
	public PreparedStatement criaTabelaCardapio(Connection conexao) throws SQLException{
		String tableCardapio = "CREATE TABLE CARDAPIO (nome_pizza varchar , ingredientes varchar, preco varchar);";
		PreparedStatement comandoSQL = conexao.prepareStatement(tableCardapio);	
		
		return comandoSQL;		
	}
	
	public PreparedStatement inserirPizza(Connection conexao) throws SQLException{
		PreparedStatement comandoSQL;
	
		String sql = "INSERT INTO CARDAPIO VALUES(?, ?, ?)";
		comandoSQL = conexao.prepareStatement(sql);
		comandoSQL.setString(1, "marguerita");
		comandoSQL.setString(2, "ingredientes");
		comandoSQL.setString(3, "10");
	
		return comandoSQL;
	}

	public void deletarTabelaCardapio(Connection conexao) throws SQLException{
		String deletaTabela = "DROP TABLE CARDAPIO;";	
		conexao.createStatement().executeUpdate(deletaTabela);
	}
	
	public PreparedStatement buscarPizza(Connection conexao) throws SQLException{
		PreparedStatement comandoSQL;
		comandoSQL = conexao.prepareStatement("SELECT * FROM CARDAPIO WHERE NOME_PIZZA = ?");
		comandoSQL.setString(1, "marguerita");
		
		return comandoSQL;
		
	}

}
