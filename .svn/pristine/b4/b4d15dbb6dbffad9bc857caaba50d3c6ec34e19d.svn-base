package br.com.projetoacademia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projetoacademia.entidades.Aluno;
import br.com.projetoacademia.entidades.Pessoa;
import br.com.projetoacademia.excecoes.DaoException;

public class Avalicao extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textBusca;
	private JTable table;
//	private PessoaDAO pessoaDao;
	private Aluno aluno;
	private List<Pessoa> pessoas;
	private DefaultTableModel tableModel;

	public Avalicao() {
//		this.pessoaDao = new PessoaDAO();
		init();
		setModal(true);
	}

	private void init() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Avalicao.class.getResource("/br/com/imagens/avaliacao_icon.png")));
		setTitle("Avalia\u00E7\u00E3o");
		setBounds(100, 100, 558, 449);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Buscar Avaliado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 531, 83);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblBuscar = new JLabel("Nome:");
		lblBuscar.setBounds(31, 24, 46, 14);
		panel.add(lblBuscar);

		textBusca = new JTextField();
		textBusca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				listarPessoa();
			}
		});
		textBusca.setBounds(31, 41, 366, 20);
		panel.add(textBusca);
		textBusca.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarPessoa();
			}
		});
		btnBuscar.setBounds(418, 40, 89, 23);
		panel.add(btnBuscar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 106, 531, 245);
		contentPanel.add(scrollPane);

		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(320);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		scrollPane.setViewportView(table);

		tableModel = (DefaultTableModel) table.getModel();
		table.setModel(tableModel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setBounds(0, 369, 552, 33);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton btnCancelar = new JButton("Fechar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCancelar.setBounds(433, 5, 105, 23);
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}

			JButton btnNovo = new JButton("Novo");
			btnNovo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String cpf = (String) table.getValueAt(table.getSelectedRow(), 1);
					try {
//						Avalicao.this.aluno = (Aluno) Avalicao.this.pessoaDao.buscar(cpf);
						Antropometria ap = new Antropometria(Avalicao.this, Avalicao.this.aluno);
						ap.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			btnNovo.setBounds(14, 5, 105, 23);
			buttonPane.add(btnNovo);

			JButton btnMedidas = new JButton("Ver Medidas");
			btnMedidas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String cpf = (String) table.getValueAt(table.getSelectedRow(), 1);
//					try {
//						Aluno aluno = (Aluno) Avalicao.this.pessoaDao.buscar(cpf);
						BuscarAntropometria ba = new BuscarAntropometria(aluno);
						ba.setVisible(true);
//					} catch (DaoException e) {
//						e.printStackTrace();
//					}
				}
			});
			btnMedidas.setBounds(133, 5, 105, 23);
			buttonPane.add(btnMedidas);
		}
	}

	private void listarPessoa() {
		String nome = textBusca.getText();
//		pessoas = Avalicao.this.pessoaDao.buscarNome(nome);

		while (tableModel.getRowCount() != 0) {
			tableModel.removeRow(0);
		}

		for (Pessoa pessoa : pessoas) {
			if (pessoa instanceof Aluno) {
				tableModel.addRow(new String[] { pessoa.getNome(), pessoa.getCpf() });
			}
		}
	}
}
