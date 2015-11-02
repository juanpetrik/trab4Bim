package br.sgm.forms.venda;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class TelaVenda extends JPanel {
	private JTextField txtNomeCliente;
	private JTable tableProdutos;

	/**
	 * Create the panel.
	 */
	public TelaVenda() {
		super();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{68, 98, 89, 89, 20, 60, 0};
		gridBagLayout.rowHeights = new int[]{20, 20, 23, 254, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblIDCliente = new JLabel("ID Cliente");
		GridBagConstraints gbc_lblIDCliente = new GridBagConstraints();
		gbc_lblIDCliente.anchor = GridBagConstraints.EAST;
		gbc_lblIDCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblIDCliente.gridx = 0;
		gbc_lblIDCliente.gridy = 0;
		add(lblIDCliente, gbc_lblIDCliente);
		
		JComboBox cbIDCliente = new JComboBox();
		GridBagConstraints gbc_cbIDCliente = new GridBagConstraints();
		gbc_cbIDCliente.anchor = GridBagConstraints.NORTH;
		gbc_cbIDCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbIDCliente.insets = new Insets(0, 0, 5, 5);
		gbc_cbIDCliente.gridx = 1;
		gbc_cbIDCliente.gridy = 0;
		add(cbIDCliente, gbc_cbIDCliente);
		
		JLabel lblNomeCliente = new JLabel("Nome Cliente");
		GridBagConstraints gbc_lblNomeCliente = new GridBagConstraints();
		gbc_lblNomeCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNomeCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeCliente.gridx = 0;
		gbc_lblNomeCliente.gridy = 1;
		add(lblNomeCliente, gbc_lblNomeCliente);
		
		txtNomeCliente = new JTextField();
		GridBagConstraints gbc_txtNomeCliente = new GridBagConstraints();
		gbc_txtNomeCliente.anchor = GridBagConstraints.NORTH;
		gbc_txtNomeCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNomeCliente.insets = new Insets(0, 0, 5, 0);
		gbc_txtNomeCliente.gridwidth = 5;
		gbc_txtNomeCliente.gridx = 1;
		gbc_txtNomeCliente.gridy = 1;
		add(txtNomeCliente, gbc_txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		JLabel lblProduto = new JLabel("Produto");
		GridBagConstraints gbc_lblProduto = new GridBagConstraints();
		gbc_lblProduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblProduto.gridx = 0;
		gbc_lblProduto.gridy = 2;
		add(lblProduto, gbc_lblProduto);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		add(comboBox, gbc_comboBox);
		
		JButton btnNewButton_2 = new JButton("Add");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 5;
		gbc_btnNewButton_2.gridy = 2;
		add(btnNewButton_2, gbc_btnNewButton_2);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 6;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		tableProdutos = new JTable();
		scrollPane.setViewportView(tableProdutos);
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.NORTH;
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 4;
		add(btnCancelar, gbc_btnCancelar);
		
		JButton btnNewButton_1 = new JButton("Finalizar");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 4;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton = new JButton("Fechar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 4;
		add(btnNewButton, gbc_btnNewButton);
	}
}
