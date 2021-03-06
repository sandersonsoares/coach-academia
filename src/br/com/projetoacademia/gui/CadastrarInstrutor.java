package br.com.projetoacademia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.Action;
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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import br.com.projetoacademia.entidades.Endereco;
import br.com.projetoacademia.entidades.Instrutor;
import br.com.projetoacademia.enums.RegiaoCREFEnum;
import br.com.projetoacademia.service.WebServiceCep;

public class CadastrarInstrutor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Instrutor pessoa;
	private JTextField textNome;
	private JTextField textCpf;
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
	private JTextField textCref;
	private JTextField textSalario;
	private JComboBox cbUf;
	private JPanel panelEndereco;
	private JFormattedTextField tfCep;
	private JFormattedTextField textTel;
	private JFormattedTextField textCel;
	JFormattedTextField tfCpf;
	private JComboBox cbSexo;
	private JLabel lblCidade;
	private JButton btnSalvar;
	private JButton btnEditar;
	Color defaultColor;
	private JTextField textDataNascimento;
	private JPanel panelInstrutor;
	private JTextField txtNumeroCref;
	private JComboBox comboBox;
	private JLabel lblSalrio;
	private JFormattedTextField textField;
	private String salarioFieldValue;
	private JTextField txtSalario;

	/**
	 * Create the dialog.
	 */
	public CadastrarInstrutor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarInstrutor.class.getResource("/br/com/imagens/adicionar_usuario.png")));
		setTitle("Cadastrar Instrutor");
		
		salarioFieldValue = "";
		
		this.pessoa = new Instrutor("", "", null);
		
		setBounds(100, 100, 791, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		panelEndereco = new JPanel();
		panelEndereco.setBackground(Color.WHITE);
		panelEndereco.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelEndereco.setBounds(19, 258, 743, 174);
		contentPanel.add(panelEndereco);
		panelEndereco.setLayout(null);
		
		JLabel lblCep = new JLabel("CEP: *");
		lblCep.setBounds(10, 27, 46, 14);
		panelEndereco.add(lblCep);
		JFormattedTextField cep=null;
		try{
		tfCep = new JFormattedTextField(new MaskFormatter("#####-###"));
		tfCep.setBackground(Color.WHITE);
		tfCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscaCep();
			}
		});
		}catch (Exception e) {
			e.printStackTrace();
		}
		textCep = tfCep;
		textCep.setColumns(10);
		textCep.setBounds(10, 43, 174, 23);
		panelEndereco.add(textCep);
		
		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(198, 43, 532, 23);
		panelEndereco.add(textEndereco);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o: *");
		lblEndereo.setBounds(199, 27, 98, 14);
		panelEndereco.add(lblEndereo);
		
		textCidade = new JTextField();
		textCidade.setColumns(10);
		textCidade.setBounds(267, 90, 227, 23);
		panelEndereco.add(textCidade);
		
		textBairro = new JTextField();
		textBairro.setColumns(10);
		textBairro.setBounds(10, 90, 243, 23);
		panelEndereco.add(textBairro);
		
		JLabel lblBairro = new JLabel("Bairro: *");
		lblBairro.setBounds(10, 74, 64, 14);
		panelEndereco.add(lblBairro);
		
		textNumero = new JTextField();
		textNumero.setColumns(10);
		textNumero.setBounds(508, 90, 126, 23);
		panelEndereco.add(textNumero);
		
		JLabel lblNumero = new JLabel("N\u00FAmero: *");
		lblNumero.setBounds(508, 74, 82, 14);
		panelEndereco.add(lblNumero);
		
		textObsEndereco = new JTextField();
		textObsEndereco.setColumns(10);
		textObsEndereco.setBounds(313, 133, 417, 23);
		panelEndereco.add(textObsEndereco);
		
		JLabel label_6 = new JLabel("Observa\u00E7\u00F5es / Ponto de Refer\u00EAncia:");
		label_6.setBounds(313, 117, 227, 14);
		panelEndereco.add(label_6);
		
		cbUf = new JComboBox();
		cbUf.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cbUf.setBounds(648, 90, 82, 23);
		panelEndereco.add(cbUf);
		
		JLabel lblUf = new JLabel("UF: *");
		lblUf.setBounds(648, 74, 35, 14);
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
		label_8.setBounds(10, 117, 89, 14);
		panelEndereco.add(label_8);
		try {
			textCel = new JFormattedTextField(new MaskFormatter("(##)####-####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		textCel.setBounds(171, 133, 126, 23);
		panelEndereco.add(textCel);
		textCelular = textCel;
		textCelular.setColumns(10);
		
		JLabel label_9 = new JLabel("Celular:");
		label_9.setBounds(171, 117, 132, 14);
		panelEndereco.add(label_9);
		
		lblCidade = new JLabel("Cidade: *");
		lblCidade.setBounds(267, 74, 82, 14);
		panelEndereco.add(lblCidade);
		
		JFormattedTextField tel=null;
		try{
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		JFormattedTextField cel=null;
		try{
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		JPanel panelDadosPessoais = new JPanel();
		panelDadosPessoais.setBorder(new TitledBorder(null, "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDadosPessoais.setBackground(Color.WHITE);
		panelDadosPessoais.setBounds(19, 52, 590, 174);
		contentPanel.add(panelDadosPessoais);
		panelDadosPessoais.setLayout(null);
		
		textObs = new JTextField();
		textObs.setBounds(10, 131, 566, 23);
		panelDadosPessoais.add(textObs);
		textObs.setColumns(10);
		
		JLabel lblNomeDoPai = new JLabel("Observa\u00E7\u00E3o / Respons\u00E1vel:");
		lblNomeDoPai.setBounds(10, 115, 188, 14);
		panelDadosPessoais.add(lblNomeDoPai);
		
		
		textNome = new JTextField();
		textNome.setBounds(10, 41, 278, 23);
		defaultColor = textNome.getBackground();
		panelDadosPessoais.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome: *");
		lblNome.setBounds(10, 25, 71, 14);
		panelDadosPessoais.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF: *");
		lblCpf.setBounds(302, 25, 46, 14);
		panelDadosPessoais.add(lblCpf);
		
		try{
		tfCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		textCpf = tfCpf;
		textCpf.setBounds(302, 41, 126, 23);
		panelDadosPessoais.add(textCpf);
		textCpf.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(10, 84, 374, 23);
		panelDadosPessoais.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 68, 71, 14);
		panelDadosPessoais.add(lblEmail);
		
		cbSexo = new JComboBox();
		cbSexo.setModel(new DefaultComboBoxModel(new String[] {Instrutor.MASCULINO, Instrutor.FEMININO}));
		cbSexo.setBounds(398, 84, 178, 23);
		panelDadosPessoais.add(cbSexo);
		
		JLabel lblSexo = new JLabel("Sexo: *");
		lblSexo.setBounds(398, 68, 71, 14);
		panelDadosPessoais.add(lblSexo);
		
		JFormattedTextField data=null;
		try{
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento: *");
		lblDataDeNascimento.setBounds(442, 25, 158, 14);
		panelDadosPessoais.add(lblDataDeNascimento);
		
		try {
			textDataNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		textDataNascimento.setBounds(442, 41, 134, 23);
		panelDadosPessoais.add(textDataNascimento);
		textDataNascimento.setColumns(10);
		
		JPanel panelFoto = new JPanel();
		panelFoto.setBorder(new TitledBorder(null, "Foto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFoto.setBackground(Color.WHITE);
		panelFoto.setBounds(623, 52, 139, 174);
		contentPanel.add(panelFoto);

		JPanel buttonPane = new JPanel();
		buttonPane.setBorder(new LineBorder(SystemColor.inactiveCaption));
		buttonPane.setBounds(-15, 527, 817, 34);
		contentPanel.add(buttonPane);
		buttonPane.setBackground(Color.WHITE);
		
				btnSalvar = new JButton("Salvar");
				btnSalvar.setBounds(39, 5, 100, 23);
				btnSalvar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (verifica()) {
							if (pessoa.getNome().equals("")) {
								salvaNovoInstrutor();
								dispose();
							} else {
								int op = JOptionPane.showConfirmDialog(null, "Deseja Realmente EDITAR ?");
								if (op == 0) {
									editarNovoInstrutor();
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
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				liberarCampos();
				setarCoresAtivas();
				btnSalvar.setEnabled(true);
				btnEditar.setEnabled(false);
			}
		});
		btnEditar.setBounds(153, 5, 100, 23);
		btnEditar.setBackground(UIManager.getColor("Button.background"));
		btnEditar.setEnabled(false);
		btnEditar.setActionCommand("OK");
		buttonPane.add(btnEditar);

		JButton cancelButton = new JButton("Cancelar");
		cancelButton.setBounds(676, 5, 100, 23);
		cancelButton.setBackground(UIManager.getColor("Button.background"));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrarInstrutor.this.dispose();
			}
		});
		cancelButton.setActionCommand("Cancelar");
		buttonPane.add(cancelButton);
		
		panelInstrutor = new JPanel();
		panelInstrutor.setBackground(Color.WHITE);
		panelInstrutor.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelInstrutor.setBounds(19, 439, 743, 76);
		contentPanel.add(panelInstrutor);
		panelInstrutor.setLayout(null);
		
		JLabel lblCref = new JLabel("Nº CREF: *");
		lblCref.setBounds(12, 24, 77, 14);
		panelInstrutor.add(lblCref);
		
		txtNumeroCref = new JTextField();
		txtNumeroCref.setBounds(12, 45, 114, 23);
		panelInstrutor.add(txtNumeroCref);
		txtNumeroCref.setColumns(10);
		
		JLabel lblRegioCref = new JLabel("Região CREF:*");
		lblRegioCref.setBounds(162, 24, 103, 15);
		panelInstrutor.add(lblRegioCref);
		
		comboBox = new JComboBox();
		comboBox.setBounds(162, 45, 135, 23);
		comboBox.addItem(null);
		for(RegiaoCREFEnum regiao : RegiaoCREFEnum.values()){
			comboBox.addItem(regiao.getRegiaoCREF());
		}
		panelInstrutor.add(comboBox);
		
		lblSalrio = new JLabel("Salário:");
		lblSalrio.setBounds(324, 24, 70, 15);
		panelInstrutor.add(lblSalrio);
        
		txtSalario = new JTextField();
		txtSalario.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent keyEvent) {
				txtSalario.setText(salarioFieldValue);
			}
			
			@Override
			public void keyReleased(KeyEvent keyEvent) {
//				System.out.println("CODE: "+keyEvent.getKeyCode()+" - CHAR: "+keyEvent.getKeyChar());
				if(keyEvent.getKeyCode()>=48&&keyEvent.getKeyCode()<=57){
//					salarioFieldValue+=""+keyEvent.getKeyChar();
//					txtSalario.setText(salarioFieldValue);
					System.out.println(keyEvent.getKeyChar());
					salarioFieldValue+=keyEvent.getKeyChar();
					txtSalario.setText(salarioFieldValue);
				}
				txtSalario.setText(salarioFieldValue);
			}
			
			@Override
			public void keyPressed(KeyEvent keyEvent) {
				txtSalario.setText(salarioFieldValue);
			}
		});
        
		txtSalario.setBounds(324, 45, 114, 23);
		panelInstrutor.add(txtSalario);
		txtSalario.setColumns(10);
		setModal(true);
	}

	protected void preencherCadastro() {
		Instrutor pessoa = new Instrutor("", "", null);
		pessoa = (Instrutor) this.pessoa;
		textNome.setText(pessoa.getNome());
		textCpf.setText(pessoa.getCpf());
		textDataNascimento.setText("pessoa.getDataNascimento()");
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
	}
	
	  public void buscaCep() {
	        //Faz a busca para o cep 
	        WebServiceCep webServiceCep = WebServiceCep.searchCep(textCep.getText());
	        //A ferramenta de busca ignora qualquer caracter que n?o seja n?mero.

	        //caso a busca ocorra bem, imprime os resultados.
	        if (webServiceCep.wasSuccessful()) {
	            textEndereco.setText(webServiceCep.getLogradouroFull());
	            textCidade.setText(webServiceCep.getCidade());
	            textBairro.setText(webServiceCep.getBairro());
	            cbUf.setSelectedItem(webServiceCep.getUf());
	            //caso haja problemas imprime as exce??es.
	        } else {
	            JOptionPane.showMessageDialog(null, "Erro: " + webServiceCep.getResultText());
	        }
	    }
	  
	  public Instrutor salvarInstrutor(){
		  Instrutor novoAluno = new Instrutor(textNome.getText(), textCpf.getText(), new Endereco(textEndereco.getText(), textCidade.getText(), textCep.getText()));
			novoAluno.setDataNascimento(Calendar.getInstance());
			novoAluno.setEmail(textEmail.getText());
			novoAluno.setSexo(cbSexo.getSelectedItem().toString());
			novoAluno.setObs(textObs.getText());
			novoAluno.getEndereco().setBairro(textBairro.getText());;
			novoAluno.getEndereco().setNumero(textNumero.getText());
			novoAluno.getEndereco().setUf(cbUf.getSelectedItem().toString());
			novoAluno.getEndereco().setObs(textObsEndereco.getText());
			novoAluno.getEndereco().setTelefone(textTel.getText());
			novoAluno.getEndereco().setCelular(textCel.getText());
			return novoAluno;
	  }
	  
	  public void editarInstrutor(){
		    pessoa.setNome(textNome.getText());
		    pessoa.setCpf(textCpf.getText());
		    pessoa.getEndereco().setEndereco(textEndereco.getText());
		    pessoa.getEndereco().setCidade(textCidade.getText());
		    pessoa.getEndereco().setCep(textCep.getText());
			pessoa.setDataNascimento(Calendar.getInstance());
			pessoa.setEmail(textEmail.getText());
			pessoa.setSexo(cbSexo.getSelectedItem().toString());
			pessoa.setObs(textObs.getText());
			pessoa.getEndereco().setBairro(textBairro.getText());;
			pessoa.getEndereco().setNumero(textNumero.getText());
			pessoa.getEndereco().setUf(cbUf.getSelectedItem().toString());
			pessoa.getEndereco().setObs(textObsEndereco.getText());
			pessoa.getEndereco().setTelefone(textTel.getText());
			pessoa.getEndereco().setCelular(textCel.getText());
	  }
	  
	  public boolean verifica(){
		  
		  if(textDataNascimento.getText().equals("  /  /    ")){
			  textDataNascimento.setBackground(new Color(250, 235, 215));
			  JOptionPane.showMessageDialog(null, "Campo Vazio!");
			  return false;  
		  }
		  
		  if(textCep.getText().equals("     -   ")){
			  textCep.setBackground(new Color(250, 235, 215));
			  JOptionPane.showMessageDialog(null, "Campo Vazio!");
			  return false;
		  }
		  
		  if(textNome.getText().isEmpty()){
			  textNome.setBackground(new Color(250, 235, 215));
			  JOptionPane.showMessageDialog(null, "Campo Vazio!");
			  return false;
		  }
		  
		  if(textCpf.getText().equals("   .   .   -  ")){
			  textCpf.setBackground(new Color(250, 235, 215));
			  JOptionPane.showMessageDialog(null, "Campo Vazio!");
			  return false;
		  }
		  
		  
		  if(textEndereco.getText().isEmpty()){
			  textEndereco.setBackground(new Color(250, 235, 215));
			  JOptionPane.showMessageDialog(null, "Campo Vazio!");
			  return false;
		  }
		  
		  if(textBairro.getText().isEmpty()){
			  textBairro.setBackground(new Color(250, 235, 215));
			  JOptionPane.showMessageDialog(null, "Campo Vazio!");
			  return false;
		  }
		  
		  if(textCidade.getText().isEmpty()){
			  textCidade.setBackground(new Color(250, 235, 215));
			  JOptionPane.showMessageDialog(null, "Campo Vazio!");
			  return false;
		  }
		  
		  if(textNumero.getText().isEmpty()){
			  textNumero.setBackground(new Color(250, 235, 215));
			  JOptionPane.showMessageDialog(null, "Campo Vazio!");
			  return false;
		  }
		  
		  return true;
	  }
	  
	  public void salvaNovoInstrutor(){
		  Instrutor novoInstrutor = salvarInstrutor();
//			try {
//				CadastrarInstrutor.this.pessoaDao.salvar(novoInstrutor);
				JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
//			} catch (BusinessException e) {
//				e.printStackTrace();
//				JOptionPane.showMessageDialog(null, "Erro: Exception");
//			}
	  }
	  
	  public void editarNovoInstrutor(){
		    editarInstrutor();
			try {
//				CadastrarInstrutor.this.pessoaDao.salvarNovoArquivo();
				JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
				CadastrarInstrutor.this.dispose();
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro: Exception");
			}
			
	  }
	  
	  public void liberarCampos(){
			textNome.setEditable(true);  
			textCpf.setEditable(true);
			textDataNascimento.setEditable(true);
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
	  }
	  
	  public void bloquearCampos(){
		  textNome.setEditable(false);  
			textCpf.setEditable(false);
			textDataNascimento.setEditable(false);
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
	  }
	  
	  
	  public Instrutor getPessoa() {
			return pessoa;
		}

		public void setPessoa(Instrutor pessoa) {
			this.pessoa = pessoa;
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
		
		public JButton getBtnEditar() {
			return btnEditar;
		}

		public void setBtnEditar(JButton btnEditar) {
			this.btnEditar = btnEditar;
		}

		public void setarCoresAtivas(){
			textCep.setBackground(defaultColor);
			textDataNascimento.setBackground(defaultColor);
			textNome.setBackground(defaultColor);
			textCpf.setBackground(defaultColor);
			textEndereco.setBackground(defaultColor);
			textBairro.setBackground(defaultColor);
			textNumero.setBackground(defaultColor);
			textCidade.setBackground(defaultColor);
		}
		public void setarCoresDesativas(){
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
