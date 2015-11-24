package br.sgm.model;

import java.text.NumberFormat;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

public class ModelItemVenda extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Map<Integer, ItemVenda> list = null;

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		ItemVenda item = list.get(row + 1);

		switch (col) {
		case 0:
			return item.getIdSeq();
		case 1:
			return item.getId();
		case 2:
			return item.getCodBarras();
		case 3:
			return item.getDescricao();
		case 4:
			return item.getUnidade().getNome();
		case 5:
			return NumberFormat.getCurrencyInstance().format(item.getVlrUnit());
		case 6:
			return item.getQtde();
		case 7:
			return NumberFormat.getCurrencyInstance().format(item.getSubTotal());
		}
		
		return null;
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "ID";
		case 1:
			return "Cod Interno";
		case 2:
			return "Cod Barras";
		case 3:
			return "Descrição";
		case 4:
			return "Unidade";
		case 5:
			return "Vlr Unit";
		case 6:
			return "Qtde";
		case 7:
			return "SubTotal";
		}
		
		return null;
	}
	
	
}
