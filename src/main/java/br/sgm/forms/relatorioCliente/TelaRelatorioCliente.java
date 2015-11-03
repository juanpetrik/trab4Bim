package br.sgm.forms.relatorioCliente;

import java.awt.BorderLayout;

import br.sgm.forms.MolduraAbstrata;
import br.sgm.forms.MolduraAbstrataRelatorio;

public class TelaRelatorioCliente extends MolduraAbstrataRelatorio{
	
	private static final long serialVersionUID = 1L;

	public TelaRelatorioCliente() {
		super();
	}

	@Override
	protected void configurarCentro() {
		RelatorioCliente relatorioCliente = new RelatorioCliente();
		super.add(relatorioCliente, BorderLayout.CENTER);
		super.setAcaoSalvar(relatorioCliente.getAcaoSalvar());
	}
}
