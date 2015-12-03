package br.sgm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.sgm.conexao.ConexaoMysql;
import br.sgm.enums.Categoria;
import br.sgm.enums.Unidade;
import br.sgm.model.Produto;

import com.mysql.jdbc.Statement;

public class ProdutoDAO implements DAO <Produto> {

	private static final String SQL_INSERIRALTERAR = "insert into produtos (id, codBarras, categoria, descricao, unidade, custo, margemLucro) values (?, ?, ?, ?, ?, ?, ?) on duplicate key update codBarras = ?, categoria = ?, descricao = ?, unidade = ?, custo = ?, margemLucro = ?";
	private static final String SQL_DELETAR = "delete from produtos where id = ?";
	private static final String SQL_LISTAR = "select * from produtos";
	private static final String SQL_CONSULTAR = "select * from produtos where id = ";

	private Connection conn = ConexaoMysql.getConexaoBD();

	@Override
	public void inserir(Produto obj) {
		// Usar o inserirAlterar
	}

	@Override
	public void deletar(Produto obj) {
		try {
			PreparedStatement ps = conn.prepareStatement(SQL_DELETAR);
			ps.setInt(1, obj.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Produto obj) {
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
				Produto p = new Produto();

				p.setId(rs.getInt(1));
				p.setCodBarras(rs.getString(2));

				for (Categoria categoria : Categoria.values())
					if (categoria.getNome().equals(rs.getString(3)))
						p.setCategoria(categoria);

				p.setDescricao(rs.getString(4));

				for (Unidade unidade : Unidade.values())
					if (unidade.getNome().equals(rs.getString(5)))
						p.setUnidade(unidade);

				p.setCusto(rs.getBigDecimal(6));
				p.setMargemLucro(rs.getBigDecimal(7));
				
				list.add((T) p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public <T> T consultar(T obj) {
		Produto newProduto = (Produto) obj;

		Statement st;
		Produto p = new Produto();

		try {
			st = (Statement) conn.createStatement();

			ResultSet rs = st.executeQuery(SQL_CONSULTAR + newProduto.getId());
			if (rs.first()) {

				p.setId(rs.getInt(1));
				p.setCodBarras(rs.getString(2));

				for (Categoria categoria : Categoria.values())
					if (categoria.getNome().equals(rs.getString(3)))
						p.setCategoria(categoria);

				p.setDescricao(rs.getString(4));

				for (Unidade unidade : Unidade.values())
					if (unidade.getNome().equals(rs.getString(5)))
						p.setUnidade(unidade);

				p.setCusto(rs.getBigDecimal(6));
				p.setMargemLucro(rs.getBigDecimal(7));
				
				return (T) p;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public <T> T consultarByCodBarras(Object produto) {
		Produto newProduto = (Produto) produto;

		Statement st;
		Produto p = new Produto();

		try {
			st = (Statement) conn.createStatement();

			ResultSet rs = st.executeQuery("select * from produtos where codBarras = " + newProduto.getCodBarras());
			if (rs.first()) {

				p.setId(rs.getInt(1));
				p.setCodBarras(rs.getString(2));

				for (Categoria categoria : Categoria.values())
					if (categoria.getNome().equals(rs.getString(3)))
						p.setCategoria(categoria);

				p.setDescricao(rs.getString(4));

				for (Unidade unidade : Unidade.values())
					if (unidade.getNome().equals(rs.getString(5)))
						p.setUnidade(unidade);

				p.setCusto(rs.getBigDecimal(6));
				p.setMargemLucro(rs.getBigDecimal(7));
				
				return (T) p;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public void inseriralterar(Produto obj) {
		try {
			PreparedStatement ps = conn.prepareStatement(SQL_INSERIRALTERAR);
			ps.setInt(1, obj.getId());
			ps.setString(2, obj.getCodBarras());
			ps.setString(3, obj.getCategoria().getNome());
			ps.setString(4, obj.getDescricao());
			ps.setString(5, obj.getUnidade().getNome());
			ps.setBigDecimal(6, obj.getCusto());
			ps.setBigDecimal(7, obj.getMargemLucro());
			ps.setString(8, obj.getCodBarras());
			ps.setString(9, obj.getCategoria().getNome());
			ps.setString(10, obj.getDescricao());
			ps.setString(11, obj.getUnidade().getNome());
			ps.setBigDecimal(12, obj.getCusto());
			ps.setBigDecimal(13, obj.getMargemLucro());
			
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
