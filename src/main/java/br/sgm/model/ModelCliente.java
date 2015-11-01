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
			return c.getId();
		case 1:
			return c.getNome();
		case 2:
			return c.getTelefone();
		case 3:
			return c.getEndereco();
		case 4:
			return c.getCidade();
		case 5:
			return "null"; // c.getUf().getNome();
		case 6:
			c.getEmail();
			break;
		case 7:
			return "null";
			//c.getGenero().getNome();
		}

		return null;
	}
}
