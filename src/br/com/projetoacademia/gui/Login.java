package br.com.projetoacademia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.com.projetoacademia.entidades.Usuario;
import br.com.projetoacademia.excecoes.BusinessException;
import br.com.projetoacademia.excecoes.DaoException;
import br.com.projetoacademia.facade.Facade;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTextField textUsuario;
	private JPasswordField pfSenha;
	private JFrame principal;
	private JLabel lblData;

	public Login(JFrame principal) {
		
		this.principal = principal;
		
		init();
	}
	
	private void init(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/br/com/imagens/icon.png")));
		setTitle("LOGIN");
		setBounds(100, 100, 452, 366);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(new Color(220, 20, 60));
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(Login.DO_NOTHING_ON_CLOSE);

		setLocationRelativeTo(null); // centraliza
		setResizable(false);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(-16, 285, 479, 33);
			buttonPane.setBorder(new LineBorder(SystemColor.inactiveCaption));
			contentPanel.add(buttonPane);
			buttonPane.setBackground(Color.WHITE);
			{
				JButton okButton = new JButton("Entrar");
				okButton.setBounds(275, 5, 82, 23);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Principal.lblUsuario.setText(textUsuario.getText());
						
						try {
							Usuario usuario = Facade.getInstance().logar(textUsuario.getText(), new String(pfSenha.getPassword()));
							if(usuario!=null){
								dispose();
							}else{
								JOptionPane.showMessageDialog(null, "Usuário ou Senha INCORRETOS\n DIGITE NOVAMENTE!");
							}
						} catch (BusinessException e1) {
							JOptionPane.showMessageDialog(null, "Ocorreu um problema ao tentar efetuar o login.\nVerifique o log de erros e o acesso a base de dados.");
						}
					}
				});
				buttonPane.setLayout(null);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Sair");
				cancelButton.setBounds(367, 5, 82, 23);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int op = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do Sistema ?");
						if(op == 0){
							Login.this.dispose();
							Login.this.principal.dispose();
						}
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/br/com/imagens/Login.png")));
		lblNewLabel.setBounds(0, 11, 444, 91);
		contentPanel.add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblUsuario.setBounds(40, 145, 59, 14);
		contentPanel.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSenha.setBounds(40, 191, 59, 14);
		contentPanel.add(lblSenha);
		
		textUsuario = new JTextField();
		textUsuario.setCaretColor(Color.LIGHT_GRAY);
		textUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		textUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				tf_NomeKeyReleased(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				tf_NomeKeyReleased(e);
			}
		});
		textUsuario.setBounds(115, 142, 265, 27);
		contentPanel.add(textUsuario);
		textUsuario.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(115, 187, 265, 27);
		contentPanel.add(pfSenha);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 249, 200, 24);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHora.setForeground(new Color(30, 144, 255));
		lblHora.setBounds(0, 0, 200, 25);
		panel.add(lblHora);
		
		Principal.exibirHoraAtual(lblHora);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(244, 249, 200, 24);
		contentPanel.add(panel_1);
		
		lblData = new JLabel("Hora");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setForeground(new Color(30, 144, 255));
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblData.setBounds(0, 0, 200, 25);
		panel_1.add(lblData);
		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		lblData.setText(df.format(c.getTime()));
		
		setModal(true);
	}
	
	private void tf_NomeKeyReleased(java.awt.event.KeyEvent evt) {                                      
	       textUsuario = (JTextField) evt.getComponent();  
	       if (evt.getKeyCode()!=32 & evt.getKeyCode()!=8 & evt.getKeyCode()!=37 & evt.getKeyCode()!=39)  
	    	   textUsuario.setText(textUsuario.getText().toUpperCase());  
	   }

	public static JTextField getTextUsuario() {
		return textUsuario;
	}

	
}
