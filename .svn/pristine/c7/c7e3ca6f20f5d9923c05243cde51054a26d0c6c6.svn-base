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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projetoacademia.entidades.Instrutor;
import br.com.projetoacademia.entidades.Pessoa;

public class MenuInstrutor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField textBusca;
	private List<Pessoa> pessoas;
	private DefaultTableModel tableModel;
	private JButton btnNovo;
	private JButton btnVisualizar;
	private JButton btnOk;
	private JButton btnBuscar;

	public MenuInstrutor() {
		init();
	}

	private void init() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MenuInstrutor.class.getResource("/br/com/imagens/adicionar_usuario.png")));
		setTitle("Cadastro Instrutores");
		setBounds(100, 100, 537, 394);
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
				CadastrarInstrutor ci = new CadastrarInstrutor();
				ci.setVisible(true);
			}
		});
		btnNovo.setBounds(10, 5, 100, 23);
		btnNovo.setActionCommand("OK");
		buttonPane.add(btnNovo);

		btnOk = new JButton("Fechar");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOk.setBounds(404, 5, 100, 23);
		btnOk.setActionCommand("OK");
		buttonPane.add(btnOk);
		getRootPane().setDefaultButton(btnOk);

		btnVisualizar = new JButton("Visualizar");
		btnVisualizar.setEnabled(false);
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// String login = (String)
				// table.getValueAt(table.getSelectedRow(), 0);
				// CadastrarUsuario ca = new
				// CadastrarUsuario(MenuUsuarios.this.usuarioDao);
				// ca.setTextLogin(login);
				// ca.setVisible(true);

				String cpf = (String) table.getValueAt(table.getSelectedRow(), 1);
				try {
//					Instrutor instrutor = (Instrutor) MenuInstrutor.this.pessoaDao.buscar(cpf);
//					CadastrarInstrutor ci = new CadastrarInstrutor(MenuInstrutor.this.pessoaDao);
//					ci.setPessoa(instrutor);
//					ci.getBtnSalvar().setEnabled(false);
//					ci.preencherCadastro();
//					ci.bloquearCampos();
//					ci.setarCoresDesativas();
//					ci.getBtnEditar().setEnabled(true);
//					ci.setVisible(true);
//					textBusca.setText("");
//					listarPessoa();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnVisualizar.setActionCommand("OK");
		btnVisualizar.setBounds(120, 5, 100, 23);
		buttonPane.add(btnVisualizar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 512, 195);
		contentPanel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				btnVisualizar.setEnabled(true);
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF" }) {
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);

		tableModel = (DefaultTableModel) table.getModel();
		table.setModel(tableModel);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar Instrutor",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 14, 512, 83);
		contentPanel.add(panel);

		JLabel lblUsuario = new JLabel("Instrutor:");
		lblUsuario.setBounds(31, 24, 61, 14);
		panel.add(lblUsuario);

		textBusca = new JTextField();
		textBusca.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				listarPessoa();
			}
		});
		textBusca.setColumns(10);
		textBusca.setBounds(31, 41, 332, 23);
		panel.add(textBusca);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarPessoa();
			}
		});
		btnBuscar.setBounds(390, 40, 89, 23);
		panel.add(btnBuscar);

		setModal(true);
	}

	private void listarPessoa() {
		String nome = textBusca.getText();
//		pessoas = MenuInstrutor.this.pessoaDao.buscarNome(nome);

		while (tableModel.getRowCount() != 0) {
			tableModel.removeRow(0);
		}
		for (Pessoa pessoa : pessoas) {
			if (pessoa instanceof Instrutor) {
				tableModel.addRow(new String[] { pessoa.getNome(), pessoa.getCpf() });
			}
		}
	}

}
