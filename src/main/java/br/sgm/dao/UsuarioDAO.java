package br.sgm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.sgm.conexao.ConexaoMysql;
import br.sgm.enums.Categoria;
import br.sgm.enums.Genero;
import br.sgm.enums.UF;
import br.sgm.enums.Unidade;
import br.sgm.model.Cliente;
import br.sgm.model.Usuario;

import com.mysql.jdbc.Statement;

public class UsuarioDAO extends DAO {

	private static final String SQL_INSERIRALTERAR = "INSERT INTO usuarios (id, idCliente, senha) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE idCliente = ?, senha = ?  ";
	private static final String SQL_DELETAR = "delete from usuarios where id = ?";
	private static final String SQL_LISTAR = "select * from usuarios";
	private static final String SQL_CONSULTAR = "select * from usuarios where id = ";

	private Connection conn = ConexaoMysql.getConexaoBD();

	@Override
	public void inserir(Object usuario) {
		// Usar o inserirAlterar
	}

	@Override
	public void deletar(Object usuario) {
		Usuario p = (Usuario) usuario;

		try {
			PreparedStatement ps = conn.prepareStatement(SQL_DELETAR);
			ps.setInt(1, p.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Object usuario) {

	}

	@Override
	public <T> List<T> listar(Object usuario) {
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
	public <T> T consultar(Object usuario) {
		Usuario newUsuario = (Usuario) usuario;

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
	public void inseriralterar(Object usuario) {
		Usuario u = (Usuario) usuario;

		try {
			PreparedStatement ps = conn.prepareStatement(SQL_INSERIRALTERAR);
			ps.setInt(1, u.getId());
			ps.setInt(2, u.getIdCliente());
			ps.setString(3, u.getSenha());
			ps.setInt(4, u.getIdCliente());
			ps.setString(5, u.getSenha());
			
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
