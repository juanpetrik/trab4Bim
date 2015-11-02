package br.sgm.forms.usuario;

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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.sgm.conexao.ConexaoMysql;
import br.sgm.dao.ClienteDAO;
import br.sgm.dao.UsuarioDAO;
import br.sgm.enums.Genero;
import br.sgm.enums.UF;
import br.sgm.model.Cliente;
import br.sgm.model.ModelUsuario;
import br.sgm.model.Usuario;
import javax.swing.JPasswordField;

public class CadastroUsuario extends JPanel {
	private JTextField txtID;
	private JTextField txtNome;
	private JComboBox cbIDCliente;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable tableUsuarios;
	private UsuarioDAO dao = new UsuarioDAO();
	private ClienteDAO daoCliente = new ClienteDAO();
	private ModelUsuario model = new ModelUsuario();
	List<Object> listar;
	private JButton btnPesquisar;
	private JPasswordField txtSenha;

	/**
	 * Create the panel.
	 */
	public CadastroUsuario() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 45, 158, 49, 65, 0 };
		gridBagLayout.rowHeights = new int[] { 20, 20, 20, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
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

					Usuario u = new Usuario();
					u.setId(id);

					Usuario usuario = dao.consultar(u);

					if (usuario != null) {
						moveDadosToForm(usuario);
					} else {
						JOptionPane.showMessageDialog(null, "Nenhum usuário foi encontrado");
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

		JLabel lblIDCliente = new JLabel("ID Cliente");
		GridBagConstraints gbc_lblIDCliente = new GridBagConstraints();
		gbc_lblIDCliente.anchor = GridBagConstraints.EAST;
		gbc_lblIDCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblIDCliente.gridx = 0;
		gbc_lblIDCliente.gridy = 1;
		add(lblIDCliente, gbc_lblIDCliente);

		cbIDCliente = new JComboBox();
		cbIDCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente c;
				c = (Cliente) listar.get(cbIDCliente.getSelectedIndex());
				txtNome.setText(c.getNome());
			}
		});
		GridBagConstraints gbc_cbIDCliente = new GridBagConstraints();
		gbc_cbIDCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbIDCliente.insets = new Insets(0, 0, 5, 5);
		gbc_cbIDCliente.gridx = 1;
		gbc_cbIDCliente.gridy = 1;
		add(cbIDCliente, gbc_cbIDCliente);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 2;
		gbc_lblNome.gridy = 1;
		add(lblNome, gbc_lblNome);

		txtNome = new JTextField();
		txtNome.setEditable(false);
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.insets = new Insets(0, 0, 5, 0);
		gbc_txtNome.gridwidth = 2;
		gbc_txtNome.gridx = 3;
		gbc_txtNome.gridy = 1;
		add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 2;
		add(lblSenha, gbc_lblSenha);
		
		txtSenha = new JPasswordField();
		GridBagConstraints gbc_txtSenha = new GridBagConstraints();
		gbc_txtSenha.anchor = GridBagConstraints.NORTH;
		gbc_txtSenha.insets = new Insets(0, 0, 5, 5);
		gbc_txtSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSenha.gridx = 1;
		gbc_txtSenha.gridy = 2;
		add(txtSenha, gbc_txtSenha);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		tableUsuarios = new JTable();
		tableUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {
					String id = tableUsuarios.getValueAt(tableUsuarios.getSelectedRow(), 0).toString();
					txtID.setText(id);
					btnPesquisar.doClick();
				}

			}
		});
		scrollPane.setViewportView(tableUsuarios);

		// Adicionando as UF's no combobox..
		listar = daoCliente.listar(new Cliente());
		for (Object obj : listar) {
			Cliente c;
			c = (Cliente) obj;
			
			cbIDCliente.addItem(c.getId());
		}
		
		cbIDCliente.actionPerformed(null);
		
		atualizarTabela();
	}

	protected void moveDadosToForm(Usuario usuario) {
		txtID.setText(String.valueOf(usuario.getId()));
		
		Cliente c;
		c = (Cliente) listar.get(cbIDCliente.getSelectedIndex());
		txtNome.setText(c.getNome());
		
		cbIDCliente.setSelectedItem(usuario.getIdCliente());
		txtSenha.setText(usuario.getSenha());
	}

	private Usuario getDados() {
		Usuario usuario = new Usuario();

		usuario.setId(Integer.parseInt(txtID.getText()));
		usuario.setIdCliente((int) cbIDCliente.getSelectedItem());
		usuario.setSenha(txtSenha.getText());

		return usuario;
	}

	public Runnable getAcaoSalvar() {
		Runnable runnable = new Runnable() {
			public void run() {
				Usuario usuario = getDados();

				dao.setConexao(ConexaoMysql.getConexaoBD());
				dao.inseriralterar(usuario);
				JOptionPane.showMessageDialog(null, "Usuário Salvo com Sucesso!");
				atualizarTabela();
				limparTela();
			}
		};

		return runnable;
	}

	protected void limparTela() {
		txtID.setText("");
		txtNome.setText("");
		txtSenha.setText("");
		cbIDCliente.setSelectedItem("");
	}

	protected void atualizarTabela() {
		model.list = dao.listar(new Usuario());

		tableUsuarios.setModel(model);
		model.fireTableDataChanged();
	}

	public Runnable getAcaoFechar() {
		return null;
	}

	public Runnable getAcaoExcluir() {
		Runnable runnable = new Runnable() {
			public void run() {
				if (txtID.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, informe um usuário para excluir");
				} else {
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir?", "Atencão", JOptionPane.YES_NO_OPTION);
					if (opcao == JOptionPane.YES_OPTION) {

						Usuario usuario = getDados();

						dao.setConexao(ConexaoMysql.getConexaoBD());
						dao.deletar(usuario);
						atualizarTabela();
						limparTela();
					}
				}
			}
		};

		return runnable;
	}
}
