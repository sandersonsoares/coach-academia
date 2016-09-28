package br.com.projetoacademia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projetoacademia.entidades.Usuario;
import br.com.projetoacademia.excecoes.DaoException;

public class BuscarUsuario extends JDialog {
	public BuscarUsuario() {
	}

	private final JPanel contentPanel = new JPanel();
	private List<Usuario> usuarios;
	private Usuario usuario;
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField textBuscar;
	private JDialog cadastrar;

	public BuscarUsuario(JDialog cadastrar) {
		setTitle("Buscar");
		this.cadastrar = cadastrar;
		setBounds(100, 100, 567, 442);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null); // centraliza

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 99, 531, 252);
		contentPanel.add(scrollPane);

		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Login"}));
		table.getColumnModel().getColumn(0).setPreferredWidth(323);
		table.getColumnModel().getColumn(1).setPreferredWidth(160);
		scrollPane.setViewportView(table);

		tableModel = (DefaultTableModel) table.getModel();
		table.setModel(tableModel);


		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(13, 46, 46, 14);
		contentPanel.add(lblNome);

		textBuscar = new JTextField();
		textBuscar.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				listarPessoa();
			}
		});
		textBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listarPessoa();
			}
		});
		textBuscar.setBounds(10, 71, 270, 20);
		contentPanel.add(textBuscar);
		textBuscar.setColumns(10);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.WHITE);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("Visualizar");
		okButton.setBackground(new Color(0, 128, 0));
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpf = (String) table.getValueAt(table.getSelectedRow(), 1);
//				try {
					String login = (String) table.getValueAt(table.getSelectedRow(), 0);
					CadastrarUsuario cadUsuario = (CadastrarUsuario) BuscarUsuario.this.cadastrar;
					cadUsuario.setUsuario((Usuario) BuscarUsuario.this.usuario);
					cadUsuario.getBtnSalvar().setEnabled(false);
					
//				} catch (DaoException e) {
//					e.printStackTrace();
//				}
				dispose();
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					CadastrarUsuario cadUsuario = (CadastrarUsuario) BuscarUsuario.this.cadastrar;
//					CadastrarUsuario cu = new CadastrarUsuario(BuscarUsuario.this.usuarioDao);
					cadUsuario.dispose();
					BuscarUsuario.this.dispose();
//					cu.setVisible(true);
			}
		});
		cancelButton.setBackground(new Color(178, 34, 34));
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		setModal(true);
	}

	private void listarPessoa() {
		String login = textBuscar.getText();
//		usuarios = (List<Usuario>) BuscarUsuario.this.usuarioDao.buscarFiltroLogin(login);
			
		while (tableModel.getRowCount() != 0) {
			tableModel.removeRow(0);
		}
			for (Usuario usuario : usuarios) {
					tableModel.addRow(new String[] { usuario.getLogin()});
				}
	}

}
