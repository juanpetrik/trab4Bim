package br.sgm.dao;

import java.sql.Connection;
import java.util.List;

// Interface, que será implementada pelos DAO's de cliente, produto e usuario...
public interface DAO <T>{
	public abstract void inserir(T obj);
	public abstract void deletar(T obj);
	public abstract void alterar(T obj);
	public abstract <T> List<T> listar(T obj);
	public abstract <T> T consultar(T obj);
	public abstract void inseriralterar(T obj);
	public abstract void setConexao(Connection conn);
}
