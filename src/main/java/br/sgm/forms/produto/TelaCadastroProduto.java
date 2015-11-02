package br.sgm.forms.produto;

import java.awt.BorderLayout;

import br.sgm.forms.MolduraAbstrata;

public class TelaCadastroProduto extends MolduraAbstrata{
	
	private static final long serialVersionUID = 1L;

	public TelaCadastroProduto() {
		super();
	}

	@Override
	protected void configurarCentro() {
		CadastroProduto cadastroProduto = new CadastroProduto();
		super.add(cadastroProduto, BorderLayout.CENTER);
		
		super.setAcaoSalvar(cadastroProduto.getAcaoSalvar());
		super.setAcaoFechar(cadastroProduto.getAcaoFechar());
		super.setAcaoExcluir(cadastroProduto.getAcaoExcluir());
	}
}
