package br.sgm.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class Venda {
	private int id;
	private int idCliente;
	private String nomeCliente;
	private Date data;
	private BigDecimal vlrTotal;
	private BigDecimal vlrTroco;
	private List<ItemVenda> produtos;
	
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
	
	public BigDecimal getVlrTroco() {
		return vlrTroco;
	}
	
	public void setVlrTroco(BigDecimal vlrTroco) {
		this.vlrTroco = vlrTroco;
	}
	
	public List<ItemVenda> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List<ItemVenda> produtos) {
		this.produtos = produtos;
	}
}
