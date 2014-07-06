package funcionais;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoTeste {
	
	public static Connection obterConexao(){		
		Connection conexao;
		
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			
			String url = "jdbc:postgresql://localhost:5432/pizzaTestes";
			String user = "postgres";
			String passwd = "postgres";
			
			conexao = DriverManager.getConnection(url, user, passwd);
			
			return conexao;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
