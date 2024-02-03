package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	//Modulo de conexao:
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "1234";
	
	//Metodo de conexão:
	private Connection conectar() {
		Connection con = null;
		
		try {
			//Vai ler o driver do banco de dados que baixamos
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/*teste de conexao
	public void testeConexao() {
		
		try {
			Connection conn = conectar();
			System.out.println(conn);
			conn.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}
	}*/
}
