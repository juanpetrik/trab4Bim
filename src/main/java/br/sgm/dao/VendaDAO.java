package br.sgm.dao;

import java.math.BigDecimal;
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

	private static final String SQL_INSERIRALTERAR = "INSERT INTO vendas (id, idCliente, nomeCliente, vlrTotalVenda, dtLancamento, hrLancamento) VALUES (?, ?, ?, ?, ?, ?) on duplicate key update  nomeCliente = ?, vlrTotalVenda = ?, dtLancamento = ?, hrLancamento = ?";
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
				v.setHora(rs.getTime(6));
				
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
				v.setHora(rs.getTime(6));
				
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
			PreparedStatement ps = conn.prepareStatement(SQL_INSERIRALTERAR);
			
			//id, idCliente, nomeCliente, vlrTotalVenda, dtLancamento, hrLancamento
			
			ps.setInt(1, obj.getId());
			ps.setInt(2, obj.getIdCliente());
			ps.setString(3, obj.getNomeCliente());
			ps.setBigDecimal(4, obj.getVlrTotal());
			ps.setDate(parameterIndex, x);
			
			
			
			
			ps.setInt(1, obj.getId());
			ps.setString(2, obj.getNome());
			ps.setString(3, obj.getTelefone());
			ps.setString(4, obj.getEndereco());
			ps.setString(5, obj.getCidade());
			ps.setString(6, obj.getUf().getNome());
			ps.setString(7, obj.getEmail());
			ps.setString(8, obj.getGenero().getNome());
			ps.setString(9, obj.getNome());
			ps.setString(10, obj.getTelefone());
			ps.setString(11, obj.getEndereco());
			ps.setString(12, obj.getCidade());
			ps.setString(13, obj.getUf().toString());
			ps.setString(14, obj.getEmail());
			ps.setString(15, obj.getGenero().getNome().toString());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setConexao(Connection conn) {
		// TODO Auto-generated method stub

	}
}