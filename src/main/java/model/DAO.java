package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {
	/*
	 * teste de conexao public void testeConexao() {
	 * 
	 * try { Connection conn = conectar(); System.out.println(conn); conn.close();
	 * 
	 * } catch (Exception e) { System.err.println(e); } }
	 */
	// Modulo de conexao:
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "1234";

	// Metodo de conexão:
	private Connection conectar() {
		Connection con = null;

		try {
			// Vai ler o driver do banco de dados que baixamos
			Class.forName(driver);

			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/* Crud Create */
	public void inserirContato(JavaBeans contato) {
		String sql = "INSERT INTO contatos(nome, fone, email) values(?,?,?)";

		try {
			Connection con = conectar();
			PreparedStatement pstm = con.prepareStatement(sql);

			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getFone());
			pstm.setString(3, contato.getEmail());

			pstm.execute();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
