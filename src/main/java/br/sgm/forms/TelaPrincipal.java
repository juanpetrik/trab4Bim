package br.sgm.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import br.sgm.forms.cliente.TelaCadastroCliente;
import br.sgm.forms.produto.TelaCadastroProduto;
import br.sgm.forms.relatorioCliente.TelaRelatorioCliente;
import br.sgm.forms.usuario.TelaCadastroUsuario;
import br.sgm.forms.venda.TelaVenda;

public class TelaPrincipal extends JFrame {

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

					tabbedPane.addTab("Cadastro de Clientes", telaCadastroCliente);
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

					tabbedPane.addTab("Cadastro de Usuários", telaCadastroUsuario);
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

					tabbedPane.addTab("Cadastro de Produtos", telaCadastroProduto);
				}
			}
		});
		mnNewMenu.add(mntmProdutos);
		
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

					tabbedPane.addTab("Relatório de Clientes", telaRelatorioCliente);
				}
			}
		});
		mnRelatrios.add(mntmClientes);

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

					tabbedPane.addTab("Venda", telaVenda);
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

}
