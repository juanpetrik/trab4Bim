package br.sgm.forms.usuario;

import java.awt.BorderLayout;

import br.sgm.forms.MolduraAbstrata;

public class TelaCadastroUsuario extends MolduraAbstrata{
	
	private static final long serialVersionUID = 1L;

	public TelaCadastroUsuario() {
		super();
	}

	@Override
	protected void configurarCentro() {
		CadastroUsuario cadastroCliente = new CadastroUsuario();
		super.add(cadastroCliente, BorderLayout.CENTER);
		
		super.setAcaoSalvar(cadastroCliente.getAcaoSalvar());
		super.setAcaoFechar(cadastroCliente.getAcaoFechar());
		super.setAcaoExcluir(cadastroCliente.getAcaoExcluir());
	}
}
