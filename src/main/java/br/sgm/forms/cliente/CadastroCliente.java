package br.sgm.forms.cliente;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.sgm.enums.Genero;
import br.sgm.enums.UF;
import br.sgm.forms.TelaPrincipal;
import br.sgm.model.Cliente;

public class CadastroCliente extends JPanel {
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtCidade;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JComboBox cbUF;
	private JComboBox cbGenero;
	
	/**
	 * Create the panel.
	 */
	public CadastroCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{45, 123, 49, 65, 0};
		gridBagLayout.rowHeights = new int[]{20, 20, 20, 22, 20, 22, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);
		
		txtID = new JTextField();
		GridBagConstraints gbc_txtID = new GridBagConstraints();
		gbc_txtID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtID.insets = new Insets(0, 0, 5, 5);
		gbc_txtID.gridx = 1;
		gbc_txtID.gridy = 0;
		add(txtID, gbc_txtID);
		txtID.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		add(lblNome, gbc_lblNome);
		
		txtNome = new JTextField();
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.insets = new Insets(0, 0, 5, 0);
		gbc_txtNome.gridwidth = 4;
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 1;
		add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		GridBagConstraints gbc_lblEndereco = new GridBagConstraints();
		gbc_lblEndereco.anchor = GridBagConstraints.EAST;
		gbc_lblEndereco.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereco.gridx = 0;
		gbc_lblEndereco.gridy = 2;
		add(lblEndereco, gbc_lblEndereco);
		
		txtEndereco = new JTextField();
		GridBagConstraints gbc_txtEndereco = new GridBagConstraints();
		gbc_txtEndereco.gridwidth = 4;
		gbc_txtEndereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEndereco.insets = new Insets(0, 0, 5, 0);
		gbc_txtEndereco.gridx = 1;
		gbc_txtEndereco.gridy = 2;
		add(txtEndereco, gbc_txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 3;
		add(lblCidade, gbc_lblCidade);
		
		txtCidade = new JTextField();
		GridBagConstraints gbc_txtCidade = new GridBagConstraints();
		gbc_txtCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtCidade.gridx = 1;
		gbc_txtCidade.gridy = 3;
		add(txtCidade, gbc_txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblUF = new JLabel("UF");
		GridBagConstraints gbc_lblUF = new GridBagConstraints();
		gbc_lblUF.anchor = GridBagConstraints.EAST;
		gbc_lblUF.insets = new Insets(0, 0, 5, 5);
		gbc_lblUF.gridx = 2;
		gbc_lblUF.gridy = 3;
		add(lblUF, gbc_lblUF);
		
		cbUF = new JComboBox();
		GridBagConstraints gbc_cbUF = new GridBagConstraints();
		gbc_cbUF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbUF.insets = new Insets(0, 0, 5, 0);
		gbc_cbUF.gridx = 3;
		gbc_cbUF.gridy = 3;
		add(cbUF, gbc_cbUF);
		
		JLabel lblTelefone = new JLabel("Telefone");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 0;
		gbc_lblTelefone.gridy = 4;
		add(lblTelefone, gbc_lblTelefone);
		
		txtTelefone = new JTextField();
		GridBagConstraints gbc_txtTelefone = new GridBagConstraints();
		gbc_txtTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefone.gridx = 1;
		gbc_txtTelefone.gridy = 4;
		add(txtTelefone, gbc_txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 4;
		add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.gridwidth = 2;
		gbc_txtEmail.gridx = 3;
		gbc_txtEmail.gridy = 4;
		add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblGenero = new JLabel("G\u00EAnero");
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.anchor = GridBagConstraints.EAST;
		gbc_lblGenero.insets = new Insets(0, 0, 0, 5);
		gbc_lblGenero.gridx = 0;
		gbc_lblGenero.gridy = 5;
		add(lblGenero, gbc_lblGenero);
		
		cbGenero = new JComboBox();
		GridBagConstraints gbc_cbGenero = new GridBagConstraints();
		gbc_cbGenero.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbGenero.insets = new Insets(0, 0, 0, 5);
		gbc_cbGenero.gridx = 1;
		gbc_cbGenero.gridy = 5;
		add(cbGenero, gbc_cbGenero);
		
		// Adicionando as UF's no combobox..
		for (UF uf : UF.values()) 
			cbUF.addItem(uf);
	
		// Adicionando os Generos no combobox
		for (Genero genero : Genero.values())
			cbGenero.addItem(genero);
	}
	
	private Cliente getDados(){
		Cliente c = new Cliente();
		
		c.setId(Integer.parseInt(txtID.getText()));
		c.setNome(txtNome.getText());
		c.setTelefone(txtTelefone.getText());
		c.setEmail(txtEmail.getText());
		c.setEndereco(txtEndereco.getText());
		c.setUf((UF) cbUF.getSelectedItem());
		c.setGenero((Genero) cbGenero.getSelectedItem());
		c.setCidade(txtCidade.getText());
		
		return c;
	}

	public Runnable getAcaoSalvar() {
		return () -> System.out.println("Salvando..");
	}

	public Runnable getAcaoFechar(Runnable acao) {
		return acao;
	}

	public Runnable getAcaoExcluir() {
		
		return null;
	}
}
