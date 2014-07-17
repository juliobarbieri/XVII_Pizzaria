package funcionais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import static org.junit.Assert.*;


public class ItemTestFuncional {
	
	@Test
	public void cadastrarItem(){
		
		Connection conexao;		
		try {
			
			conexao = ConexaoBancoTeste.obterConexao();//conexao com o banco de teste	
			assertNotNull(criaTabela(conexao).executeUpdate());			
			assertNotNull(insereItem(conexao).executeUpdate());
			ResultSet rs = contadorLinhas(conexao);
			int linhas = 0;
			while(rs.next()){
				linhas = rs.getInt("count");
			}
			assertEquals(1,linhas);
			deletarTabela(conexao);
			conexao.close();
					
			
		} catch (SQLException e) {
			System.err.println(e + " Problema no cadastro");
		}		
	}
		


public PreparedStatement criaTabela(Connection conexao) throws SQLException{
	String tableCliente = "CREATE TABLE ITEM ( ID serial, NOME_PIZZA VARCHAR, QUANTIDADE varchar , PEDIDO_id varchar );";
	PreparedStatement comandoSQL = conexao.prepareStatement(tableCliente);	
	
	return comandoSQL;		
}

public PreparedStatement insereItem(Connection conexao) throws SQLException{		
	String sql = "INSERT INTO ITEM(nome_pizza, quantidade, pedido_id) VALUES(?, ?, ?)";			
	PreparedStatement comandoSQL = conexao.prepareStatement(sql);
	
	comandoSQL.setString(1, "nome_pizza");
	comandoSQL.setString(2, "1");
	comandoSQL.setString(3, "1");
	
	return comandoSQL;		
}

public ResultSet contadorLinhas(Connection conexao) throws SQLException{		
	String verificaInsercao = "SELECT COUNT (pedido_id) FROM ITEM;";
	
	ResultSet comandoSQL = conexao.prepareStatement(verificaInsercao).executeQuery();
	
	return comandoSQL;
}

public void deletarTabela(Connection conexao) throws SQLException{
	String deletaTabela = "DROP TABLE ITEM;";	
	conexao.createStatement().executeUpdate(deletaTabela);
}


}
