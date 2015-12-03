package br.sgm.forms.venda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.jfree.data.time.Hour;

import br.sgm.dao.ClienteDAO;
import br.sgm.dao.ProdutoDAO;
import br.sgm.dao.VendaDAO;
import br.sgm.forms.ConsultaCliente.TelaConsultaCliente;
import br.sgm.forms.ConsultaProduto.TelaConsultaProduto;
import br.sgm.model.Cliente;
import br.sgm.model.ItemVenda;
import br.sgm.model.ModelItemVenda;
import br.sgm.model.Produto;
import br.sgm.model.Venda;

public class TelaVenda extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableProdutos;
	private JTextField txtNome;
	private JTextField txtCodBarras;
	private JTextField txtDescricao;
	private JTextField txtQtde;
	private JTextField txtTelefone;
	private JTextField txtVlrUnit;
	private JTextField txtSubTotal;
	private JTextField txtVlrTotal;
	private JButton btnFechar;
	private ClienteDAO daoCliente = new ClienteDAO();
	private ProdutoDAO daoProduto = new ProdutoDAO();
	private VendaDAO daoVenda = new VendaDAO();
	private JTextField txtVlrPagamento;
	private JTextField txtVlrTroco;
	private JTextField txtIDCliente;
	private TelaConsultaCliente telaConsultaCliente;
	private TelaConsultaProduto telaConsultaProduto;
	private ModelItemVenda model = new ModelItemVenda();
	private BigDecimal vlrTotal = null;

	private Cliente clienteGlobal;
	private Produto produtoGlobal;

	private Venda vendaGlobal = new Venda();
	private Map<Integer, ItemVenda> listProdutosGlobal = new HashMap<Integer, ItemVenda>();
	private JButton btnAdd;

	/**
	 * Create the panel.
	 */
	public TelaVenda() {
		super();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 58, 132, 63, 64, 79, 77, 0, 79, 0 };
		gridBagLayout.rowHeights = new int[] { 22, 28, 20, 24, 244, 0, 24, 23, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblIDCliente = new JLabel("ID Cliente");
		lblIDCliente.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_lblIDCliente = new GridBagConstraints();
		gbc_lblIDCliente.anchor = GridBagConstraints.EAST;
		gbc_lblIDCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblIDCliente.gridx = 0;
		gbc_lblIDCliente.gridy = 0;
		add(lblIDCliente, gbc_lblIDCliente);

		txtIDCliente = new JTextField();
		txtIDCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyCode() == KeyEvent.VK_ENTER) {
					getCliente();
				}

				if (key.getKeyCode() == KeyEvent.VK_F2) {
					consultarCliente();
				}
			}
		});

		txtIDCliente.setColumns(10);
		GridBagConstraints gbc_txtIDCliente = new GridBagConstraints();
		gbc_txtIDCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtIDCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIDCliente.gridx = 1;
		gbc_txtIDCliente.gridy = 0;
		add(txtIDCliente, gbc_txtIDCliente);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 3;
		gbc_lblTelefone.gridy = 0;
		add(lblTelefone, gbc_lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setFocusable(false);
		txtTelefone.setEditable(false);
		txtTelefone.setColumns(10);
		GridBagConstraints gbc_txtTelefone = new GridBagConstraints();
		gbc_txtTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefone.gridx = 4;
		gbc_txtTelefone.gridy = 0;
		add(txtTelefone, gbc_txtTelefone);

		JLabel lblNomeCliente = new JLabel("Nome Cliente");
		lblNomeCliente.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_lblNomeCliente = new GridBagConstraints();
		gbc_lblNomeCliente.anchor = GridBagConstraints.WEST;
		gbc_lblNomeCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeCliente.gridx = 0;
		gbc_lblNomeCliente.gridy = 1;
		add(lblNomeCliente, gbc_lblNomeCliente);

		txtNome = new JTextField();
		txtNome.setFocusable(false);
		txtNome.setEditable(false);
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.gridwidth = 5;
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.insets = new Insets(0, 0, 5, 5);
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 1;
		add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);

		JLabel lblProduto = new JLabel("Cod Barras");
		lblProduto.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_lblProduto = new GridBagConstraints();
		gbc_lblProduto.anchor = GridBagConstraints.EAST;
		gbc_lblProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblProduto.gridx = 0;
		gbc_lblProduto.gridy = 2;
		add(lblProduto, gbc_lblProduto);

		txtCodBarras = new JTextField();
		txtCodBarras.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {

				if (key.getKeyCode() == KeyEvent.VK_ENTER) {
					if (getProduto()) {
						txtQtde.requestFocus();
						calcularSubTotal();
					}
				}

				if (key.getKeyCode() == KeyEvent.VK_F2) {
					consultarProduto();
				}
			}
		});
		GridBagConstraints gbc_txtCodBarras = new GridBagConstraints();
		gbc_txtCodBarras.anchor = GridBagConstraints.NORTH;
		gbc_txtCodBarras.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodBarras.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodBarras.gridx = 1;
		gbc_txtCodBarras.gridy = 2;
		add(txtCodBarras, gbc_txtCodBarras);
		txtCodBarras.setColumns(10);

		JLabel lblQtde = new JLabel("Qtde");
		lblQtde.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_lblQtde = new GridBagConstraints();
		gbc_lblQtde.anchor = GridBagConstraints.EAST;
		gbc_lblQtde.insets = new Insets(0, 0, 5, 5);
		gbc_lblQtde.gridx = 2;
		gbc_lblQtde.gridy = 2;
		add(lblQtde, gbc_lblQtde);

		txtQtde = new JTextField();
		txtQtde.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				String caracteres = "0987654321";

				if ((txtQtde.getText().length() >= 5) || (!caracteres.contains(evt.getKeyChar() + ""))) {
					evt.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (!txtQtde.getText().isEmpty()) {
					calcularSubTotal();
				} else {
					txtSubTotal.setText("");
				}
			}

			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyCode() == KeyEvent.VK_ENTER) {
					btnAdd.doClick();
				}
			}
		});

		txtQtde.setColumns(10);
		GridBagConstraints gbc_txtQtde = new GridBagConstraints();
		gbc_txtQtde.anchor = GridBagConstraints.NORTH;
		gbc_txtQtde.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtQtde.insets = new Insets(0, 0, 5, 5);
		gbc_txtQtde.gridx = 3;
		gbc_txtQtde.gridy = 2;
		add(txtQtde, gbc_txtQtde);

		JLabel lblVlrUnit = new JLabel("Vlr Unit  R$");
		lblVlrUnit.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_lblVlrUnit = new GridBagConstraints();
		gbc_lblVlrUnit.anchor = GridBagConstraints.EAST;
		gbc_lblVlrUnit.insets = new Insets(0, 0, 5, 5);
		gbc_lblVlrUnit.gridx = 4;
		gbc_lblVlrUnit.gridy = 2;
		add(lblVlrUnit, gbc_lblVlrUnit);

		txtVlrUnit = new JTextField();
		txtVlrUnit.setFocusable(false);
		txtVlrUnit.setEditable(false);
		txtVlrUnit.setColumns(10);
		GridBagConstraints gbc_txtVlrUnit = new GridBagConstraints();
		gbc_txtVlrUnit.insets = new Insets(0, 0, 5, 5);
		gbc_txtVlrUnit.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVlrUnit.gridx = 5;
		gbc_txtVlrUnit.gridy = 2;
		add(txtVlrUnit, gbc_txtVlrUnit);

		JLabel lblSubtotal = new JLabel("SubTotal  R$");
		lblSubtotal.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_lblSubtotal = new GridBagConstraints();
		gbc_lblSubtotal.anchor = GridBagConstraints.EAST;
		gbc_lblSubtotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubtotal.gridx = 6;
		gbc_lblSubtotal.gridy = 2;
		add(lblSubtotal, gbc_lblSubtotal);

		txtSubTotal = new JTextField();
		txtSubTotal.setFocusable(false);
		txtSubTotal.setEditable(false);
		txtSubTotal.setColumns(10);
		GridBagConstraints gbc_txtSubTotal = new GridBagConstraints();
		gbc_txtSubTotal.insets = new Insets(0, 0, 5, 0);
		gbc_txtSubTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSubTotal.gridx = 7;
		gbc_txtSubTotal.gridy = 2;
		add(txtSubTotal, gbc_txtSubTotal);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrio.anchor = GridBagConstraints.EAST;
		gbc_lblDescrio.gridx = 0;
		gbc_lblDescrio.gridy = 3;
		add(lblDescrio, gbc_lblDescrio);

		txtDescricao = new JTextField();
		txtDescricao.setFocusable(false);
		txtDescricao.setEditable(false);
		GridBagConstraints gbc_txtDescricao = new GridBagConstraints();
		gbc_txtDescricao.gridwidth = 5;
		gbc_txtDescricao.anchor = GridBagConstraints.NORTH;
		gbc_txtDescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescricao.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescricao.gridx = 1;
		gbc_txtDescricao.gridy = 3;
		add(txtDescricao, gbc_txtDescricao);
		txtDescricao.setColumns(10);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (validarProduto()) {
					addProduto();
					txtCodBarras.requestFocus();
				}
			}

			private boolean validarProduto() {
				if (txtCodBarras.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Falta informar o Código de Barras!");
					txtCodBarras.requestFocus();
					return false;
				}

				if (txtQtde.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Falta informar a Quantidade!");
					txtQtde.requestFocus();
					return false;
				}

				if (Integer.parseInt(txtQtde.getText().trim()) < 1) {
					JOptionPane.showMessageDialog(null, "A quantidade não pode ser menor que 1!");
					txtCodBarras.requestFocus();
					return false;
				}

				return true;
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 6;
		gbc_btnAdd.gridy = 3;
		add(btnAdd, gbc_btnAdd);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 8;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		tableProdutos = new JTable();
		tableProdutos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {

				if (key.getKeyCode() == KeyEvent.VK_DELETE) {
					int selecionado = tableProdutos.getSelectedRow() + 1;

					ItemVenda item = listProdutosGlobal.get(selecionado);

					vlrTotal = vlrTotal.subtract(item.getSubTotal());

					txtVlrTotal.setText(vlrTotal.toString());

					listProdutosGlobal.remove(selecionado);

					reprocessarItens();

					atualizarTabela();
				}

			}

			private void reprocessarItens() {
				Map<Integer, ItemVenda> listTMP = new HashMap<Integer, ItemVenda>();
				int seq = 1;

				for (int i = 1; i <= listProdutosGlobal.size() + 1; i++) {
					if (listProdutosGlobal.get(i) != null) {
						listTMP.put(seq, listProdutosGlobal.get(i));
						seq++;
					}
				}

				listProdutosGlobal.clear();

				seq = 1;

				for (int i = 1; i <= listTMP.size(); i++) {
					if (listTMP.get(i) != null) {
						listProdutosGlobal.put(seq, listTMP.get(i));
						seq++;
					}
				}
			}
		});
		tableProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {

				// Se o individuo clicou duas vezes é para alterar o produto...
				if (evt.getClickCount() == 2) {
					// Vamos implementar futuramente..
				}

			}
		});
		scrollPane.setViewportView(tableProdutos);

		JLabel lblValorTotal = new JLabel("Valor Total  R$");
		lblValorTotal.setFont(new Font("Dialog", Font.BOLD, 20));
		GridBagConstraints gbc_lblValorTotal = new GridBagConstraints();
		gbc_lblValorTotal.anchor = GridBagConstraints.EAST;
		gbc_lblValorTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorTotal.gridx = 5;
		gbc_lblValorTotal.gridy = 5;
		add(lblValorTotal, gbc_lblValorTotal);

		txtVlrTotal = new JTextField();
		txtVlrTotal.setEditable(false);
		txtVlrTotal.setText("00.00");
		txtVlrTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtVlrTotal.setColumns(10);
		GridBagConstraints gbc_txtVlrTotal = new GridBagConstraints();
		gbc_txtVlrTotal.gridwidth = 2;
		gbc_txtVlrTotal.insets = new Insets(0, 0, 5, 0);
		gbc_txtVlrTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVlrTotal.gridx = 6;
		gbc_txtVlrTotal.gridy = 5;
		add(txtVlrTotal, gbc_txtVlrTotal);

		JLabel lblTroco = new JLabel("Troco  R$");
		lblTroco.setFont(new Font("Dialog", Font.BOLD, 20));
		GridBagConstraints gbc_lblTroco = new GridBagConstraints();
		gbc_lblTroco.anchor = GridBagConstraints.EAST;
		gbc_lblTroco.insets = new Insets(0, 0, 5, 5);
		gbc_lblTroco.gridx = 1;
		gbc_lblTroco.gridy = 6;
		add(lblTroco, gbc_lblTroco);

		txtVlrTroco = new JTextField();
		txtVlrTroco.setForeground(Color.RED);
		txtVlrTroco.setEditable(false);
		txtVlrTroco.setText("00.00");
		txtVlrTroco.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtVlrTroco.setColumns(10);
		GridBagConstraints gbc_txtVlrTroco = new GridBagConstraints();
		gbc_txtVlrTroco.gridwidth = 2;
		gbc_txtVlrTroco.insets = new Insets(0, 0, 5, 5);
		gbc_txtVlrTroco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVlrTroco.gridx = 2;
		gbc_txtVlrTroco.gridy = 6;
		add(txtVlrTroco, gbc_txtVlrTroco);

		JLabel lblValorPagamento = new JLabel("Valor Pagamento  R$");
		lblValorPagamento.setFont(new Font("Dialog", Font.BOLD, 20));
		GridBagConstraints gbc_lblValorPagamento = new GridBagConstraints();
		gbc_lblValorPagamento.anchor = GridBagConstraints.EAST;
		gbc_lblValorPagamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorPagamento.gridx = 5;
		gbc_lblValorPagamento.gridy = 6;
		add(lblValorPagamento, gbc_lblValorPagamento);

		txtVlrPagamento = new JTextField();
		txtVlrPagamento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				// Calculando o valor de troco.. se o campo for diferente de vazio..
				if (!txtVlrPagamento.getText().trim().isEmpty()) {
					BigDecimal vlrTroco = new BigDecimal(txtVlrPagamento.getText()).subtract(vlrTotal);

					txtVlrTroco.setText(vlrTroco.toString());
				}
			}
		});
		txtVlrPagamento.setText("00.00");
		txtVlrPagamento.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtVlrPagamento.setColumns(10);
		GridBagConstraints gbc_txtVlrPagamento = new GridBagConstraints();
		gbc_txtVlrPagamento.gridwidth = 2;
		gbc_txtVlrPagamento.insets = new Insets(0, 0, 5, 0);
		gbc_txtVlrPagamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVlrPagamento.gridx = 6;
		gbc_txtVlrPagamento.gridy = 6;
		add(txtVlrPagamento, gbc_txtVlrPagamento);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int retorno = JOptionPane.showConfirmDialog(null, "Deseja mesmo cancelar?", "Cancelar", JOptionPane.YES_NO_OPTION);
				if (retorno == JOptionPane.YES_OPTION) {
					clienteGlobal = null;
					produtoGlobal = null;
					listProdutosGlobal = new HashMap<Integer, ItemVenda>();
					limparTela();
				}
			}
		});
		btnCancelar.setIcon(new ImageIcon(getClass().getResource("/icons/cancelar.png")));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 5;
		gbc_btnCancelar.gridy = 7;
		add(btnCancelar, gbc_btnCancelar);

		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				vendaGlobal.setId(daoVenda.getNextID());
				vendaGlobal.setIdCliente(clienteGlobal.getId());
				vendaGlobal.setNomeCliente(clienteGlobal.getNome());
				vendaGlobal.setProdutos(model.list);
				vendaGlobal.setVlrTotal(vlrTotal);
				vendaGlobal.setData(new Date());
				vendaGlobal.setHora(System.currentTimeMillis());
				vendaGlobal.setProdutos(listProdutosGlobal);
				
				daoVenda.inseriralterar(vendaGlobal);
			}
		});
		btnFinalizar.setIcon(new ImageIcon(getClass().getResource("/icons/finalizar.png")));
		GridBagConstraints gbc_btnFinalizar = new GridBagConstraints();
		gbc_btnFinalizar.insets = new Insets(0, 0, 0, 5);
		gbc_btnFinalizar.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnFinalizar.gridx = 6;
		gbc_btnFinalizar.gridy = 7;
		add(btnFinalizar, gbc_btnFinalizar);

		btnFechar = new JButton("Fechar");
		btnFechar.setIcon(new ImageIcon(getClass().getResource("/icons/fechar.png")));
		GridBagConstraints gbc_btnFechar = new GridBagConstraints();
		gbc_btnFechar.anchor = GridBagConstraints.NORTH;
		gbc_btnFechar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFechar.gridx = 7;
		gbc_btnFechar.gridy = 7;
		add(btnFechar, gbc_btnFechar);
	}

	protected void limparTela() {
		limparDadosCliente();
		limparDadosProduto();
		
		atualizarTabela();
		
		txtVlrPagamento.setText("00.00");
		txtVlrTotal.setText("00.00");
		txtVlrTroco.setText("00.00");
		vlrTotal = new BigDecimal(0);
	}

	protected void calcularSubTotal() {
		int qtde = Integer.parseInt(txtQtde.getText().trim());

		BigDecimal vlr = produtoGlobal.getValorProduto().setScale(2, RoundingMode.HALF_EVEN).multiply(new BigDecimal(qtde));

		txtSubTotal.setText(vlr.setScale(2, RoundingMode.HALF_EVEN).toString());
	}

	// Método que vai adicionar o produto na venda..
	protected void addProduto() {
		ItemVenda item = new ItemVenda();

		item.setIdSeq(listProdutosGlobal.size() + 1);
		item.setId(produtoGlobal.getId());
		item.setCodBarras(produtoGlobal.getCodBarras());
		item.setDescricao(produtoGlobal.getDescricao());
		item.setCategoria(produtoGlobal.getCategoria());
		item.setCusto(produtoGlobal.getCusto());
		item.setMargemLucro(produtoGlobal.getMargemLucro());
		item.setUnidade(produtoGlobal.getUnidade());
		item.setVlrUnit(produtoGlobal.getValorProduto());
		item.setQtde(Integer.parseInt(txtQtde.getText()));
		item.setSubTotal(new BigDecimal(txtSubTotal.getText()));

		if (vlrTotal == null) {
			vlrTotal = new BigDecimal(0);
		}

		vlrTotal = item.getSubTotal().add(vlrTotal);

		txtVlrTotal.setText(vlrTotal.toString());

		listProdutosGlobal.put(item.getIdSeq(), item);
		atualizarTabela();
		limparDadosProduto();
	}

	protected void atualizarTabela() {
		model.list = listProdutosGlobal;

		tableProdutos.setModel(model);
		model.fireTableDataChanged();
	}

	protected String formatMyMoney(BigDecimal vlr) {
		return NumberFormat.getCurrencyInstance().format(vlr);
	}

	protected void consultarProduto() {
		if (telaConsultaProduto == null) {
			telaConsultaProduto = new TelaConsultaProduto(new Runnable() {
				public void run() {
					moveDadosProdutoToForm(telaConsultaProduto.produtoRetorno);
					telaConsultaProduto = null;
					txtQtde.requestFocus();
					calcularSubTotal();
				}
			});

			telaConsultaProduto.setVisible(true);

		}
	}

	protected boolean getProduto() {
		if (txtCodBarras.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe um Código de Barras para consultar");
			return false;
		} else {
			String codBarras = txtCodBarras.getText();

			Produto p = new Produto();
			p.setCodBarras(codBarras);

			Produto produto = daoProduto.consultarByCodBarras(p);

			if (produto != null) {
				moveDadosProdutoToForm(produto);
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Nenhum produto foi encontrado");
				limparDadosCliente();
				return false;
			}
		}
	}

	private void moveDadosProdutoToForm(Produto produto) {
		txtCodBarras.setText(produto.getCodBarras());
		txtDescricao.setText(produto.getDescricao());
		txtQtde.setText("1"); // Por default, seta 1
		txtVlrUnit.setText(produto.getValorProduto().setScale(2, RoundingMode.HALF_EVEN).toString());
		txtSubTotal.setText("");
		
		produtoGlobal = produto;
	}

	// Método que vai pegar um único cliente do banco..
	protected void getCliente() {
		if (txtIDCliente.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe uma ID para consultar");
		} else {
			int id = Integer.parseInt(txtIDCliente.getText());

			Cliente c = new Cliente();
			c.setId(id);

			Cliente cliente = daoCliente.consultar(c);

			if (cliente != null) {
				moveDadosClienteToForm(cliente);
			} else {
				JOptionPane.showMessageDialog(null, "Nenhum cliente foi encontrado");
				limparDadosCliente();
			}
		}
	}

	// Método que limpa os dados do cliente da tela..
	private void limparDadosCliente() {
		txtIDCliente.setText("");
		txtNome.setText("");
		txtTelefone.setText("");
		clienteGlobal = null;
	}

	// Método que joga os dados de um cliente do objeto para tela..
	private void moveDadosClienteToForm(Cliente cliente) {
		txtIDCliente.setText(String.valueOf(cliente.getId()));
		txtNome.setText(cliente.getNome());
		txtTelefone.setText(cliente.getTelefone());

		clienteGlobal = cliente;
	}

	// Método que vai abrir a consulta de clientes..
	protected void consultarCliente() {
		if (telaConsultaCliente == null) {
			telaConsultaCliente = new TelaConsultaCliente(new Runnable() {
				public void run() {
					moveDadosClienteToForm(telaConsultaCliente.clienteRetorno);
					telaConsultaCliente = null;
				}
			});

			telaConsultaCliente.setVisible(true);

		}
	}

	protected void limparDadosProduto() {
		txtCodBarras.setText("");
		txtDescricao.setText("");
		txtQtde.setText("");
		txtVlrUnit.setText("");
		produtoGlobal = null;
	}

	public void setAcaoFechar(ActionListener action) {
		btnFechar.addActionListener(action);
	}
}
