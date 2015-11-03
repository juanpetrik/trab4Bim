package br.sgm.forms.relatorioProduto;

import java.awt.BorderLayout;

import br.sgm.forms.MolduraAbstrata;
import br.sgm.forms.MolduraAbstrataRelatorio;

public class TelaRelatorioProduto extends MolduraAbstrataRelatorio{
	
	private static final long serialVersionUID = 1L;

	public TelaRelatorioProduto() {
		super();
	}

	@Override
	protected void configurarCentro() {
		RelatorioProduto relatorioProduto = new RelatorioProduto();
		super.add(relatorioProduto, BorderLayout.CENTER);
		super.setAcaoSalvar(relatorioProduto.getAcaoSalvar());
	}
}
