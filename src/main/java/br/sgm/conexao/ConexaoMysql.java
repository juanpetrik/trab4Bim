package br.sgm.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoMysql {
	public static Connection conn;
	// public static ConexaoMysql conexao;
	private static String url;
	private static String dbName;
	private static String driver;
	private static String userName;
	private static String password;

	// Construtor padrão.. Privado pois está implementando o padrão de projeto singleton
	// Como não teho a necessidade de ter mais de uma conexão com o banco, foi adotado esse padrão..
	private ConexaoMysql() {
		url = "jdbc:mysql://localhost:3306/";
		dbName = "trab4bimoo";
		driver = "com.mysql.jdbc.Driver";
		userName = "root";
		password = "root";
		try {
			Class.forName(driver).newInstance();
			this.conn = DriverManager.getConnection(url + dbName, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Método que vai retornar a conexão, caso ela não exista, será criada...
	public static Connection getConexaoBD() {
		if (conn == null) {
			new ConexaoMysql();
		}

		return conn;
	}

	public static void setBancoDados(String banco) {
		conn = null;
		dbName = banco;
		getConexaoBD();
	}
}
