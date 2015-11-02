package br.sgm.forms.produto;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.sgm.conexao.ConexaoMysql;
import br.sgm.dao.ProdutoDAO;
import br.sgm.enums.Categoria;
import br.sgm.enums.Unidade;
import br.sgm.model.Cliente;
import br.sgm.model.ModelProduto;
import br.sgm.model.Produto;

public class CadastroProduto extends JPanel {
	private JTextField txtID;
	private JTextField txtCodBarras;
	private JTextField txtDescricao;
	private JTextField txtCusto;
	private JTextField txtMargemLucro;
	private JComboBox cbUnidade;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable tableProdutos;
	private ProdutoDAO dao = new ProdutoDAO();
	private ModelProduto model = new ModelProduto();
	private JButton btnPesquisar;
	private JComboBox cbCategoria;

	/**
	 * Create the panel.
	 */
	public CadastroProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 45, 123, 49, 65, 0 };
		gridBagLayout.rowHeights = new int[] { 20, 20, 20, 22, 20, 22, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);

		txtID = new JTextField();
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyCode() == KeyEvent.VK_ENTER) {
					btnPesquisar.doClick();
				}
			}
		});
		GridBagConstraints gbc_txtID = new GridBagConstraints();
		gbc_txtID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtID.insets = new Insets(0, 0, 5, 5);
		gbc_txtID.gridx = 1;
		gbc_txtID.gridy = 0;
		add(txtID, gbc_txtID);
		txtID.setColumns(10);

		btnPesquisar = new JButton("Consultar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtID.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe uma ID para consultar");
				} else {
					int id = Integer.parseInt(txtID.getText());

					Produto p = new Produto();
					p.setId(id);

					Produto produto = dao.consultar(p);

					if (produto != null) {
						moveDadosToForm(produto);
					} else {
						JOptionPane.showMessageDialog(null, "Nenhum Produto foi encontrado");
					}
				}

			}
		});
		GridBagConstraints gbc_btnPesquisar = new GridBagConstraints();
		gbc_btnPesquisar.anchor = GridBagConstraints.NORTH;
		gbc_btnPesquisar.insets = new Insets(0, 0, 5, 5);
		gbc_btnPesquisar.gridx = 2;
		gbc_btnPesquisar.gridy = 0;
		add(btnPesquisar, gbc_btnPesquisar);

		JLabel lblNome = new JLabel("Cod Barras");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		add(lblNome, gbc_lblNome);

		txtCodBarras = new JTextField();
		GridBagConstraints gbc_txtCodBarras = new GridBagConstraints();
		gbc_txtCodBarras.gridwidth = 2;
		gbc_txtCodBarras.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodBarras.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodBarras.gridx = 1;
		gbc_txtCodBarras.gridy = 1;
		add(txtCodBarras, gbc_txtCodBarras);
		txtCodBarras.setColumns(10);

		JLabel lblCidade = new JLabel("Descri\u00E7\u00E3o");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 2;
		add(lblCidade, gbc_lblCidade);

		txtDescricao = new JTextField();
		GridBagConstraints gbc_txtDescricao = new GridBagConstraints();
		gbc_txtDescricao.gridwidth = 4;
		gbc_txtDescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescricao.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescricao.gridx = 1;
		gbc_txtDescricao.gridy = 2;
		add(txtDescricao, gbc_txtDescricao);
		txtDescricao.setColumns(10);

		JLabel lblEndereco = new JLabel("Categoria");
		GridBagConstraints gbc_lblEndereco = new GridBagConstraints();
		gbc_lblEndereco.anchor = GridBagConstraints.EAST;
		gbc_lblEndereco.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereco.gridx = 0;
		gbc_lblEndereco.gridy = 3;
		add(lblEndereco, gbc_lblEndereco);

		cbCategoria = new JComboBox();
		GridBagConstraints gbc_cbCategoria = new GridBagConstraints();
		gbc_cbCategoria.gridwidth = 2;
		gbc_cbCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_cbCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbCategoria.gridx = 1;
		gbc_cbCategoria.gridy = 3;
		add(cbCategoria, gbc_cbCategoria);

		JLabel lblUF = new JLabel("Unidade");
		GridBagConstraints gbc_lblUF = new GridBagConstraints();
		gbc_lblUF.anchor = GridBagConstraints.EAST;
		gbc_lblUF.insets = new Insets(0, 0, 5, 5);
		gbc_lblUF.gridx = 0;
		gbc_lblUF.gridy = 4;
		add(lblUF, gbc_lblUF);

		cbUnidade = new JComboBox();
		GridBagConstraints gbc_cbUnidade = new GridBagConstraints();
		gbc_cbUnidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbUnidade.insets = new Insets(0, 0, 5, 5);
		gbc_cbUnidade.gridx = 1;
		gbc_cbUnidade.gridy = 4;
		add(cbUnidade, gbc_cbUnidade);

		JLabel lblTelefone = new JLabel("Custo");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 0;
		gbc_lblTelefone.gridy = 5;
		add(lblTelefone, gbc_lblTelefone);

		txtCusto = new JTextField();
		GridBagConstraints gbc_txtCusto = new GridBagConstraints();
		gbc_txtCusto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCusto.insets = new Insets(0, 0, 5, 5);
		gbc_txtCusto.gridx = 1;
		gbc_txtCusto.gridy = 5;
		add(txtCusto, gbc_txtCusto);
		txtCusto.setColumns(10);

		JLabel lblEmail = new JLabel("Margem Lucro");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 5;
		add(lblEmail, gbc_lblEmail);

		txtMargemLucro = new JTextField();
		GridBagConstraints gbc_txtMargemLucro = new GridBagConstraints();
		gbc_txtMargemLucro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMargemLucro.insets = new Insets(0, 0, 5, 0);
		gbc_txtMargemLucro.gridx = 3;
		gbc_txtMargemLucro.gridy = 5;
		add(txtMargemLucro, gbc_txtMargemLucro);
		txtMargemLucro.setColumns(10);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		tableProdutos = new JTable();
		tableProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {
					String id = tableProdutos.getValueAt(tableProdutos.getSelectedRow(), 0).toString();
					txtID.setText(id);
					btnPesquisar.doClick();
				}

			}
		});
		scrollPane.setViewportView(tableProdutos);

		// Adicionando as categorias no combobox..
		for (Categoria categoria : Categoria.values())
			cbCategoria.addItem(categoria);

		// Adicionando as Unidades no combobox
		for (Unidade unidade : Unidade.values())
			cbUnidade.addItem(unidade);

		atualizarTabela();
	}

	protected void moveDadosToForm(Produto produto) {
		txtID.setText(String.valueOf(produto.getId()));
		txtCodBarras.setText(produto.getCodBarras());
		txtCusto.setText(produto.getCusto().toPlainString());
		txtMargemLucro.setText(produto.getMargemLucro().toPlainString());
		cbUnidade.setSelectedItem(produto.getUnidade());
		cbCategoria.setSelectedItem(produto.getCategoria());
		txtDescricao.setText(produto.getDescricao());
	}

	private Produto getDados() {
		Produto produto = new Produto();

		produto.setId(Integer.parseInt(txtID.getText()));
		produto.setCodBarras(txtCodBarras.getText());
		produto.setDescricao(txtDescricao.getText());
		produto.setMargemLucro(new BigDecimal(txtMargemLucro.getText()));
		produto.setUnidade((Unidade) cbUnidade.getSelectedItem());
		produto.setCusto(new BigDecimal(txtCusto.getText()));
		produto.setCategoria((Categoria) cbCategoria.getSelectedItem());

		return produto;
	}

	public Runnable getAcaoSalvar() {
		Runnable runnable = new Runnable() {
			public void run() {
				Produto produto = getDados();

				dao.setConexao(ConexaoMysql.getConexaoBD());
				dao.inseriralterar(produto);
				JOptionPane.showMessageDialog(null, "Produto Salvo com Sucesso!");
				atualizarTabela();
				limparTela();
			}
		};

		return runnable;
	}

	protected void limparTela() {
		txtID.setText("");
		txtCodBarras.setText("");
		txtCusto.setText("");
		txtMargemLucro.setText("");
		cbUnidade.setSelectedItem("");
		cbCategoria.setSelectedItem("");
		txtDescricao.setText("");
	}

	protected void atualizarTabela() {
		model.list = dao.listar(new Produto());

		tableProdutos.setModel(model);
		model.fireTableDataChanged();
	}

	public Runnable getAcaoFechar() {
		return null;
	}

	public Runnable getAcaoExcluir() {
		Runnable runnable = new Runnable() {
			public void run() {
				if (txtID.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, informe um Produto para excluir");
				} else {
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir?", "Atencão", JOptionPane.YES_NO_OPTION);
					if (opcao == JOptionPane.YES_OPTION) {

						Produto produto = getDados();

						dao.setConexao(ConexaoMysql.getConexaoBD());
						dao.deletar(produto);
						atualizarTabela();
						limparTela();
					}
				}
			}
		};

		return runnable;
	}
}
