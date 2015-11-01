package br.sgm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.sgm.conexao.ConexaoMysql;
import br.sgm.model.Cliente;

import com.mysql.jdbc.Statement;

public class ClienteDAO extends DAO {

	private static final String SQL_INSERIRALTERAR = "insert into clientes (id, nome, telefone, endereco, cidade, estado, email, genero) VALUES(?, ?, ?, ?, ?, ?, ?, ?) on duplicate key update nome = ?, telefone = ?, endereco = ?, cidade = ?, estado = ?, email = ?, genero = ?;";
	private static final String SQL_DELETAR = "delete from clientes where id = ?";
	private static final String SQL_LISTAR = "select * from clientes";

	private Connection conn = ConexaoMysql.getConexaoBD();

	@Override
	public void inserir(Object cliente) {

	}

	@Override
	public void deletar(Object cliente) {
		Cliente c = (Cliente) cliente;

		try {
			PreparedStatement ps = conn.prepareStatement(SQL_DELETAR);
			ps.setInt(1, c.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Object cliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> List<T> listar(Object cliente) {
		List<T> list = new ArrayList<T>();

		Statement st;
		try {
			st = (Statement) conn.createStatement();

			ResultSet rs = st.executeQuery(SQL_LISTAR);
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getInt(1));
				c.setNome(rs.getString(2));
				c.setTelefone(rs.getString(3));
				c.setEndereco(rs.getString(4));
				c.setCidade(rs.getString(5));
				//c.setUf(rs.getString(6));
				c.setEmail(rs.getString(7));
				//c.setGenero(rs.getString(8));
				list.add((T) c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public <T> T consultar(Object cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inseriralterar(Object cliente) {
		Cliente c = (Cliente) cliente;

		try {
			PreparedStatement ps = conn.prepareStatement(SQL_INSERIRALTERAR);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getNome());
			ps.setString(3, c.getTelefone());
			ps.setString(4, c.getEndereco());
			ps.setString(5, c.getCidade());
			ps.setString(6, c.getUf().getNome());
			ps.setString(7, c.getEmail());
			ps.setString(8, c.getGenero().getNome());
			ps.setString(9, c.getNome());
			ps.setString(10, c.getTelefone());
			ps.setString(11, c.getEndereco());
			ps.setString(12, c.getCidade());
			ps.setString(13, c.getUf().toString());
			ps.setString(14, c.getEmail());
			ps.setString(15, c.getGenero().getNome().toString());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setConexao(Connection conn) {
		this.conn = conn;
	}
}
