package br.sgm.forms.relatorioVenda;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.sgm.dao.ProdutoDAO;
import br.sgm.enums.Categoria;
import br.sgm.model.ModelProduto;
import br.sgm.util.JasperUtil;

public class RelatorioVenda extends JPanel {
	private ProdutoDAO dao = new ProdutoDAO();
	private ModelProduto model = new ModelProduto();
	private JComboBox cbCategoria;
	private JLabel lblData;
	private JTextField txtDtInicial;
	private JLabel lblAt;
	private JTextField txtDtFinal;
	private JLabel lblNomeCliente;
	private JTextField txtNomeCliente;

	/**
	 * Create the panel.
	 */
	public RelatorioVenda() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 45, 145, 49, 124, 0 };
		gridBagLayout.rowHeights = new int[] { 20, 20, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblData = new JLabel("Data");
		GridBagConstraints gbc_lblData = new GridBagConstraints();
		gbc_lblData.anchor = GridBagConstraints.EAST;
		gbc_lblData.insets = new Insets(0, 0, 5, 5);
		gbc_lblData.gridx = 0;
		gbc_lblData.gridy = 0;
		add(lblData, gbc_lblData);

		txtDtInicial = new JTextField();
		GridBagConstraints gbc_txtDtInicial = new GridBagConstraints();
		gbc_txtDtInicial.insets = new Insets(0, 0, 5, 5);
		gbc_txtDtInicial.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDtInicial.gridx = 1;
		gbc_txtDtInicial.gridy = 0;
		add(txtDtInicial, gbc_txtDtInicial);
		txtDtInicial.setColumns(10);

		lblAt = new JLabel("at\u00E9");
		GridBagConstraints gbc_lblAt = new GridBagConstraints();
		gbc_lblAt.insets = new Insets(0, 0, 5, 5);
		gbc_lblAt.gridx = 2;
		gbc_lblAt.gridy = 0;
		add(lblAt, gbc_lblAt);

		txtDtFinal = new JTextField();
		txtDtFinal.setColumns(10);
		GridBagConstraints gbc_txtDtFinal = new GridBagConstraints();
		gbc_txtDtFinal.insets = new Insets(0, 0, 5, 0);
		gbc_txtDtFinal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDtFinal.gridx = 3;
		gbc_txtDtFinal.gridy = 0;
		add(txtDtFinal, gbc_txtDtFinal);

		lblNomeCliente = new JLabel("Nome Cliente");
		GridBagConstraints gbc_lblNomeCliente = new GridBagConstraints();
		gbc_lblNomeCliente.anchor = GridBagConstraints.EAST;
		gbc_lblNomeCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeCliente.gridx = 0;
		gbc_lblNomeCliente.gridy = 1;
		add(lblNomeCliente, gbc_lblNomeCliente);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setColumns(10);
		GridBagConstraints gbc_txtNomeCliente = new GridBagConstraints();
		gbc_txtNomeCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtNomeCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNomeCliente.gridx = 1;
		gbc_txtNomeCliente.gridy = 1;
		add(txtNomeCliente, gbc_txtNomeCliente);

		JLabel lblCategoria = new JLabel("Categoria");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.insets = new Insets(0, 0, 0, 5);
		gbc_lblCategoria.gridx = 0;
		gbc_lblCategoria.gridy = 2;
		add(lblCategoria, gbc_lblCategoria);

		cbCategoria = new JComboBox();
		GridBagConstraints gbc_cbCategoria = new GridBagConstraints();
		gbc_cbCategoria.insets = new Insets(0, 0, 0, 5);
		gbc_cbCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbCategoria.gridx = 1;
		gbc_cbCategoria.gridy = 2;
		add(cbCategoria, gbc_cbCategoria);

		cbCategoria.addItem("");

		// Adicionando as Uf's no combobox..
		for (Categoria categoria : Categoria.values())
			cbCategoria.addItem(categoria);

	}

	public Runnable getAcaoSalvar() {
		Runnable runnable = new Runnable() {
			public void run() {
				Categoria categoria = null;
				String dtInicial = "";
				String dtfinal = "";
				String nomeCliente = "";

				String SQL = "select * from vendas where 1=1 ";

				if ((!txtDtInicial.getText().isEmpty()) && (!txtDtFinal.getText().isEmpty())) {
					dtInicial = txtDtInicial.getText();
					dtfinal = txtDtFinal.getText();
				}

				if (!txtNomeCliente.getText().isEmpty())
					nomeCliente = txtNomeCliente.getText();

				if (cbCategoria.getSelectedIndex() > 0)
					categoria = (Categoria) cbCategoria.getSelectedItem();

				if ((dtInicial != "") && (dtfinal != ""))
					SQL += "and dtLancamento between \"" + getData(dtInicial) + "\" and \"" + getData(dtInicial) + "\"";

				if (nomeCliente != "")
					SQL += "and nomeCliente = % \"" + nomeCliente + "% \" ";

				if (categoria != null)
					SQL += "and id IN (select idVenda from itensvendas where categoria = \"" + categoria.getNome() + "\")";

				JasperUtil.geraRelatorioEmPdfConsulta(SQL, "/RelatorioVenda.jasper", "RelatorioVendas");
			}
		};

		return runnable;
	}

	public String getData(String dateString)
	{
	    String result = "";
	    
	    // 22/12/2015
	    result += dateString.substring(6, dateString.length()) + "/";
	    result += dateString.substring(3, 5) + "/";
	    result += dateString.substring(0, 2);
		
		return result;
	}
	
	public Runnable getAcaoFechar() {
		return null;
	}
}
