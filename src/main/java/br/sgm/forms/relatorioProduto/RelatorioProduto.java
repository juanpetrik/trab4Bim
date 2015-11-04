package br.sgm.forms.relatorioProduto;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.sgm.dao.ProdutoDAO;
import br.sgm.enums.Categoria;
import br.sgm.enums.UF;
import br.sgm.model.ModelProduto;
import br.sgm.util.JasperUtil;

public class RelatorioProduto extends JPanel {
	private JTextField txtMargem;
	private ProdutoDAO dao = new ProdutoDAO();
	private ModelProduto model = new ModelProduto();
	private JComboBox cbCategoria;

	/**
	 * Create the panel.
	 */
	public RelatorioProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 45, 123, 49, 0 };
		gridBagLayout.rowHeights = new int[] { 20, 20, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblCategoria = new JLabel("Categoria");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 0;
		gbc_lblCategoria.gridy = 0;
		add(lblCategoria, gbc_lblCategoria);

		cbCategoria = new JComboBox();
		GridBagConstraints gbc_cbCategoria = new GridBagConstraints();
		gbc_cbCategoria.insets = new Insets(0, 0, 5, 0);
		gbc_cbCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbCategoria.gridx = 1;
		gbc_cbCategoria.gridy = 0;
		add(cbCategoria, gbc_cbCategoria);

		JLabel lblCidade = new JLabel("Margem de Lucro");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 0, 0, 5);
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 1;
		add(lblCidade, gbc_lblCidade);

		txtMargem = new JTextField();
		GridBagConstraints gbc_txtMargem = new GridBagConstraints();
		gbc_txtMargem.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMargem.insets = new Insets(0, 0, 0, 5);
		gbc_txtMargem.gridx = 1;
		gbc_txtMargem.gridy = 1;
		add(txtMargem, gbc_txtMargem);
		txtMargem.setColumns(10);

		cbCategoria.addItem("");

		// Adicionando as Uf's no combobox..
		for (Categoria categoria : Categoria.values())
			cbCategoria.addItem(categoria);

	}

	public Runnable getAcaoSalvar() {
		Runnable runnable = new Runnable() {
			public void run() {
				Categoria categoria = null;
				String margemLucro = "";
				String SQL = "select * from produtos where 1=1 ";

				if (cbCategoria.getSelectedIndex() > 0)
					categoria = (Categoria) cbCategoria.getSelectedItem();

				if (!txtMargem.getText().isEmpty())
					margemLucro = txtMargem.getText();

				if (categoria != null)
					SQL += "and categoria = \"" + categoria.getNome() + "\" ";

				if (!margemLucro.isEmpty())
					SQL += "and margemLucro like \"%" + margemLucro + "%\" ";

				JasperUtil.geraRelatorioEmPdfConsulta(SQL, "/RelatorioProduto.jasper", "RelatorioProdutos");
			}
		};

		return runnable;
	}

	public Runnable getAcaoFechar() {
		return null;
	}
}
