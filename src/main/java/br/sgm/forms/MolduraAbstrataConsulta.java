package br.sgm.forms;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class MolduraAbstrataConsulta extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	private JButton btnFechar;

	protected abstract void configurarCentro();

	public void setFechar(ActionListener action){
		btnFechar.addActionListener(action);
	}
	
	/**
	 * Create the panel.
	 */
	public MolduraAbstrataConsulta() {
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

		btnFechar = new JButton("Fechar");
		btnFechar.setIcon(new ImageIcon(getClass().getResource("/icons/fechar.png")));
		GridBagConstraints gbc_btnFechar = new GridBagConstraints();
		gbc_btnFechar.fill = GridBagConstraints.VERTICAL;
		gbc_btnFechar.anchor = GridBagConstraints.EAST;
		gbc_btnFechar.gridx = 2;
		gbc_btnFechar.gridy = 0;
		panel.add(btnFechar, gbc_btnFechar);

		configurarCentro();

	}

	public void setAcaoFechar(ActionListener acao) {
		btnFechar.addActionListener(acao);
	}
}
