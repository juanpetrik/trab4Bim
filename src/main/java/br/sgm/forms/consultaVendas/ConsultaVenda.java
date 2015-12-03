package br.sgm.forms.consultaVendas;

import java.awt.BorderLayout;

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
	
	/**
	 * Create the panel.
	 */
	public ConsultaVenda() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		tableVendas = new JTable();
		scrollPane.setViewportView(tableVendas);

		// $hide>>$
	    atualizarTabela();
		// $hide<<$
	}

	protected void atualizarTabela() {
		model.list = dao.listar(new Venda());

		tableVendas.setModel(model);
		model.fireTableDataChanged();
	}
	

}
