package br.sgm.forms.relatorioCliente;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.sgm.dao.ProdutoDAO;
import br.sgm.enums.UF;
import br.sgm.model.ModelProduto;
import br.sgm.util.JasperUtil;

public class RelatorioCliente extends JPanel {
	private JTextField txtCidade;
	private ProdutoDAO dao = new ProdutoDAO();
	private ModelProduto model = new ModelProduto();
	private JComboBox cbUF;

	/**
	 * Create the panel.
	 */
	public RelatorioCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 45, 123, 49, 0 };
		gridBagLayout.rowHeights = new int[] { 20, 20, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblUF = new JLabel("UF");
		GridBagConstraints gbc_lblUF = new GridBagConstraints();
		gbc_lblUF.anchor = GridBagConstraints.EAST;
		gbc_lblUF.insets = new Insets(0, 0, 5, 5);
		gbc_lblUF.gridx = 0;
		gbc_lblUF.gridy = 0;
		add(lblUF, gbc_lblUF);

		cbUF = new JComboBox();
		GridBagConstraints gbc_cbUF = new GridBagConstraints();
		gbc_cbUF.insets = new Insets(0, 0, 5, 0);
		gbc_cbUF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbUF.gridx = 1;
		gbc_cbUF.gridy = 0;
		add(cbUF, gbc_cbUF);

		JLabel lblCidade = new JLabel("Cidade");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 0, 0, 5);
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 1;
		add(lblCidade, gbc_lblCidade);

		txtCidade = new JTextField();
		GridBagConstraints gbc_txtCidade = new GridBagConstraints();
		gbc_txtCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCidade.insets = new Insets(0, 0, 0, 5);
		gbc_txtCidade.gridx = 1;
		gbc_txtCidade.gridy = 1;
		add(txtCidade, gbc_txtCidade);
		txtCidade.setColumns(10);

		cbUF.addItem("");

		// Adicionando as Uf's no combobox..
		for (UF uf : UF.values())
			cbUF.addItem(uf);

		// atualizarTabela();
	}

	public Runnable getAcaoSalvar() {
		Runnable runnable = new Runnable() {
			public void run() {
				UF uf = null;
				String cidade = "";
				String SQL = "select * from clientes where 1=1 ";

				if (cbUF.getSelectedIndex() > 0)
					uf = (UF) cbUF.getSelectedItem();

				if (!txtCidade.getText().isEmpty())
					cidade = txtCidade.getText();

				if (uf != null)
					SQL += "and estado = \"" + uf.getNome() + "\" ";

				if (!cidade.isEmpty())
					SQL += "and cidade like \"%" + cidade + "%\" ";

				JasperUtil.geraRelatorioEmPdfConsulta(SQL, "/RelatorioCliente.jasper", "RelatorioClientes");

			}
		};

		return runnable;
	}

	public Runnable getAcaoFechar() {
		return null;
	}
}
