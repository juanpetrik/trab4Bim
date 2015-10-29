package br.sgm.forms.usuario;

import java.awt.BorderLayout;

import br.sgm.forms.MolduraAbstrata;

public class TeclaCadastroUsuario extends MolduraAbstrata{

	public TeclaCadastroUsuario() {
		super();
	}
	
	@Override
	protected void configurarCentro() {
		super.add(new CadastroUsuario(), BorderLayout.CENTER);
	}

}
