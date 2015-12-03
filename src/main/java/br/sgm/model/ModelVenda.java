package br.sgm.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModelVenda extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6179339287913636257L;
	public List<Venda> list;

	
	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Venda v = list.get(row);

		switch (col) {
		case 0:
			return v.getId();
		case 1:
			return v.getIdCliente();
		case 2:
			return v.getNomeCliente();
		case 3:
			return v.getVlrTotal();
		case 4:
			return v.getData();
		case 5:
			return v.getHora();
		}
		
		return null;
	}
	
	
	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "ID";
		case 1:
			return "Cliente";
		case 2:
			return "Nome do Cliente";
		case 3:
			return "Valor Total";
		case 4:
			return "Data";
		case 5:
			return "Hora";
		}
		
		return null;
	}

}
