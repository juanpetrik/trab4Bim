package br.sgm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.sgm.conexao.ConexaoMysql;
import br.sgm.model.Cliente;


public class ClienteDAO extends DAO{

	private static final String SQL_INSERIRALTERAR = "INSERT INTO clientes (id, nome, telefone, endereco, cidade, estado, email, genero) VALUES(?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE nome = ?, telefone = ?, endereco = ?, cidade = ?, estado = ?, email = ?, genero = ?;";

	private Connection conn = ConexaoMysql.getConexaoBD();
	
	@Override
	public void inserir(Object cliente) {
		Cliente c = (Cliente) cliente;
		
	}

	@Override
	public void deletar(Object cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Object cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> List<T> listar(Object cliente) {
		// TODO Auto-generated method stub
		return null;
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
			ps.setString(13, c.getUf().getNome());
			ps.setString(14, c.getEmail());
			ps.setString(15, c.getGenero().getNome());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
