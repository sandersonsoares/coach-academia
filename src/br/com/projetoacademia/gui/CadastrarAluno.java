package br.com.projetoacademia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import br.com.projetoacademia.entidades.Aluno;
import br.com.projetoacademia.entidades.Endereco;
import br.com.projetoacademia.entidades.Instrutor;
import br.com.projetoacademia.excecoes.BusinessException;
import br.com.projetoacademia.excecoes.DaoException;
import br.com.projetoacademia.facade.Facade;
import br.com.projetoacademia.service.WebServiceCep;

public class CadastrarAluno extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Aluno aluno;
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textProfissao;
	private JTextField textEmail;
	private JTextField textObs;
	private JTextField textCep;
	private JTextField textEndereco;
	private JTextField textCidade;
	private JTextField textBairro;
	private JTextField textNumero;
	private JTextField textObsEndereco;
	private JTextField textTelefone;
	private JTextField textCelular;
	private JComboBox cbUf;
	private JPanel panelEndereco;
	private JFormattedTextField tfCep;
	private JFormattedTextField textTel;
	private JFormattedTextField textCel;
	JFormattedTextField tfCpf;
	private JComboBox cbSexo;
	private JComboBox<Instrutor> cbInstrutor;
	private JLabel lblCidade;
	private JButton btnSalvar;
	Color defaultColor;
	private JTextField textDataNascimento;
	private JButton btnEditar;

	/**
	 * Create the dialog.
	 */
	public CadastrarAluno() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarAluno.class.getResource("/br/com/imagens/adicionar_usuario.png")));
		setTitle("Cadastrar Aluno");

		this.aluno = new Aluno("", "", null);

		setBounds(100, 100, 789, 550);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);

		panelEndereco = new JPanel();
		panelEndereco.setBackground(Color.WHITE);
		panelEndereco.setBorder(new TitledBorder(null, "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TitledBorder.titleColor")));
		panelEndereco.setBounds(19, 258, 743, 174);
		contentPanel.add(panelEndereco);
		panelEndereco.setLayout(null);

		JLabel lblCep = new JLabel("CEP: *");
		lblCep.setBounds(10, 27, 46, 14);
		panelEndereco.add(lblCep);
		JFormattedTextField cep = null;
		try {
			tfCep = new JFormattedTextField(new MaskFormatter("#####-###"));
			tfCep.setBackground(Color.WHITE);
			tfCep.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					buscaCep();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		textCep = tfCep;
		textCep.setColumns(10);
		textCep.setBounds(10, 43, 223, 23);
		panelEndereco.add(textCep);

		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(257, 43, 473, 23);
		panelEndereco.add(textEndereco);

		JLabel lblEndereo = new JLabel("Endere\u00E7o: *");
		lblEndereo.setBounds(257, 27, 108, 14);
		panelEndereco.add(lblEndereo);

		textCidade = new JTextField();
		textCidade.setColumns(10);
		textCidade.setBounds(267, 90, 265, 23);
		panelEndereco.add(textCidade);

		textBairro = new JTextField();
		textBairro.setColumns(10);
		textBairro.setBounds(10, 90, 243, 23);
		panelEndereco.add(textBairro);

		JLabel lblBairro = new JLabel("Bairro: *");
		lblBairro.setBounds(10, 74, 79, 14);
		panelEndereco.add(lblBairro);

		textNumero = new JTextField();
		textNumero.setColumns(10);
		textNumero.setBounds(546, 90, 108, 23);
		panelEndereco.add(textNumero);

		JLabel lblNumero = new JLabel("N\u00FAmero: *");
		lblNumero.setBounds(546, 74, 79, 14);
		panelEndereco.add(lblNumero);

		textObsEndereco = new JTextField();
		textObsEndereco.setColumns(10);
		textObsEndereco.setBounds(313, 133, 417, 23);
		panelEndereco.add(textObsEndereco);

		JLabel label_6 = new JLabel("Observa\u00E7\u00F5es / Ponto de Refer\u00EAncia:");
		label_6.setBounds(313, 117, 223, 14);
		panelEndereco.add(label_6);

		cbUf = new JComboBox();
		cbUf.setModel(new DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cbUf.setBounds(666, 90, 64, 23);
		panelEndereco.add(cbUf);

		JLabel lblUf = new JLabel("UF: *");
		lblUf.setBounds(666, 74, 43, 14);
		panelEndereco.add(lblUf);
		try {
			textTel = new JFormattedTextField(new MaskFormatter("(##)####-####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		textTel.setBounds(10, 133, 147, 23);
		panelEndereco.add(textTel);
		textTelefone = textTel;
		textTelefone.setColumns(10);

		JLabel label_8 = new JLabel("Telefone:");
		label_8.setBounds(10, 117, 79, 14);
		panelEndereco.add(label_8);
		try {
			textCel = new JFormattedTextField(new MaskFormatter("(##)####-####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		textCel.setBounds(171, 133, 128, 23);
		panelEndereco.add(textCel);
		textCelular = textCel;
		textCelular.setColumns(10);

		JLabel label_9 = new JLabel("Celular:");
		label_9.setBounds(171, 117, 132, 14);
		panelEndereco.add(label_9);

		lblCidade = new JLabel("Cidade: *");
		lblCidade.setBounds(267, 74, 98, 14);
		panelEndereco.add(lblCidade);

		JFormattedTextField tel = null;
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}

		JFormattedTextField cel = null;
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}

		JPanel panelDadosPessoais = new JPanel();
		panelDadosPessoais.setBorder(new TitledBorder(null, "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDadosPessoais.setBackground(Color.WHITE);
		panelDadosPessoais.setBounds(19, 52, 590, 174);
		contentPanel.add(panelDadosPessoais);
		panelDadosPessoais.setLayout(null);

		textObs = new JTextField();
		textObs.setBounds(10, 131, 288, 23);
		panelDadosPessoais.add(textObs);
		textObs.setColumns(10);

		JLabel lblNomeDoPai = new JLabel("Observa\u00E7\u00E3o / Respons\u00E1vel:");
		lblNomeDoPai.setBounds(10, 115, 217, 14);
		panelDadosPessoais.add(lblNomeDoPai);

		textProfissao = new JTextField();
		textProfissao.setBounds(10, 84, 181, 23);
		panelDadosPessoais.add(textProfissao);
		textProfissao.setColumns(10);

		JLabel lblProfisso = new JLabel("Profiss\u00E3o:");
		lblProfisso.setBounds(10, 68, 71, 14);
		panelDadosPessoais.add(lblProfisso);

		textNome = new JTextField();
		textNome.setBounds(10, 41, 260, 23);
		defaultColor = textNome.getBackground();
		panelDadosPessoais.add(textNome);
		textNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome: *");
		lblNome.setBounds(10, 25, 71, 14);
		panelDadosPessoais.add(lblNome);

		JLabel lblCpf = new JLabel("CPF: *");
		lblCpf.setBounds(284, 25, 46, 14);
		panelDadosPessoais.add(lblCpf);

		try {
			tfCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		textCpf = tfCpf;
		textCpf.setBounds(284, 41, 126, 23);
		panelDadosPessoais.add(textCpf);
		textCpf.setColumns(10);

		textEmail = new JTextField();
		textEmail.setBounds(205, 84, 205, 23);
		panelDadosPessoais.add(textEmail);
		textEmail.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(205, 68, 71, 14);
		panelDadosPessoais.add(lblEmail);

		cbSexo = new JComboBox();
		cbSexo.setModel(new DefaultComboBoxModel(new String[] { Aluno.MASCULINO, Aluno.FEMININO }));
		cbSexo.setBounds(426, 84, 138, 23);
		panelDadosPessoais.add(cbSexo);

		JLabel lblSexo = new JLabel("Sexo: *");
		lblSexo.setBounds(428, 68, 71, 14);
		panelDadosPessoais.add(lblSexo);

		JFormattedTextField data = null;
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento: *");
		lblDataDeNascimento.setBounds(418, 25, 146, 14);
		panelDadosPessoais.add(lblDataDeNascimento);

		JLabel lblInstrutor = new JLabel("Instrutor:");
		lblInstrutor.setBounds(312, 115, 165, 14);
		panelDadosPessoais.add(lblInstrutor);

		cbInstrutor = new JComboBox();
		cbInstrutor.setModel(new DefaultComboBoxModel(new String[] { "<Nenhum>" }));
		adicionarInstrutores();
		cbInstrutor.setBounds(312, 131, 252, 23);
		panelDadosPessoais.add(cbInstrutor);

		try {
			textDataNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		textDataNascimento.setBounds(418, 41, 146, 23);
		panelDadosPessoais.add(textDataNascimento);
		textDataNascimento.setColumns(10);

		JPanel panelFoto = new JPanel();
		panelFoto.setBorder(new TitledBorder(null, "Foto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFoto.setBackground(Color.WHITE);
		panelFoto.setBounds(623, 52, 139, 174);
		contentPanel.add(panelFoto);

		JPanel buttonPane = new JPanel();
		buttonPane.setBorder(new LineBorder(SystemColor.inactiveCaption));
		buttonPane.setBounds(0, 470, 794, 34);
		contentPanel.add(buttonPane);
		buttonPane.setBackground(Color.WHITE);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(24, 5, 100, 23);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (verifica()) {
					if (aluno.getNome().equals("")) {
						salvaNovoAluno();
						dispose();
					} else {
						int op = JOptionPane.showConfirmDialog(null, "Deseja Realmente EDITAR ?");
						if (op == 0) {
							editarNovoAluno();
							dispose();
						}
					}
				}

			}
		});
		buttonPane.setLayout(null);
		btnSalvar.setBackground(UIManager.getColor("Button.background"));
		btnSalvar.setActionCommand("OK");
		buttonPane.add(btnSalvar);
		getRootPane().setDefaultButton(btnSalvar);

		JButton cancelButton = new JButton("Cancelar");
		cancelButton.setBounds(661, 5, 100, 23);
		cancelButton.setBackground(UIManager.getColor("Button.background"));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrarAluno.this.dispose();
			}
		});
		cancelButton.setActionCommand("Cancelar");
		buttonPane.add(cancelButton);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				liberarCampos();
				setarCoresAtivas();
				btnSalvar.setEnabled(true);
				btnEditar.setEnabled(false);
			}
		});
		btnEditar.setEnabled(false);
		btnEditar.setBackground(SystemColor.menu);
		btnEditar.setActionCommand("OK");
		btnEditar.setBounds(138, 5, 100, 23);
		buttonPane.add(btnEditar);
		setModal(true);
	}

	private void adicionarInstrutores() {
//		List<Instrutor> instrutores = pessoaDao.listarInstrutores();
//		for (Instrutor instrutor : instrutores) {
//			cbInstrutor.addItem(instrutor);
//		}

	}

	protected void preencherCadastro() {
		Aluno pessoa = new Aluno("", "", null);
		pessoa = (Aluno) this.aluno;
		textNome.setText(pessoa.getNome());
		textCpf.setText(pessoa.getCpf());
		textDataNascimento.setText("pessoa.getDataNascimento()");
		textProfissao.setText(pessoa.getProfissao());
		textEmail.setText(pessoa.getEmail());
		textObs.setText(pessoa.getObs());
		textCep.setText(pessoa.getEndereco().getCep());
		textEndereco.setText(pessoa.getEndereco().getEndereco());
		textCidade.setText(pessoa.getEndereco().getCidade());
		textBairro.setText(pessoa.getEndereco().getBairro());
		textNumero.setText(pessoa.getEndereco().getNumero());
		cbUf.setSelectedItem(pessoa.getEndereco().getUf());
		cbSexo.setSelectedItem(pessoa.getSexo());
		textObsEndereco.setText(pessoa.getEndereco().getObs());
		textTel.setText(pessoa.getEndereco().getCelular());
		textCel.setText(pessoa.getEndereco().getTelefone());
		cbInstrutor.setSelectedItem(pessoa.getInstrutor());
	}

	public void buscaCep() {
		// Faz a busca para o cep
		WebServiceCep webServiceCep = WebServiceCep.searchCep(textCep.getText());
		// A ferramenta de busca ignora qualquer caracter que n?o seja n?mero.

		// caso a busca ocorra bem, imprime os resultados.
		if (webServiceCep.wasSuccessful()) {
			textEndereco.setText(webServiceCep.getLogradouroFull());
			textCidade.setText(webServiceCep.getCidade());
			textBairro.setText(webServiceCep.getBairro());
			cbUf.setSelectedItem(webServiceCep.getUf());
			// caso haja problemas imprime as exce??es.
		} else {
			JOptionPane.showMessageDialog(null, "Erro: " + webServiceCep.getResultText());
		}
	}

	public Aluno salvarAluno() {
		Aluno novoAluno = new Aluno(textNome.getText(), textCpf.getText(), new Endereco(textEndereco.getText(), textCidade.getText(), textCep.getText()));
		novoAluno.setDataNascimento(Calendar.getInstance());
		novoAluno.setEmail(textEmail.getText());
		novoAluno.setProfissao(textProfissao.getText());
		novoAluno.setSexo(cbSexo.getSelectedItem().toString());
		if (cbInstrutor.getSelectedIndex() != 0) {
			novoAluno.setInstrutor((Instrutor) cbInstrutor.getSelectedItem());
		}
		novoAluno.setObs(textObs.getText());
		novoAluno.getEndereco().setBairro(textBairro.getText());
		;
		novoAluno.getEndereco().setNumero(textNumero.getText());
		novoAluno.getEndereco().setUf(cbUf.getSelectedItem().toString());
		novoAluno.getEndereco().setObs(textObsEndereco.getText());
		novoAluno.getEndereco().setTelefone(textTel.getText());
		novoAluno.getEndereco().setCelular(textCel.getText());
		return novoAluno;
	}

	public void editarAluno() {
		aluno.setNome(textNome.getText());
		aluno.setCpf(textCpf.getText());
		aluno.getEndereco().setEndereco(textEndereco.getText());
		aluno.getEndereco().setCidade(textCidade.getText());
		aluno.getEndereco().setCep(textCep.getText());
		aluno.setDataNascimento(Calendar.getInstance());
		aluno.setEmail(textEmail.getText());
		aluno.setProfissao(textProfissao.getText());
		aluno.setSexo(cbSexo.getSelectedItem().toString());
		if (cbInstrutor.getSelectedIndex() != 0) {
			aluno.setInstrutor((Instrutor) cbInstrutor.getSelectedItem());
		}
		aluno.setObs(textObs.getText());
		aluno.getEndereco().setBairro(textBairro.getText());
		;
		aluno.getEndereco().setNumero(textNumero.getText());
		aluno.getEndereco().setUf(cbUf.getSelectedItem().toString());
		aluno.getEndereco().setObs(textObsEndereco.getText());
		aluno.getEndereco().setTelefone(textTel.getText());
		aluno.getEndereco().setCelular(textCel.getText());
	}

	public boolean verifica() {

		if (textDataNascimento.getText().equals("  /  /    ")) {
			textDataNascimento.setBackground(new Color(250, 235, 215));
			JOptionPane.showMessageDialog(null, "Campo Vazio!");
			return false;
		}

		if (textCep.getText().equals("     -   ")) {
			textCep.setBackground(new Color(250, 235, 215));
			JOptionPane.showMessageDialog(null, "Campo Vazio!");
			return false;
		}

		if (textNome.getText().isEmpty()) {
			textNome.setBackground(new Color(250, 235, 215));
			JOptionPane.showMessageDialog(null, "Campo Vazio!");
			return false;
		}

		if (textCpf.getText().equals("   .   .   -  ")) {
			textCpf.setBackground(new Color(250, 235, 215));
			JOptionPane.showMessageDialog(null, "Campo Vazio!");
			return false;
		}

		if (textEndereco.getText().isEmpty()) {
			textEndereco.setBackground(new Color(250, 235, 215));
			JOptionPane.showMessageDialog(null, "Campo Vazio!");
			return false;
		}

		if (textBairro.getText().isEmpty()) {
			textBairro.setBackground(new Color(250, 235, 215));
			JOptionPane.showMessageDialog(null, "Campo Vazio!");
			return false;
		}

		if (textCidade.getText().isEmpty()) {
			textCidade.setBackground(new Color(250, 235, 215));
			JOptionPane.showMessageDialog(null, "Campo Vazio!");
			return false;
		}

		if (textNumero.getText().isEmpty()) {
			textNumero.setBackground(new Color(250, 235, 215));
			JOptionPane.showMessageDialog(null, "Campo Vazio!");
			return false;
		}

		return true;
	}

	public void salvaNovoAluno() {
		Aluno novoAluno = salvarAluno();
		try {
			Facade.getInstance().salvarOuAtualizarAluno(novoAluno);
			JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
			CadastrarAluno.this.dispose();
		} catch (BusinessException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void editarNovoAluno() {
		editarAluno();
		try {
			Facade.getInstance().salvarOuAtualizarAluno(aluno);
			JOptionPane.showMessageDialog(null, "Editado com Sucesso!");
			CadastrarAluno.this.dispose();
		} catch (BusinessException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	public void liberarCampos() {
		textNome.setEditable(true);
		textCpf.setEditable(true);
		textDataNascimento.setEditable(true);
		textProfissao.setEditable(true);
		textEmail.setEditable(true);
		textObs.setEditable(true);
		textCep.setEditable(true);
		textEndereco.setEditable(true);
		textCidade.setEditable(true);
		textBairro.setEditable(true);
		textNumero.setEditable(true);
		cbUf.setEnabled(true);
		cbSexo.setEnabled(true);
		textObsEndereco.setEditable(true);
		textTel.setEditable(true);
		textCel.setEditable(true);
		cbInstrutor.setEnabled(true);
	}

	public void bloquearCampos() {
		textNome.setEditable(false);
		textCpf.setEditable(false);
		textDataNascimento.setEditable(false);
		textProfissao.setEditable(false);
		textEmail.setEditable(false);
		textObs.setEditable(false);
		textCep.setEditable(false);
		textEndereco.setEditable(false);
		textCidade.setEditable(false);
		textBairro.setEditable(false);
		textNumero.setEditable(false);
		cbUf.setEnabled(false);
		cbSexo.setEnabled(false);
		textObsEndereco.setEditable(false);
		textTel.setEditable(false);
		textCel.setEditable(false);
		cbInstrutor.setEnabled(false);
	}

	public Aluno getPessoa() {
		return aluno;
	}

	public void setPessoa(Aluno pessoa) {
		this.aluno = pessoa;
	}

	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public JTextField getTextNome() {
		return textNome;
	}

	public void setTextNome(JTextField textNome) {
		this.textNome = textNome;
	}

	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public void setarCoresAtivas() {
		textCep.setBackground(defaultColor);
		textDataNascimento.setBackground(defaultColor);
		textNome.setBackground(defaultColor);
		textCpf.setBackground(defaultColor);
		textEndereco.setBackground(defaultColor);
		textBairro.setBackground(defaultColor);
		textNumero.setBackground(defaultColor);
		textCidade.setBackground(defaultColor);
	}

	public void setarCoresDesativas() {
		textCep.setBackground(SystemColor.control);
		textDataNascimento.setBackground(SystemColor.control);
		textNome.setBackground(SystemColor.control);
		textCpf.setBackground(SystemColor.control);
		textEndereco.setBackground(SystemColor.control);
		textBairro.setBackground(SystemColor.control);
		textNumero.setBackground(SystemColor.control);
		textCidade.setBackground(SystemColor.control);
	}
}
