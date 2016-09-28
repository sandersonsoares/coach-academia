package br.com.projetoacademia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projetoacademia.entidades.Aluno;
import br.com.projetoacademia.entidades.Medida;
import br.com.projetoacademia.entidades.Pessoa;

import com.toedter.calendar.JDateChooser;

public class BuscarAntropometria extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private List<Pessoa> pessoas;
	private List<Medida> medidas;
	private Medida medida;
	private JTable table;
	private DefaultTableModel tableModel;
	private Aluno pessoa;
	private JDateChooser cFim;
	private JDateChooser cInicio;

	public BuscarAntropometria(Pessoa pessoa) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuscarAntropometria.class.getResource("/br/com/imagens/avaliacao_icon.png")));
		setTitle("Buscar Antropometria");
		this.pessoa = (Aluno) pessoa;
		
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "CPF", "Data"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(220);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		scrollPane.setViewportView(table);

		tableModel = (DefaultTableModel) table.getModel();
		table.setModel(tableModel);

		JLabel lblNome = new JLabel("Data:");
		lblNome.setBounds(29, 42, 46, 14);
		contentPanel.add(lblNome);

		cInicio = new JDateChooser();
		cInicio.setBackground(new Color(255, 255, 255));
		cInicio.setBounds(56, 68, 123, 20);
		contentPanel.add(cInicio);

		JLabel lblDe = new JLabel("De:");
		lblDe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDe.setBounds(29, 72, 33, 14);
		contentPanel.add(lblDe);

		cFim = new JDateChooser();
		cFim.setBounds(219, 68, 123, 20);
		contentPanel.add(cFim);

		JLabel lblAt = new JLabel("At\u00E9");
		lblAt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAt.setBounds(192, 72, 33, 14);
		contentPanel.add(lblAt);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cFim.getDate() != null) {
					if (cFim.getDate().before(cInicio.getDate())) {
						JOptionPane.showMessageDialog(null, "Data de Fim � maior que a data de In�cio!\n Por favor, selecione a data novamente.");
					} else {
						listarPessoaFiltro();
					}
				} else if (cFim.getDate() == null && cInicio.getDate() == null){
					listarPessoa();
				}
			}
		});
		btnBuscar.setBackground(UIManager.getColor("Button.background"));
		btnBuscar.setActionCommand("OK");
		btnBuscar.setBounds(364, 65, 77, 23);
		contentPanel.add(btnBuscar);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.WHITE);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("Visualizar");
		okButton.setBackground(UIManager.getColor("Button.background"));
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int posicao = table.getSelectedRow();

//				try {
//					BuscarAntropometria.this.medida = BuscarAntropometria.this.pessoaDao.buscarMedida(BuscarAntropometria.this.pessoa, posicao);
//					Antropometria at = new Antropometria(BuscarAntropometria.this, BuscarAntropometria.this.pessoa);
//					at.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
				dispose();
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarAntropometria.this.dispose();
			}
		});
		cancelButton.setBackground(UIManager.getColor("Button.background"));
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		setModal(true);
	}

	private void listarPessoaFiltro() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		medidas = null;
//		medidas = BuscarAntropometria.this.pessoaDao.buscarDataMedidas(pessoa, cInicio.getCalendar(), cFim.getCalendar());

		while (tableModel.getRowCount() != 0) {
			tableModel.removeRow(0);
		}

		for (Medida medida : medidas) {
			tableModel.addRow(new String[] { pessoa.getNome(), pessoa.getCpf(), df.format(medida.getDataMedida().getTime()) });
		}
	}
	
	private void listarPessoa() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		medidas = null;
//		medidas = BuscarAntropometria.this.pessoaDao.listarMedidasAluno(pessoa);

		while (tableModel.getRowCount() != 0) {
			tableModel.removeRow(0);
		}

		for (Medida medida : medidas) {
			tableModel.addRow(new String[] { pessoa.getNome(), pessoa.getCpf(), df.format(medida.getDataMedida().getTime()) });
		}
	}
	
	public Medida getMedida() {
		return medida;
	}
}
