package br.sgm.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModelUsuario extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Usuario> list;

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Usuario p = list.get(row);

		switch (col) {
		case 0:
			return p.getId();
		case 1:
			return p.getIdCliente();
		case 2:
			return "*************";
		}
		
		return null;
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "ID";
		case 1:
			return "ID Cliente";
		case 2:
			return "Senha";
		}
		
		return null;
	}
	
	
}
