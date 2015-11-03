package br.sgm.forms.cliente;

import java.awt.BorderLayout;

import br.sgm.forms.MolduraAbstrata;

public class TelaCadastroCliente extends MolduraAbstrata{
	
	private static final long serialVersionUID = 1L;

	public TelaCadastroCliente() {
		super();
	}

	@Override
	protected void configurarCentro() {
		CadastroCliente cadastroCliente = new CadastroCliente();
		super.add(cadastroCliente, BorderLayout.CENTER);
		
		super.setAcaoSalvar(cadastroCliente.getAcaoSalvar());
		super.setAcaoExcluir(cadastroCliente.getAcaoExcluir());
	}
}
