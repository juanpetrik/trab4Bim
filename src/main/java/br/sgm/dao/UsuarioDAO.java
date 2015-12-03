package br.sgm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.sgm.conexao.ConexaoMysql;
import br.sgm.model.Usuario;

public class UsuarioDAO implements DAO <Usuario>{

	private static final String SQL_INSERIRALTERAR = "INSERT INTO usuarios (id, idCliente, senha) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE idCliente = ?, senha = ?  ";
	private static final String SQL_DELETAR = "delete from usuarios where id = ?";
	private static final String SQL_LISTAR = "select * from usuarios";
	private static final String SQL_CONSULTAR = "select * from usuarios where id = ";

	private Connection conn = ConexaoMysql.getConexaoBD();

	@Override
	public void inserir(Usuario obj) {
		// Usar o inserirAlterar
	}

	@Override
	public void deletar(Usuario obj) {
		try {
			PreparedStatement ps = conn.prepareStatement(SQL_DELETAR);
			ps.setInt(1, obj.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Usuario obj) {
		// Usar o inserirAlterar
	}

	@Override
	public <T> List<T> listar(T obj) {
		List<T> list = new ArrayList<T>();

		Statement st;
		try {
			st = (Statement) conn.createStatement();

			ResultSet rs = st.executeQuery(SQL_LISTAR);
			while (rs.next()) {
				Usuario p = new Usuario();

				p.setId(rs.getInt(1));
				p.setIdCliente(rs.getInt(2));
				p.setSenha(rs.getString(3));

				list.add((T) p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public <T> T consultar(T obj) {
		Usuario newUsuario = (Usuario) obj;

		Statement st;
		Usuario u = new Usuario();

		try {
			st = (Statement) conn.createStatement();

			ResultSet rs = st.executeQuery(SQL_CONSULTAR + newUsuario.getId());
			if (rs.first()) {

				u.setId(rs.getInt(1));
				u.setIdCliente(rs.getInt(2));
				u.setSenha(rs.getString(3));

				return (T) u;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void inseriralterar(Usuario obj) {
		try {
			PreparedStatement ps = conn.prepareStatement(SQL_INSERIRALTERAR);
			ps.setInt(1, obj.getId());
			ps.setInt(2, obj.getIdCliente());
			ps.setString(3, obj.getSenha());
			ps.setInt(4, obj.getIdCliente());
			ps.setString(5, obj.getSenha());
			
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
