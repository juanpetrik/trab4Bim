package br.sgm.forms.produto;

import java.awt.BorderLayout;

import br.sgm.forms.MolduraAbstrata;
import br.sgm.forms.usuario.CadastroUsuario;

public class TelaCadastroProduto extends MolduraAbstrata {

	public TelaCadastroProduto() {
		super();
	}

	@Override
	protected void configurarCentro() {
		super.add(new CadastroProduto(), BorderLayout.CENTER);
	}

}
