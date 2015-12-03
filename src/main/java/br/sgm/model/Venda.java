package br.sgm.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.jfree.data.time.Hour;

public class Venda {
	private int id;
	private int idCliente;
	private String nomeCliente;
	private Date data;
	private Hour hora;
	private BigDecimal vlrTotal;
	private Map<Integer, ItemVenda> produtos;

	public Hour getHora() {
		return hora;
	}

	public void setHora(Hour hora) {
		this.hora = hora;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(BigDecimal vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

	public Map<Integer, ItemVenda> getProdutos() {
		return produtos;
	}

	public void setProdutos(Map<Integer, ItemVenda> list) {
		this.produtos = list;
	}
}
