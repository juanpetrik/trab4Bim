package br.sgm.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModelCliente extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<Cliente> list;

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Cliente c = list.get(row);

		switch (col) {
		case 0:
			c.getId();
			break;
		case 1:
			c.getNome();
			break;
		case 2:
			c.getTelefone();
			break;
		case 3:
			c.getEndereco();
			break;
		case 4:
			c.getCidade();
			break;
		case 5:
			c.getUf().getNome();
			break;
		case 6:
			c.getEmail();
			break;
		case 7:
			c.getGenero().getNome();
			break;
		}

		return null;
	}
}
