package br.sgm.forms.consultaVendas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.sgm.dao.VendaDAO;
import br.sgm.model.ModelVenda;
import br.sgm.model.Venda;

public class ConsultaVenda extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5649351078175533738L;
	private ModelVenda model = new ModelVenda();
	private VendaDAO dao = new VendaDAO();
	private JTable tableVendas;
	private JButton btnFechar;
	
	/**
	 * Create the panel.
	 */
	public ConsultaVenda() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{725, 0};
		gridBagLayout.rowHeights = new int[]{416, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		tableVendas = new JTable();
		scrollPane.setViewportView(tableVendas);
		
		btnFechar = new JButton("Fechar");
		btnFechar.setIcon(new ImageIcon(getClass().getResource("/icons/fechar.png")));
		GridBagConstraints gbc_btnFechar = new GridBagConstraints();
		gbc_btnFechar.anchor = GridBagConstraints.EAST;
		gbc_btnFechar.gridx = 0;
		gbc_btnFechar.gridy = 1;
		add(btnFechar, gbc_btnFechar);

		// $hide>>$
	    atualizarTabela();
		// $hide<<$
	}

	protected void atualizarTabela() {
		model.list = dao.listar(new Venda());

		tableVendas.setModel(model);
		model.fireTableDataChanged();
	}

	public void setAcaoFechar(ActionListener action) {
		btnFechar.addActionListener(action);
	}
	

}
