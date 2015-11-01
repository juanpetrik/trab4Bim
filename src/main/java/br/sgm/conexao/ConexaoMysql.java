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

	// Construtor padr�o.. Privado pois est� implementando o padr�o de projeto singleton
	// Como n�o teho a necessidade de ter mais de uma conex�o com o banco, foi adotado esse padr�o..
	private ConexaoMysql() {
		url = "jdbc:mysql://localhost:3306/";
		dbName = "trab4bimoo";
		driver = "com.mysql.jdbc.Driver";
		userName = "root";
		password = "";
		try {
			Class.forName(driver).newInstance();
			this.conn = DriverManager.getConnection(url + dbName, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// M�todo que vai retornar a conex�o, caso ela n�o exista, ser� criada...
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
