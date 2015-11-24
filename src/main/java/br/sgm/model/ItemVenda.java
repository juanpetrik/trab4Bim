package br.sgm.model;

import java.math.BigDecimal;

import br.sgm.enums.Categoria;
import br.sgm.enums.Unidade;

public class ItemVenda {

	private int idSeq;
	private int id;
	private String codBarras;
	private Categoria categoria;
	private String descricao;
	private Unidade unidade;
	private BigDecimal custo;
	private BigDecimal margemLucro;
	private int qtde;
	private BigDecimal vlrUnit;
	private BigDecimal subTotal;

	public BigDecimal getVlrUnit() {
		return vlrUnit;
	}

	public void setVlrUnit(BigDecimal vlrUnit) {
		this.vlrUnit = vlrUnit;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public int getIdSeq() {
		return idSeq;
	}

	public void setIdSeq(int idSeq) {
		this.idSeq = idSeq;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public BigDecimal getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(BigDecimal margemLucro) {
		this.margemLucro = margemLucro;
	}

}
