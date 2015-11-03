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
	private List<Produto> produtos;
}
