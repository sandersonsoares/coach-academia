package br.com.projetoacademia.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JCalendar;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JLabel lblHora;
	private static final DateFormat FORMATO = new SimpleDateFormat("HH:mm:ss");
	public static JLabel lblUsuario;

	public Principal() {
		setResizable(false);
		init();
		exibirHoraAtual(getLblHora());
	}

	private void init() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/br/com/imagens/icon.png")));
		setTitle("COACH - Controle de Academia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 30, (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
				(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 50);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true); // deixa full screen

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBorder(null);
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Cadastros");
		mnArquivo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnArquivo);

		JMenuItem mntmNewMenuItem = new JMenuItem("Alunos");
		mntmNewMenuItem.setIcon(new ImageIcon(Principal.class.getResource("/br/com/imagens/adicionar_usuario.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuAluno ma = new MenuAluno();
				ma.setVisible(true);
			}
		});
		mntmNewMenuItem.setBackground(Color.WHITE);
		mnArquivo.add(mntmNewMenuItem);

		JMenuItem mntmExibir = new JMenuItem("Instrutores");
		mntmExibir.setIcon(new ImageIcon(Principal.class.getResource("/br/com/imagens/adicionar_usuario.png")));
		mntmExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuInstrutor mi = new MenuInstrutor();
				mi.setVisible(true);
			}
		});
		mnArquivo.add(mntmExibir);

		JMenuItem mntmUsurios = new JMenuItem("Usu\u00E1rios");
		mntmUsurios.setIcon(new ImageIcon(Principal.class.getResource("/br/com/imagens/login_icon.png")));
		mntmUsurios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUsuarios mu = new MenuUsuarios();
				mu.setVisible(true);
			}
		});
		mnArquivo.add(mntmUsurios);

		JMenu mnNewMenu_1 = new JMenu("Financeiro");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmPagarInstrutor = new JMenuItem("Pagar Instrutor");
		mntmPagarInstrutor.setIcon(new ImageIcon(Principal.class.getResource("/br/com/imagens/pagamento_icon.png")));
		mntmPagarInstrutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Opá! Vamos pagar esses kraio!");
			}
		});
		mnNewMenu_1.add(mntmPagarInstrutor);

		JMenuItem mntmReceberAluno = new JMenuItem("Receber Aluno");
		mntmReceberAluno.setIcon(new ImageIcon(Principal.class.getResource("/br/com/imagens/pagamento_icon.png")));
		mntmReceberAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Opá! Vamos pagar esses kraio!");
			}
		});
		mnNewMenu_1.add(mntmReceberAluno);

		JMenu mnNewMenu = new JMenu("Atendimento");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);

		JMenuItem mntmAvaliao = new JMenuItem("Avalia\u00E7\u00E3o");
		mntmAvaliao.setIcon(new ImageIcon(Principal.class.getResource("/br/com/imagens/avaliacao_icon.png")));
		mntmAvaliao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Avalicao av = new Avalicao();
				av.setVisible(true);
			}
		});
		mnNewMenu.add(mntmAvaliao);

		JMenu mnNewMenu_2 = new JMenu("Estat\u00EDsticas");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_2);

		JMenu mnAjuda = new JMenu("Ajuda");
		mnAjuda.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnAjuda);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Sobre");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				About ab = new About();
				ab.setVisible(true);
			}
		});
		mnAjuda.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(20, 0, 251, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 59);
		contentPane.add(panel);
		panel.setLayout(null);

		JCalendar calendar = new JCalendar();
		calendar.getDayChooser().setSundayForeground(Color.RED);
		calendar.setSundayForeground(new Color(220, 20, 60));
		calendar.getDayChooser().setForeground(new Color(0, 0, 0));
		calendar.getDayChooser().setWeekdayForeground(new Color(0, 0, 0));
		calendar.getDayChooser().setDecorationBackgroundColor(Color.LIGHT_GRAY);
		calendar.getDayChooser().getDayPanel().setBackground(new Color(255, 255, 255));
		calendar.setBounds(10, 29, 231, 220);
		panel.add(calendar);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(SystemColor.textHighlight);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Hora Atual", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 292, 231, 61);
		panel.add(panel_1);
		panel_1.setLayout(null);

		lblHora = new JLabel("New label");
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setForeground(new Color(0, 0, 0));
		lblHora.setBounds(10, 19, 211, 30);
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(lblHora);

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(SystemColor.textHighlight);
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Usu\u00E1rio", TitledBorder.LEADING, TitledBorder.TOP, null,
				UIManager.getColor("TitledBorder.titleColor")));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 378, 231, 61);
		panel.add(panel_2);

		lblUsuario = new JLabel("USU\u00C1RIO");
		lblUsuario.setBackground(SystemColor.menu);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(new Color(0, 0, 0));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(10, 28, 211, 19);
		panel_2.add(lblUsuario);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.controlHighlight);
		panel_3.setBorder(null);
		panel_3.setBounds(270, 0, 1640, 105);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblCadastroDeAluno = new JLabel("Cadastro de Aluno");
		lblCadastroDeAluno.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCadastroDeAluno.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeAluno.setBounds(36, 11, 105, 24);
		panel_3.add(lblCadastroDeAluno);

		JLabel lbl_f2 = new JLabel("[F2]");
		lbl_f2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_f2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_f2.setBounds(36, 69, 105, 25);
		panel_3.add(lbl_f2);

		JLabel lbl_f3 = new JLabel("[F3]");
		lbl_f3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_f3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_f3.setBounds(151, 69, 105, 25);
		panel_3.add(lbl_f3);

		JLabel lblPagamentoDeAluno = new JLabel("Pagamento de Aluno");
		lblPagamentoDeAluno.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPagamentoDeAluno.setHorizontalAlignment(SwingConstants.CENTER);
		lblPagamentoDeAluno.setBounds(151, 11, 105, 24);
		panel_3.add(lblPagamentoDeAluno);

		JButton btnCadastroAluno = new JButton("");
		btnCadastroAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAluno ma = new MenuAluno();
				ma.setVisible(true);
			}
		});

		btnCadastroAluno.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0),
				"evento");
		btnCadastroAluno.getActionMap().put("evento", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuAluno ma = new MenuAluno();
				ma.setVisible(true);
			}
		});

		btnCadastroAluno.setIcon(new ImageIcon(Principal.class.getResource("/br/com/imagens/adicionar_usuario.png")));
		btnCadastroAluno.setBounds(36, 11, 105, 83);
		panel_3.add(btnCadastroAluno);

		JButton btnPagamentoAluno = new JButton("");
		btnPagamentoAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Opá! Vamos pagar esses kraio!");
			}
		});

		btnPagamentoAluno.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0),
				"evento");
		btnPagamentoAluno.getActionMap().put("evento", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Opá! Vamos pagar esses kraio!");
			}
		});

		btnPagamentoAluno.setIcon(new ImageIcon(Principal.class.getResource("/br/com/imagens/pagamento_icon.png")));
		btnPagamentoAluno.setBounds(151, 11, 105, 83);
		panel_3.add(btnPagamentoAluno);

		JLabel lblNewLabel = new JLabel("bg_label");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/br/com/imagens/BG_COACH.png")));
		lblNewLabel.setBounds(270, 106, 1640, 894);
		contentPane.add(lblNewLabel);
	}

	public static void exibirHoraAtual(final JLabel label) {
		Thread hora = new Thread() {
			public void run() {
				while (true) {
					label.setText(FORMATO.format(new Date()));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}

		};
		hora.start();

	}

	private JLabel getLblHora() {
		if (lblHora == null) {
			lblHora = new JLabel();
		}
		return lblHora;
	}
}
