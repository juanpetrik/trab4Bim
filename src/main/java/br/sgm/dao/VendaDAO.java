package br.sgm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Statement;

import br.sgm.conexao.ConexaoMysql;
import br.sgm.enums.Categoria;
import br.sgm.enums.Unidade;
import br.sgm.model.ItemVenda;
import br.sgm.model.Venda;

public class VendaDAO implements DAO<Venda> {

	private static final String SQL_INSERIRALTERAR_CAPA = "INSERT INTO vendas (id, idCliente, nomeCliente, vlrTotalVenda, dtLancamento, hrLancamento) VALUES (?, ?, ?, ?, ?, ?) on duplicate key update idCliente = ?, nomeCliente = ?, vlrTotalVenda = ?, dtLancamento = ?, hrLancamento = ?";
	private static final String SQL_INSERIRALTERAR_ITEM = "INSERT INTO itensvendas (id, idSeq, idVenda, codBarras, descricao, categoria, unidade, custo, margemLucro, qtde, vlrUnit, subTotal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE idSeq = ?, idVenda = ?, codBarras = ?, descricao = ?, categoria = ?, unidade = ?, custo = ?, margemLucro = ?, qtde = ?, vlrUnit = ?, subTotal = ?)    ";
	private static final String SQL_DELETAR = "delete from clientes where id = ?";
	private static final String SQL_LISTAR_CAPA = "select * from vendas";
	private static final String SQL_CONSULTAR_CAPA = "select * from vendas where id = ";
	private static final String SQL_CONSULTAR_ITEM = "select * from itensvendas where idVenda = ";

	private Connection conn = ConexaoMysql.getConexaoBD();

	@Override
	public void inserir(Venda obj) {
		// Usar o inserirAlterar
	}

	@Override
	public void deletar(Venda venda) {
		try {
			PreparedStatement ps = conn.prepareStatement(SQL_DELETAR);
			ps.setInt(1, venda.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Venda obj) {
		// Usar o inserirAlterar
	}

	@Override
	public <T> List<T> listar(T obj) {
		List<T> list = new ArrayList<T>();

		Statement st;
		try {
			st = (Statement) conn.createStatement();

			ResultSet rs = st.executeQuery(SQL_LISTAR_CAPA);
			while (rs.next()) {
				Venda v = new Venda();
				v.setId(rs.getInt(1));
				v.setIdCliente(rs.getInt(2));
				v.setNomeCliente(rs.getString(3));
				v.setVlrTotal(rs.getBigDecimal(4));
				v.setData(rs.getDate(5));
				v.setHora(rs.getLong(6));

				st = (Statement) conn.createStatement();

				Map<Integer, ItemVenda> listItens = new HashMap<Integer, ItemVenda>();

				ResultSet rs2 = st.executeQuery(SQL_CONSULTAR_ITEM + v.getId());
				while (rs2.next()) {
					ItemVenda item = new ItemVenda();

					item.setId(rs2.getInt(1));
					item.setIdSeq(rs2.getInt(2));
					item.setCodBarras(rs2.getString(4));
					item.setDescricao(rs2.getString(5));

					for (Categoria categoria : Categoria.values())
						if (categoria.getNome().equals(rs.getString(6)))
							item.setCategoria(categoria);

					item.setCusto(rs2.getBigDecimal(7));
					item.setMargemLucro(rs2.getBigDecimal(8));

					for (Unidade unidade : Unidade.values())
						if (unidade.getNome().equals(rs.getString(9)))
							item.setUnidade(unidade);

					item.setVlrUnit(rs2.getBigDecimal(10));
					item.setQtde(rs2.getInt(11));
					item.setSubTotal(rs2.getBigDecimal(12));
				}

				v.setProdutos(listItens);

				list.add((T) v);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public <T> T consultar(T obj) {
		Venda newVenda = (Venda) obj;

		Statement st;
		Venda v = new Venda();

		try {
			st = (Statement) conn.createStatement();

			ResultSet rs = st.executeQuery(SQL_CONSULTAR_CAPA + newVenda.getId());
			if (rs.first()) {

				v.setId(rs.getInt(1));
				v.setIdCliente(rs.getInt(2));
				v.setNomeCliente(rs.getString(3));
				v.setVlrTotal(rs.getBigDecimal(4));
				v.setData(rs.getDate(5));
				v.setHora(rs.getLong(6));

				st = (Statement) conn.createStatement();

				Map<Integer, ItemVenda> listItens = new HashMap<Integer, ItemVenda>();

				ResultSet rs2 = st.executeQuery(SQL_CONSULTAR_ITEM + v.getId());
				while (rs2.next()) {
					ItemVenda item = new ItemVenda();

					item.setId(rs2.getInt(1));
					item.setIdSeq(rs2.getInt(2));
					item.setCodBarras(rs2.getString(4));
					item.setDescricao(rs2.getString(5));

					for (Categoria categoria : Categoria.values())
						if (categoria.getNome().equals(rs.getString(6)))
							item.setCategoria(categoria);

					item.setCusto(rs2.getBigDecimal(7));
					item.setMargemLucro(rs2.getBigDecimal(8));

					for (Unidade unidade : Unidade.values())
						if (unidade.getNome().equals(rs.getString(9)))
							item.setUnidade(unidade);

					item.setVlrUnit(rs2.getBigDecimal(10));
					item.setQtde(rs2.getInt(11));
					item.setSubTotal(rs2.getBigDecimal(12));
				}

				v.setProdutos(listItens);

				return (T) v;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void inseriralterar(Venda obj) {
		try {
			PreparedStatement ps = conn.prepareStatement(SQL_INSERIRALTERAR_CAPA);

			// Inserindo a capa da venda....
			ps.setInt(1, obj.getId());
			ps.setInt(2, obj.getIdCliente());
			ps.setString(3, obj.getNomeCliente());
			ps.setBigDecimal(4, obj.getVlrTotal());
			ps.setDate(5, new java.sql.Date(obj.getData().getTime()));
			ps.setTime(6, new java.sql.Time(obj.getHoraL()));
			ps.setInt(7, obj.getIdCliente());
			ps.setString(8, obj.getNomeCliente());
			ps.setBigDecimal(9, obj.getVlrTotal());
			ps.setDate(10, new java.sql.Date(obj.getData().getTime()));
			ps.setTime(11, new java.sql.Time(obj.getHoraL()));
			ps.executeUpdate();

			// Vamos inserir os itens da venda.
			for (int i = 1; i < obj.getProdutos().size(); i++) {
				ItemVenda item = new ItemVenda();
				item = obj.getProdutos().get(i);

				ps = conn.prepareStatement(SQL_INSERIRALTERAR_ITEM);

				ps.setInt(1, item.getId());
				ps.setInt(2, item.getIdSeq());
				ps.setInt(3, obj.getId());
				ps.setString(4, item.getCodBarras());
				ps.setString(5, item.getDescricao());
				ps.setString(6, item.getCategoria().getNome());
				ps.setString(7, item.getUnidade().getNome());
				ps.setBigDecimal(8, item.getCusto());
				ps.setBigDecimal(9, item.getMargemLucro());
				ps.setInt(10, item.getQtde());
				ps.setBigDecimal(11, item.getVlrUnit());
				ps.setBigDecimal(12, item.getSubTotal());
				ps.setInt(13, item.getIdSeq());
				ps.setInt(14, obj.getId());
				ps.setString(15, item.getCodBarras());
				ps.setString(16, item.getDescricao());
				ps.setString(17, item.getCategoria().getNome());
				ps.setString(18, item.getUnidade().getNome());
				ps.setBigDecimal(19, item.getCusto());
				ps.setBigDecimal(20, item.getMargemLucro());
				ps.setInt(21, item.getQtde());
				ps.setBigDecimal(22, item.getVlrUnit());
				ps.setBigDecimal(23, item.getSubTotal());
				ps.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setConexao(Connection conn) {
		this.conn = conn;
	}

	public int getNextID() {
		Statement st;

		try {
			st = (Statement) conn.createStatement();

			ResultSet rs = st.executeQuery("Select * from vendas order by id desc");
			if (rs.first()) {
				return rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 1;
	}
}