package br.sgm.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoMysql {
	public Connection conn;
	public static ConexaoMysql conexao;

	// Construtor padr�o.. Privado pois est� implementando o padr�o de projeto singleton
	// Como n�o teho a necessidade de ter mais de uma conex�o com o banco, foi adotado esse padr�o..
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

	// M�todo que vai retornar a conex�o, caso ela n�o exista, ser� criada...
	public static ConexaoMysql getConexaoBD() {
		if (conexao == null) {
			conexao = new ConexaoMysql();
		}

		return conexao;
	}
}
