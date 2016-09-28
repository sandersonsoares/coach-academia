package br.com.projetoacademia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projetoacademia.entidades.Usuario;
import br.com.projetoacademia.excecoes.BusinessException;
import br.com.projetoacademia.facade.Facade;

public class MenuUsuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField textBusca;
	private List<Usuario> usuarios;
	private DefaultTableModel tableModel;
	private JButton btnNovo;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnOk;
	private JButton btnBuscar;

	public MenuUsuarios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuUsuarios.class.getResource("/br/com/imagens/login_icon.png")));
		setTitle("Usu\u00E1rios");
		setBounds(100, 100, 539, 392);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JPanel buttonPane = new JPanel();
		buttonPane.setBorder(new LineBorder(SystemColor.inactiveCaption));
		buttonPane.setBackground(Color.WHITE);
		buttonPane.setBounds(0, 314, 532, 32);
		contentPanel.add(buttonPane);
		buttonPane.setLayout(null);

		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrarUsuario ca = new CadastrarUsuario();
				ca.setVisible(true);
			}
		});
		btnNovo.setBounds(10, 5, 70, 23);
		btnNovo.setActionCommand("OK");
		buttonPane.add(btnNovo);

		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuUsuarios.this.dispose();
			}
		});
		btnOk.setBounds(475, 5, 47, 23);
		btnOk.setActionCommand("OK");
		buttonPane.add(btnOk);
		getRootPane().setDefaultButton(btnOk);

		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = (String) table.getValueAt(table.getSelectedRow(), 0);
				CadastrarUsuario ca = new CadastrarUsuario();
				ca.setTextLogin(login);
				ca.setComboBoxInfo();
				ca.setVisible(true);
			}
		});
		btnEditar.setActionCommand("OK");
		btnEditar.setBounds(90, 5, 70, 23);
		buttonPane.add(btnEditar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = (String) table.getValueAt(table.getSelectedRow(), 0);
				try {
					int op = JOptionPane.showConfirmDialog(null, "Deseja Realmente excluir este Usu�rio ?");
					if(op == 0){
//						Alterar para remover o usuário selecionado
//						MenuUsuarios.this.usuarioDao.excluirUsuario(login);
						JOptionPane.showMessageDialog(null, "Usu�rio exclu�do com Sucesso!");
						textBusca.setText("");
						listarUsuarios();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao Excluir!");
				}
			}
		});
		btnExcluir.setActionCommand("OK");
		btnExcluir.setBounds(171, 5, 70, 23);
		buttonPane.add(btnExcluir);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 512, 195);
		contentPanel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnEditar.setEnabled(true);
				btnExcluir.setEnabled(true);
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Usu\u00E1rio/login" }));
		scrollPane.setViewportView(table);

		tableModel = (DefaultTableModel) table.getModel();
		table.setModel(tableModel);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Buscar Avaliado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 14, 512, 83);
		contentPanel.add(panel);

		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setBounds(31, 24, 73, 14);
		panel.add(lblUsuario);

		textBusca = new JTextField();
		textBusca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				tf_NomeKeyReleased(arg0);
				listarUsuarios();
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				tf_NomeKeyReleased(arg0);
				listarUsuarios();
			}
		});
		textBusca.setColumns(10);
		textBusca.setBounds(31, 41, 332, 23);
		panel.add(textBusca);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarUsuarios();
			}
		});
		btnBuscar.setBounds(390, 40, 89, 23);
		panel.add(btnBuscar);
		
		setModal(true);
	}

	private void listarUsuarios() {
		String login = textBusca.getText();
		try {
			usuarios = Facade.getInstance().listarTodosUsuarios();
		} catch (BusinessException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um problema ao tentar listar todos os usuários do sistema.");
			e.printStackTrace();
		}

		while (tableModel.getRowCount() != 0) {
			tableModel.removeRow(0);
		}

		for (Usuario usuario : usuarios) {
			tableModel.addRow(new String[] { usuario.getLogin() });
		}
	}
	
	private void tf_NomeKeyReleased(java.awt.event.KeyEvent evt) {                                      
	       textBusca = (JTextField) evt.getComponent();  
	       if (evt.getKeyCode()!=32 & evt.getKeyCode()!=8 & evt.getKeyCode()!=37 & evt.getKeyCode()!=39)  
	    	   textBusca.setText(textBusca.getText().toUpperCase());  
	}
}
