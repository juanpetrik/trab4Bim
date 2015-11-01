package br.sgm.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoMysql {
	public Connection conn;
	public static ConexaoMysql conexao;

	// Construtor padrão.. Privado pois está implementando o padrão de projeto singleton
	// Como não teho a necessidade de ter mais de uma conexão com o banco, foi adotado esse padrão..
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

	// Método que vai retornar a conexão, caso ela não exista, será criada...
	public static ConexaoMysql getConexaoBD() {
		if (conexao == null) {
			conexao = new ConexaoMysql();
		}

		return conexao;
	}
}
