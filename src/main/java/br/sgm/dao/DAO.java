package br.sgm.dao;

import java.sql.Connection;
import java.util.List;

// Classe abstrata, que ser� implementada pelos DAO's de cliente, produto e usuario...
public abstract class DAO {
	public abstract void inserir(Object obj);
	public abstract void deletar(Object obj);
	public abstract void alterar(Object obj);
	public abstract <T> List<T> listar(Object obj);
	public abstract <T> T consultar(Object obj);
	public abstract void inseriralterar(Object obj);
	public abstract void setConexao(Connection conn);
}
