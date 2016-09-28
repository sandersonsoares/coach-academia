package br.com.projetoacademia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.com.projetoacademia.comumEnums.Privilegios;
import br.com.projetoacademia.entidades.Usuario;
import br.com.projetoacademia.excecoes.BusinessException;
import br.com.projetoacademia.excecoes.DaoException;
import br.com.projetoacademia.facade.Facade;

public class CadastrarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textLogin;
	private JPasswordField pfSenha;
	private JPasswordField pfConfirmaSenha;
	private Usuario usuario;
	private JButton btnSalvar;
	private JComboBox comboBox;

	public CadastrarUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarUsuario.class.getResource("/br/com/imagens/login_icon.png")));
		setTitle("Cadastrar Usu\u00E1rio");
		setBounds(100, 100, 424, 259);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel lblLogin = new JLabel("Login:");
			lblLogin.setBounds(90, 34, 40, 19);
			contentPanel.add(lblLogin);
		}
		{
			textLogin = new JTextField();
			textLogin.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent arg0) {
					tf_NomeKeyReleased(arg0);
				}
				@Override
				public void keyReleased(KeyEvent e) {
					tf_NomeKeyReleased(e);
				}
			});
			textLogin.setBounds(139, 31, 209, 23);
			contentPanel.add(textLogin);
			textLogin.setColumns(10);
		}
		{
			JLabel lblSenha = new JLabel("Senha:");
			lblSenha.setBounds(83, 65, 45, 19);
			contentPanel.add(lblSenha);
		}
		{
			JLabel lblConfirmarSenha = new JLabel("Confirmar Senha:");
			lblConfirmarSenha.setBounds(21, 98, 109, 19);
			contentPanel.add(lblConfirmarSenha);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(SystemColor.inactiveCaption));
			buttonPane.setBounds(-11, 180, 437, 32);
			contentPanel.add(buttonPane);
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(null);
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setBounds(306, 5, 100, 23);
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
			
			btnSalvar = new JButton("Salvar");
			btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					salvarUsuario();
				}
			});
			btnSalvar.setBounds(27, 5, 100, 23);
			buttonPane.add(btnSalvar);
			btnSalvar.setActionCommand("OK");
		}
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(139, 62, 209, 23);
		contentPanel.add(pfSenha);
		
		pfConfirmaSenha = new JPasswordField();
		pfConfirmaSenha.setBounds(139, 94, 209, 23);
		contentPanel.add(pfConfirmaSenha);
		
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(getListarPrivilegios()));
		comboBox.setBounds(139, 126, 209, 23);
		contentPanel.add(comboBox);
		
		JLabel lblPrivilgio = new JLabel("Privil\u00E9gio:");
		lblPrivilgio.setBounds(71, 128, 59, 19);
		contentPanel.add(lblPrivilgio);
		
		setModal(true);
		
	}
	
	private Privilegios[] getListarPrivilegios() {
		return Privilegios.values();
		
	}

	public void salvarUsuario(){
		Usuario user = new Usuario(textLogin.getText(), pfSenha.getPassword());
		user.setPrivilegio((Privilegios) comboBox.getSelectedItem());
		try {
			if(Arrays.equals(pfSenha.getPassword(), pfConfirmaSenha.getPassword())){
				Facade.getInstance().salvarOuAtualizarUsuario(user);;
				dispose();
				JOptionPane.showMessageDialog(null, "USUÁRIO SALVO COM SUCESSO!");
			}else{
				JOptionPane.showMessageDialog(null, "Senhas não conferem!");
			}
			
		} catch (BusinessException e) {
			e.printStackTrace();
			int op = JOptionPane.showConfirmDialog(null, "Deseja realmente editar esse Usuário? ");
			if(op == 0){
				Usuario user1=null;
				try {
					user1 = Facade.getInstance().logar(textLogin.getText(), pfSenha.getPassword().toString());
					if(Arrays.equals(pfSenha.getPassword(), pfConfirmaSenha.getPassword())){
						user1.setLogin(textLogin.getText());
						user1.setSenha(pfSenha.getPassword().toString());
						user1.setPrivilegio((Privilegios) comboBox.getSelectedItem());
						dispose();
						JOptionPane.showMessageDialog(null, "Usuário editado com SUCESSO!");
					}else{
						JOptionPane.showMessageDialog(null, "Senhas não conferem!");
					}
				} catch (BusinessException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Usuário não pode ser editado");
				}
			}
		}
		
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public JButton getBtnSalvar(){
		return btnSalvar;
	}
	
	public JTextField getTextLogin() {
		return textLogin;
	}

	public void setTextLogin(String textLogin) {
		this.textLogin.setText(textLogin);
	}
	
	public void setComboBoxInfo() {
		Usuario user = null;
		try {
			user = Facade.getInstance().logar(textLogin.getText(),pfSenha.getPassword().toString());
		} catch (BusinessException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		comboBox.setSelectedItem(user.getPrivilegio());
	}

	private void tf_NomeKeyReleased(java.awt.event.KeyEvent evt) {                                      
	       textLogin = (JTextField) evt.getComponent();  
	       if (evt.getKeyCode()!=32 & evt.getKeyCode()!=8 & evt.getKeyCode()!=37 & evt.getKeyCode()!=39)  
	    	   textLogin.setText(textLogin.getText().toUpperCase());  
	   }
}
