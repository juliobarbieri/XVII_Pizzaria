package funcionais;

import org.junit.Test;

import util.ConexaoBancoTeste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import static org.junit.Assert.*;

public class ClienteDAOPostgresTestFuncional {


	
	@Test
	public void cadastrarClienteTest() {				
		String deletaTabela = "DROP TABLE CLIENTE;";
		Connection conexao;				
			
		try {
			
			conexao = ConexaoBancoTeste.obterConexao();//conexao com o banco de teste
			assertNotNull(criaTabela(conexao).executeUpdate());		
			assertNotNull(insereCliente(conexao).executeUpdate());
			ResultSet rs = contadorLinhas(conexao);
			int linhas = 0;
			while(rs.next()){
				linhas = rs.getInt("count");
			}
			assertEquals( linhas,1);	//verifica se apenas uma linha foi inserida na tabela criada			
			conexao.createStatement().executeUpdate(deletaTabela);
			conexao.close();
			
		} catch (SQLException e) {
			System.err.println(e + " Problema no cadastro");
		}		
	}
	
	@Test
	public void buscaCliente(){
		String deletaTabela = "DROP TABLE CLIENTE;";
		String nome =""	;
		String endereco = "";
		
		Connection conexao;				
			
		try {
			
			conexao = ConexaoBancoTeste.obterConexao();//conexao com o banco de teste			
			assertNotNull(criaTabela(conexao).executeUpdate());			
			assertNotNull(insereCliente(conexao).executeUpdate());
			ResultSet resultado = busca(conexao);
			while (resultado.next()) {
				nome	 = resultado.getString("NOME");
				endereco = resultado.getString("ENDERECO");
			}
			assertEquals(nome,"nome");
			assertEquals(endereco,"endereco");
			conexao.createStatement().executeUpdate(deletaTabela);
					
			
		} catch (SQLException e) {
			System.err.println(e + " Problema na busca");
		}		
	}
	
	public ResultSet busca(Connection conexao) throws SQLException{
		String telefone = "123456";
		String buscaTelefone = "SELECT * FROM CLIENTE WHERE TELEFONE = ?;";
		PreparedStatement comandoSQL = conexao.prepareStatement(buscaTelefone);
		comandoSQL.setString(1, telefone);
		return comandoSQL.executeQuery();
	}
	
	
	public PreparedStatement criaTabela(Connection conexao) throws SQLException{
		String tableCliente = "CREATE TABLE CLIENTE ( TELEFONE varchar, NOME VARCHAR, ENDERECO VARCHAR);";
		PreparedStatement comandoSQL = conexao.prepareStatement(tableCliente);	
		
		return comandoSQL;		
	}
	
	public PreparedStatement insereCliente(Connection conexao) throws SQLException{		
		String sql = "INSERT INTO CLIENTE VALUES(?, ?, ?)";			
		PreparedStatement comandoSQL = conexao.prepareStatement(sql);
		
		comandoSQL.setString(1, "123456");
		comandoSQL.setString(2, "nome");
		comandoSQL.setString(3, "endereco");
		
		return comandoSQL;		
	}
	
	public ResultSet contadorLinhas(Connection conexao) throws SQLException{		
		String verificaInsercao = "SELECT COUNT (TELEFONE) FROM CLIENTE;";
		
		ResultSet comandoSQL = conexao.prepareStatement(verificaInsercao).executeQuery();
		
		return comandoSQL;
	}
	
	
	
	
}
