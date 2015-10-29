package br.sgm.forms.cliente;

import java.awt.BorderLayout;

import br.sgm.forms.MolduraAbstrata;

public class TelaCadastroCliente extends MolduraAbstrata{
	/**
	 * Create the panel.
	 */
	public TelaCadastroCliente() {
		super();
	}

	@Override
	protected void configurarCentro() {
		super.add(new CadastroCliente(), BorderLayout.CENTER);
	}
}
