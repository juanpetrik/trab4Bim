package br.sgm.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoMysql {
	public Connection conn;
	public static ConexaoMysql conexao;

	private ConexaoMysql() {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "trab4BimOO";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";
		try {
			Class.forName(driver).newInstance();
			this.conn = (Connection) DriverManager.getConnection(url + dbName, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ConexaoMysql getConexaoBD() {
		if (conexao == null) {
			conexao = new ConexaoMysql();
		}

		return conexao;
	}
}
