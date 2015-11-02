package br.sgm.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModelProduto extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Produto> list;

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
		Produto p = list.get(row);

		switch (col) {
		case 0:
			return p.getId();
		case 1:
			return p.getCodBarras();
		case 2:
			return p.getCategoria().getNome();
		case 3:
			return p.getDescricao();
		case 4:
			return p.getUnidade().getNome();
		case 5:
			return p.getCusto();
		case 6:
			return p.getMargemLucro();
		}
		
		return null;
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "ID";
		case 1:
			return "Cod Barras";
		case 2:
			return "Categoria";
		case 3:
			return "Descrição";
		case 4:
			return "Unidade";
		case 5:
			return "Custo R$";
		case 6:
			return "Margem de Lucro %";
		}
		
		return null;
	}
	
	
}
