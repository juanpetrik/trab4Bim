package br.sgm.forms.relatorioVenda;

import java.awt.BorderLayout;

import br.sgm.forms.MolduraAbstrata;
import br.sgm.forms.MolduraAbstrataRelatorio;

public class TelaRelatorioVenda extends MolduraAbstrataRelatorio{
	
	private static final long serialVersionUID = 1L;

	public TelaRelatorioVenda() {
		super();
	}

	@Override
	protected void configurarCentro() {
		RelatorioVenda relatorioVenda = new RelatorioVenda();
		super.add(relatorioVenda, BorderLayout.CENTER);
		super.setAcaoSalvar(relatorioVenda.getAcaoSalvar());
	}
}
