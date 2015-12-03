package br.sgm.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import br.sgm.conexao.ConexaoMysql;
import br.sgm.conexao.StartBD;
import br.sgm.forms.cadastroCliente.TelaCadastroCliente;
import br.sgm.forms.cadastroProduto.TelaCadastroProduto;
import br.sgm.forms.consultaVendas.ConsultaVenda;
import br.sgm.forms.relatorioCliente.TelaRelatorioCliente;
import br.sgm.forms.relatorioProduto.TelaRelatorioProduto;
import br.sgm.forms.usuario.TelaCadastroUsuario;
import br.sgm.forms.venda.TelaVenda;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setTitle("SGM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Cadastros");
		menuBar.add(mnNewMenu);

		JMenuItem mntmCliente = new JMenuItem("Clientes");
		mntmCliente.addActionListener(new ActionListener() {
			private TelaCadastroCliente telaCadastroCliente;

			public void actionPerformed(ActionEvent arg0) {
				abrirCadastrodeClientes();
			}

			private void abrirCadastrodeClientes() {
				if (telaCadastroCliente == null) {
					telaCadastroCliente = new TelaCadastroCliente();

					ActionListener action = e -> {
						tabbedPane.remove(telaCadastroCliente);
						telaCadastroCliente = null;
					};

					telaCadastroCliente.setAcaoFechar(action);

					tabbedPane.addTab("Cadastro de Clientes", telaCadastroCliente);
					focus();
				}
			}
		});
		mnNewMenu.add(mntmCliente);

		JMenuItem mntmUsurio = new JMenuItem("Usu\u00E1rios");
		mntmUsurio.addActionListener(new ActionListener() {
			private TelaCadastroUsuario telaCadastroUsuario;

			public void actionPerformed(ActionEvent arg0) {
				abrirCadastrodeClientes();
			}

			private void abrirCadastrodeClientes() {
				if (telaCadastroUsuario == null) {
					telaCadastroUsuario = new TelaCadastroUsuario();

					ActionListener action = e -> {
						tabbedPane.remove(telaCadastroUsuario);
						telaCadastroUsuario = null;
					};

					telaCadastroUsuario.setAcaoFechar(action);

					tabbedPane.addTab("Cadastro de Usuários", telaCadastroUsuario);
					focus();
				}
			}
		});
		mnNewMenu.add(mntmUsurio);

		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mntmProdutos.addActionListener(new ActionListener() {
			private TelaCadastroProduto telaCadastroProduto;

			public void actionPerformed(ActionEvent arg0) {
				abrirCadastrodeProdutos();
			}

			private void abrirCadastrodeProdutos() {
				if (telaCadastroProduto == null) {
					telaCadastroProduto = new TelaCadastroProduto();

					ActionListener action = e -> {
						tabbedPane.remove(telaCadastroProduto);
						telaCadastroProduto = null;
					};
					
					telaCadastroProduto.setAcaoFechar(action);

					tabbedPane.addTab("Cadastro de Produtos", telaCadastroProduto);
					focus();
				}
			}
		});
		mnNewMenu.add(mntmProdutos);
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
		
		JMenuItem mntmVendas = new JMenuItem("Vendas");
		mntmVendas.addActionListener(new ActionListener() {
			private ConsultaVenda telaConsultaVenda;

			public void actionPerformed(ActionEvent arg0) {
				abrirTelaVenda();
			}

			private void abrirTelaVenda() {
				if (telaConsultaVenda == null) {
					telaConsultaVenda = new ConsultaVenda();

					JPanel newPainel = new JPanel(); 
					{GridBagLayout gridBagLayout = new GridBagLayout();
					gridBagLayout.columnWidths = new int[]{0, 0};
					gridBagLayout.rowHeights = new int[]{0, 0};
					gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
					gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
					newPainel.setLayout(gridBagLayout);
					
					
					GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
					gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
					gbc_btnNewButton.gridx = 0;
					gbc_btnNewButton.gridy = 0;
					newPainel.add(telaConsultaVenda, gbc_btnNewButton);}

					tabbedPane.addTab("Consulta Venda", newPainel);
					focus();
				}
			}
		});
		mnConsultas.add(mntmVendas);

		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatrios);

		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			private TelaRelatorioCliente telaRelatorioCliente;

			public void actionPerformed(ActionEvent arg0) {
				abrirRelatorioClientes();
			}

			private void abrirRelatorioClientes() {
				if (telaRelatorioCliente == null) {
					telaRelatorioCliente = new TelaRelatorioCliente();

					ActionListener action = e -> {
						tabbedPane.remove(telaRelatorioCliente);
						telaRelatorioCliente = null;
					};
					telaRelatorioCliente.setAcaoFechar(action);

					tabbedPane.addTab("Relatório de Clientes", telaRelatorioCliente);
					focus();
				}
			}
		});
		mnRelatrios.add(mntmClientes);
		
		JMenuItem mntmProdutos_1 = new JMenuItem("Produtos");
		mntmProdutos_1.addActionListener(new ActionListener() {
			private TelaRelatorioProduto telaRelatorioProduto;

			public void actionPerformed(ActionEvent arg0) {
				abrirRelatorioClientes();
			}

			private void abrirRelatorioClientes() {
				if (telaRelatorioProduto == null) {
					telaRelatorioProduto = new TelaRelatorioProduto();

					ActionListener action = e -> {
						tabbedPane.remove(telaRelatorioProduto);
						telaRelatorioProduto = null;
					};
					telaRelatorioProduto.setAcaoFechar(action);

					tabbedPane.addTab("Relatório de Produtos", telaRelatorioProduto);
					focus();
				}
			}
		});
		mnRelatrios.add(mntmProdutos_1);

		JMenu mnVenda = new JMenu("Faturamento");

		menuBar.add(mnVenda);

		JMenuItem mntmVenda = new JMenuItem("Venda");
		mntmVenda.addActionListener(new ActionListener() {
			private TelaVenda telaVenda;

			public void actionPerformed(ActionEvent arg0) {
				abrirTelaVenda();
			}

			private void abrirTelaVenda() {
				if (telaVenda == null) {
					telaVenda = new TelaVenda();

					JPanel newPainel = new JPanel(); 
					{GridBagLayout gridBagLayout = new GridBagLayout();
					gridBagLayout.columnWidths = new int[]{0, 0};
					gridBagLayout.rowHeights = new int[]{0, 0};
					gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
					gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
					newPainel.setLayout(gridBagLayout);
					
					
					GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
					gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
					gbc_btnNewButton.gridx = 0;
					gbc_btnNewButton.gridy = 0;
					newPainel.add(telaVenda, gbc_btnNewButton);}
					
					ActionListener action = e -> {
						tabbedPane.remove(newPainel);
						telaVenda = null;
					};
					
					telaVenda.setAcaoFechar(action);

					tabbedPane.addTab("Venda", newPainel);
					focus();
				}
			}
		});
		mnVenda.add(mntmVenda);

		JMenu mnConfiguraes = new JMenu("Configura\u00E7\u00F5es");
		menuBar.add(mnConfiguraes);

		JMenuItem mntmStartBd = new JMenuItem("Start BD");
		mntmStartBd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConexaoMysql.setBancoDados("mysql");
				StartBD.executeSqlScript(ConexaoMysql.getConexaoBD());
				ConexaoMysql.setBancoDados("trab4bimoo");
			}
		});
		mnConfiguraes.add(mntmStartBd);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

	protected void focus() {
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() -1);
	}

}
