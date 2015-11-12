package br.sgm.forms.ConsultaCliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.sgm.dao.ClienteDAO;
import br.sgm.model.Cliente;
import br.sgm.model.ModelCliente;

public class TelaConsultaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable tableClientes;
	private ClienteDAO dao = new ClienteDAO();
	private ModelCliente model = new ModelCliente();
	private JButton btnPesquisar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaCliente frame = new TelaConsultaCliente();
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
	public TelaConsultaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 45, 123, 49, 0, 65, 0 };
		gridBagLayout.rowHeights = new int[] { 20, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		add(lblNome, gbc_lblNome);

		txtNome = new JTextField();
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.insets = new Insets(0, 0, 5, 5);
		gbc_txtNome.gridwidth = 4;
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 0;
		add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);

		btnPesquisar = new JButton("Consultar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				/*
				 * if (txtNome.getText().isEmpty()) { JOptionPane.showMessageDialog(null, "Informe uma ID para consultar"); } else { Cliente c = new
				 * Cliente(); c.setNome(txtNome.getText());
				 * 
				 * Cliente cliente = dao.consultar(c);
				 * 
				 * if (cliente != null) { //moveDadosToForm(cliente); } else { JOptionPane.showMessageDialog(null, "Nenhum cliente foi encontrado"); }
				 * }
				 */

			}
		});
		GridBagConstraints gbc_btnPesquisar = new GridBagConstraints();
		gbc_btnPesquisar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnPesquisar.insets = new Insets(0, 0, 5, 0);
		gbc_btnPesquisar.gridx = 5;
		gbc_btnPesquisar.gridy = 0;
		add(btnPesquisar, gbc_btnPesquisar);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 6;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		tableClientes = new JTable();
		scrollPane.setViewportView(tableClientes);
		atualizarTabela();
	}

	protected void atualizarTabela() {
		model.list = dao.listar(new Cliente());

		tableClientes.setModel(model);
		model.fireTableDataChanged();
	}
}
