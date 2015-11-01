package br.sgm.forms;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class MolduraAbstrata extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	private JButton btnFechar;
	private JButton btnSalvar;
	private JButton btnExcluir;

	protected abstract void configurarCentro();

	/*
	 * public void setFecharAction(ActionListener action){
	 * btnFechar.addActionListener(action); }
	 * 
	 * public void setSalvarAction(ActionListener action){
	 * btnSalvar.addActionListener(action); }
	 * 
	 * public void setExcluirAction(ActionListener action){
	 * btnExcluir.addActionListener(action); }
	 */

	/**
	 * Create the panel.
	 */
	public MolduraAbstrata() {
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		btnExcluir = new JButton("Excluir");
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 0, 5);
		gbc_btnExcluir.anchor = GridBagConstraints.EAST;
		gbc_btnExcluir.gridx = 0;
		gbc_btnExcluir.gridy = 0;
		panel.add(btnExcluir, gbc_btnExcluir);

		btnSalvar = new JButton("Salvar");
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.anchor = GridBagConstraints.EAST;
		gbc_btnSalvar.gridx = 1;
		gbc_btnSalvar.gridy = 0;
		panel.add(btnSalvar, gbc_btnSalvar);

		btnFechar = new JButton("Fechar");
		GridBagConstraints gbc_btnFechar = new GridBagConstraints();
		gbc_btnFechar.fill = GridBagConstraints.VERTICAL;
		gbc_btnFechar.anchor = GridBagConstraints.EAST;
		gbc_btnFechar.gridx = 2;
		gbc_btnFechar.gridy = 0;
		panel.add(btnFechar, gbc_btnFechar);

		configurarCentro();

	}

	public void setAcaoSalvar(Runnable acao) {
		btnSalvar.addActionListener(e -> acao.run());
	}

	public void setAcaoExcluir(Runnable acao) {
		btnExcluir.addActionListener(e -> acao.run());
	}
	
	public void setAcaoFechar(Runnable acao) {
		btnFechar.addActionListener(e -> acao.run());
	}
}
