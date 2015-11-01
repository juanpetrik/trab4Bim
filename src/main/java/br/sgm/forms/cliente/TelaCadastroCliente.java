package br.sgm.forms.cliente;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import br.sgm.forms.MolduraAbstrata;

public class TelaCadastroCliente extends MolduraAbstrata{
	
	private static final long serialVersionUID = 1L;

	private static Runnable acao;
	
	public TelaCadastroCliente() {
		super();
	}

	public TelaCadastroCliente(Runnable acao) {
		this.acao = acao;
	}

	@Override
	protected void configurarCentro() {
		CadastroCliente cadastroCliente = new CadastroCliente();
		super.add(cadastroCliente, BorderLayout.CENTER);
		
		super.setAcaoSalvar(cadastroCliente.getAcaoSalvar());
		super.setAcaoFechar(acao);
		super.setAcaoExcluir(cadastroCliente.getAcaoExcluir());
	}
}
