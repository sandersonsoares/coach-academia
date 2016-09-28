package br.com.projetoacademia.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import br.com.projetoacademia.entidades.Aluno;
import br.com.projetoacademia.entidades.Medida;
import br.com.projetoacademia.entidades.Pessoa;

public class Antropometria extends JDialog {
	private JTextField textPeso;
	private JTextField textPantuEsquerda;
	private JTextField textCoxaEsquerda;
	private JTextField textQuadril;
	private JTextField textCintura;
	private JTextField textAntebracoEsquerdo;
	private JTextField textBracoEsquerdo;
	private JTextField textOmbro;
	private JTextField textBracoDireito;
	private JTextField textAntebracoDireito;
	private JTextField textCoxaDireita;
	private JTextField textTorax;
	private JTextField textAbdomem;
	private JTextField textPantuDireita;
	private JTextField textAltura;
	private Aluno aluno;
	private Medida medida;
	private JTextField textData;
	private JDialog telaAnterior;
	private JFormattedTextField maskAltura;

	private JTextField textImc;
	private JButton btnSalvar;
	private JLabel lblResultadoImc;

	public Antropometria(JDialog tela, Pessoa pessoa) {
		this.aluno = (Aluno) pessoa;
		this.telaAnterior = tela;
		init();
		setModal(true);
	}

	private void init() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Antropometria.class.getResource("/br/com/imagens/avaliacao_icon.png")));
		setDefaultCloseOperation(Antropometria.DO_NOTHING_ON_CLOSE);

		setTitle("Antropometria");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 953, 690);
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);

		JPanel buttonPane = new JPanel();
		buttonPane.setBorder(new LineBorder(SystemColor.inactiveCaption));
		buttonPane.setBackground(Color.WHITE);
		buttonPane.setBounds(0, 609, 947, 33);
		getContentPane().add(buttonPane);
		buttonPane.setLayout(null);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setIconTextGap(2);
		btnSalvar.setIcon(new ImageIcon(Antropometria.class.getResource("/br/com/imagens/Floppy-Disk-24.png")));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (telaAnterior instanceof Avalicao) {
					int op = JOptionPane.showConfirmDialog(null, "Deseja Realmente Salvar essas Medidas ?");
					if (op == 0) {
						salvarAvaliacao();
						JOptionPane.showMessageDialog(null, "Medidas salvas com SUCESSO!");
					}
				}

				if (telaAnterior instanceof BuscarAntropometria) {
					Avalicao av = new Avalicao();
					Antropometria at = new Antropometria(av, Antropometria.this.aluno);
					at.setVisible(true);
				}

				dispose();
			}
		});
		btnSalvar.setBounds(26, 5, 89, 23);
		btnSalvar.setActionCommand("OK");
		buttonPane.add(btnSalvar);

		JButton okButton = new JButton("Cancelar");
		okButton.setIconTextGap(2);
		okButton.setIcon(new ImageIcon(Antropometria.class.getResource("/br/com/imagens/close-round-24.png")));
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		okButton.setBounds(829, 5, 101, 23);
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarAntropometria ba = new BuscarAntropometria(Antropometria.this.aluno);
				ba.setVisible(true);
				dispose();
			}
		});
		btnBuscar.setActionCommand("OK");
		btnBuscar.setBounds(125, 5, 70, 23);
		buttonPane.add(btnBuscar);

		textPeso = new JTextField();
		textPeso.setBounds(630, 553, 105, 23);
		getContentPane().add(textPeso);
		textPeso.setColumns(10);

		textPantuEsquerda = new JTextField();
		textPantuEsquerda.setColumns(10);
		textPantuEsquerda.setBounds(650, 448, 105, 23);
		getContentPane().add(textPantuEsquerda);

		textCoxaEsquerda = new JTextField();
		textCoxaEsquerda.setColumns(10);
		textCoxaEsquerda.setBounds(650, 377, 105, 23);
		getContentPane().add(textCoxaEsquerda);

		textQuadril = new JTextField();
		textQuadril.setColumns(10);
		textQuadril.setBounds(650, 330, 105, 23);
		getContentPane().add(textQuadril);

		textCintura = new JTextField();
		textCintura.setColumns(10);
		textCintura.setBounds(650, 291, 105, 23);
		getContentPane().add(textCintura);

		textAntebracoEsquerdo = new JTextField();
		textAntebracoEsquerdo.setColumns(10);
		textAntebracoEsquerdo.setBounds(650, 245, 105, 23);
		getContentPane().add(textAntebracoEsquerdo);

		textBracoEsquerdo = new JTextField();
		textBracoEsquerdo.setColumns(10);
		textBracoEsquerdo.setBounds(650, 199, 105, 23);
		getContentPane().add(textBracoEsquerdo);

		textOmbro = new JTextField();
		textOmbro.setColumns(10);
		textOmbro.setBounds(650, 144, 105, 23);
		getContentPane().add(textOmbro);

		textBracoDireito = new JTextField();
		textBracoDireito.setColumns(10);
		textBracoDireito.setBounds(162, 199, 105, 23);
		getContentPane().add(textBracoDireito);

		textAntebracoDireito = new JTextField();
		textAntebracoDireito.setColumns(10);
		textAntebracoDireito.setBounds(162, 245, 105, 23);
		getContentPane().add(textAntebracoDireito);

		textCoxaDireita = new JTextField();
		textCoxaDireita.setColumns(10);
		textCoxaDireita.setBounds(162, 377, 105, 23);
		getContentPane().add(textCoxaDireita);

		textTorax = new JTextField();
		textTorax.setColumns(10);
		textTorax.setBounds(162, 155, 105, 23);
		getContentPane().add(textTorax);

		textAbdomem = new JTextField();
		textAbdomem.setColumns(10);
		textAbdomem.setBounds(162, 291, 105, 23);
		getContentPane().add(textAbdomem);

		textPantuDireita = new JTextField();
		textPantuDireita.setColumns(10);
		textPantuDireita.setBounds(162, 448, 105, 23);
		getContentPane().add(textPantuDireita);

		try {
			maskAltura = new JFormattedTextField(new MaskFormatter("#.##"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		textAltura = maskAltura;
		textAltura.setColumns(10);
		textAltura.setBounds(228, 40, 105, 23);
		getContentPane().add(textAltura);

		JLabel lblTrax = new JLabel("T\u00F3rax:");
		lblTrax.setBounds(162, 139, 46, 14);
		getContentPane().add(lblTrax);

		JLabel lblOmbro = new JLabel("Ombro:");
		lblOmbro.setBounds(650, 127, 51, 14);
		getContentPane().add(lblOmbro);

		JLabel lblBrao = new JLabel("Bra\u00E7o:");
		lblBrao.setBounds(162, 184, 46, 14);
		getContentPane().add(lblBrao);

		JLabel lblAntebrao = new JLabel("Antebra\u00E7o:");
		lblAntebrao.setBounds(162, 230, 74, 14);
		getContentPane().add(lblAntebrao);

		JLabel lblTrax_1 = new JLabel("Abdomen:");
		lblTrax_1.setBounds(162, 276, 74, 14);
		getContentPane().add(lblTrax_1);

		JLabel lblCoxa = new JLabel("Coxa:");
		lblCoxa.setBounds(162, 362, 46, 14);
		getContentPane().add(lblCoxa);

		JLabel lblPanturrilha = new JLabel("Panturrilha:");
		lblPanturrilha.setBounds(162, 433, 74, 14);
		getContentPane().add(lblPanturrilha);

		JLabel lblPanturrilha_1 = new JLabel("Panturrilha:");
		lblPanturrilha_1.setBounds(650, 433, 85, 14);
		getContentPane().add(lblPanturrilha_1);

		JLabel lblPanturrilha_2 = new JLabel("Coxa:");
		lblPanturrilha_2.setBounds(650, 361, 46, 14);
		getContentPane().add(lblPanturrilha_2);

		JLabel lblQuadril = new JLabel("Quadril:");
		lblQuadril.setBounds(650, 316, 61, 14);
		getContentPane().add(lblQuadril);

		JLabel lblCintura = new JLabel("Cintura:");
		lblCintura.setBounds(650, 276, 61, 14);
		getContentPane().add(lblCintura);

		JLabel lblAntebrao_1 = new JLabel("Antebra\u00E7o:");
		lblAntebrao_1.setBounds(650, 230, 74, 14);
		getContentPane().add(lblAntebrao_1);

		JLabel lblBrao_1 = new JLabel("Bra\u00E7o:");
		lblBrao_1.setBounds(650, 184, 46, 14);
		getContentPane().add(lblBrao_1);

		JLabel lblEstatura = new JLabel("Estatura:");
		lblEstatura.setBounds(228, 23, 74, 14);
		getContentPane().add(lblEstatura);

		JLabel lblMassaCorporal = new JLabel("Massa Corporal:");
		lblMassaCorporal.setBounds(630, 538, 105, 14);
		getContentPane().add(lblMassaCorporal);

		JLabel lblDireita = new JLabel("DIREITA");
		lblDireita.setFont(new Font("Arial", Font.BOLD, 12));
		lblDireita.setForeground(new Color(178, 34, 34));
		lblDireita.setBounds(104, 85, 46, 14);
		getContentPane().add(lblDireita);

		JLabel lblEsquerda = new JLabel("ESQUERDA");
		lblEsquerda.setFont(new Font("Arial", Font.BOLD, 12));
		lblEsquerda.setForeground(new Color(178, 34, 34));
		lblEsquerda.setBounds(740, 85, 74, 14);
		getContentPane().add(lblEsquerda);

		JLabel lblcm = new JLabel("(cm)");
		lblcm.setForeground(new Color(178, 34, 34));
		lblcm.setBounds(129, 158, 46, 14);
		getContentPane().add(lblcm);

		JLabel label = new JLabel("(cm)");
		label.setForeground(new Color(178, 34, 34));
		label.setBounds(129, 202, 46, 14);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("(cm)");
		label_1.setForeground(new Color(178, 34, 34));
		label_1.setBounds(129, 248, 46, 14);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel("(cm)");
		label_2.setForeground(new Color(178, 34, 34));
		label_2.setBounds(129, 294, 46, 14);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel("(cm)");
		label_3.setForeground(new Color(178, 34, 34));
		label_3.setBounds(129, 380, 46, 14);
		getContentPane().add(label_3);

		JLabel label_4 = new JLabel("(cm)");
		label_4.setForeground(new Color(178, 34, 34));
		label_4.setBounds(129, 451, 46, 14);
		getContentPane().add(label_4);

		JLabel label_5 = new JLabel("(cm)");
		label_5.setForeground(new Color(178, 34, 34));
		label_5.setBounds(765, 451, 46, 14);
		getContentPane().add(label_5);

		JLabel label_6 = new JLabel("(cm)");
		label_6.setForeground(new Color(178, 34, 34));
		label_6.setBounds(765, 380, 46, 14);
		getContentPane().add(label_6);

		JLabel label_7 = new JLabel("(cm)");
		label_7.setForeground(new Color(178, 34, 34));
		label_7.setBounds(765, 333, 46, 14);
		getContentPane().add(label_7);

		JLabel label_8 = new JLabel("(cm)");
		label_8.setForeground(new Color(178, 34, 34));
		label_8.setBounds(765, 294, 46, 14);
		getContentPane().add(label_8);

		JLabel label_9 = new JLabel("(cm)");
		label_9.setForeground(new Color(178, 34, 34));
		label_9.setBounds(765, 248, 46, 14);
		getContentPane().add(label_9);

		JLabel label_10 = new JLabel("(cm)");
		label_10.setForeground(new Color(178, 34, 34));
		label_10.setBounds(765, 202, 46, 14);
		getContentPane().add(label_10);

		JLabel label_11 = new JLabel("(cm)");
		label_11.setForeground(new Color(178, 34, 34));
		label_11.setBounds(765, 147, 46, 14);
		getContentPane().add(label_11);

		JLabel label_12 = new JLabel("(cm)");
		label_12.setForeground(new Color(178, 34, 34));
		label_12.setBounds(189, 43, 46, 14);
		getContentPane().add(label_12);

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(115, 518, 46, 14);
		getContentPane().add(lblData);

		textData = new JTextField();
		textData.setEditable(false);
		textData.setColumns(10);
		textData.setBounds(162, 515, 105, 23);
		getContentPane().add(textData);

		textImc = new JTextField();
		textImc.setEditable(false);
		textImc.setColumns(10);
		textImc.setBounds(162, 553, 105, 23);
		getContentPane().add(textImc);

		JLabel lblImc = new JLabel("IMC:");
		lblImc.setBounds(115, 556, 46, 14);
		getContentPane().add(lblImc);

		JLabel lblAntropometria = new JLabel("");
		lblAntropometria.setBackground(Color.WHITE);
		lblAntropometria.setHorizontalAlignment(SwingConstants.CENTER);
		lblAntropometria.setHorizontalTextPosition(SwingConstants.LEADING);
		lblAntropometria.setIcon(new ImageIcon(Antropometria.class.getResource("/br/com/imagens/Avalicao.png")));
		lblAntropometria.setBounds(25, 40, 884, 531);
		getContentPane().add(lblAntropometria);
		
		lblResultadoImc = new JLabel("");
		lblResultadoImc.setBounds(115, 584, 198, 14);
		lblResultadoImc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblResultadoImc.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultadoImc.setHorizontalTextPosition(SwingConstants.CENTER);
		getContentPane().add(lblResultadoImc);

			
			


		if (telaAnterior instanceof BuscarAntropometria) {
			btnSalvar.setText("Novo");
			this.medida = ((BuscarAntropometria) this.telaAnterior).getMedida();
			preecherCampos();
			bloquearCampos();
		}

		if (telaAnterior instanceof Avalicao) {
			btnSalvar.setText("Salvar");
		}

	}

	public void salvarAvaliacao() {
		medida = null;
		medida = new Medida(Double.parseDouble(textAltura.getText()), Double.parseDouble(textPeso.getText()));
		medida.setPanturrilhaDireita(Double.parseDouble(textPantuDireita.getText()));
		medida.setPanturrilhaEsquerda(Double.parseDouble(textPantuEsquerda.getText()));
		medida.setCoxaEsquerda(Double.parseDouble(textCoxaEsquerda.getText()));
		medida.setQuadril(Double.parseDouble(textQuadril.getText()));
		medida.setCintura(Double.parseDouble(textCintura.getText()));
		medida.setAntebracoEsquerdo(Double.parseDouble(textAntebracoEsquerdo.getText()));
		medida.setBracoEsquerdo(Double.parseDouble(textBracoEsquerdo.getText()));
		medida.setOmbro(Double.parseDouble(textOmbro.getText()));
		medida.setBracoDireito(Double.parseDouble(textBracoDireito.getText()));
		medida.setAntebracoDireito(Double.parseDouble(textAntebracoDireito.getText()));
		medida.setCoxaDireita(Double.parseDouble(textCoxaDireita.getText()));
		medida.setTorax(Double.parseDouble(textTorax.getText()));
		medida.setAbdomem(Double.parseDouble(textAbdomem.getText()));
		aluno.adicionarMedida(medida);
	}

	public void liberarCampos() {
		textPeso.setEditable(true);
		textPantuEsquerda.setEditable(true);
		textCoxaEsquerda.setEditable(true);
		textQuadril.setEditable(true);
		textCintura.setEditable(true);
		textAntebracoEsquerdo.setEditable(true);
		textBracoEsquerdo.setEditable(true);
		textOmbro.setEditable(true);
		textBracoDireito.setEditable(true);
		textAntebracoDireito.setEditable(true);
		textCoxaDireita.setEditable(true);
		textTorax.setEditable(true);
		textAbdomem.setEditable(true);
		textPantuDireita.setEditable(true);
		textAltura.setEditable(true);
	}

	public void limparCampos() {
		textPeso.setText("");
		textPantuEsquerda.setText("");
		textCoxaEsquerda.setText("");
		textQuadril.setText("");
		textCintura.setText("");
		textAntebracoEsquerdo.setText("");
		textBracoEsquerdo.setText("");
		textOmbro.setText("");
		textBracoDireito.setText("");
		textAntebracoDireito.setText("");
		textCoxaDireita.setText("");
		textTorax.setText("");
		textAbdomem.setText("");
		textPantuDireita.setText("");
		textAltura.setText("");
		textData.setText("");
		textImc.setText("");
	}

	public void bloquearCampos() {
		textPeso.setEditable(false);
		textPantuEsquerda.setEditable(false);
		textCoxaEsquerda.setEditable(false);
		textQuadril.setEditable(false);
		textCintura.setEditable(false);
		textAntebracoEsquerdo.setEditable(false);
		textBracoEsquerdo.setEditable(false);
		textOmbro.setEditable(false);
		textBracoDireito.setEditable(false);
		textAntebracoDireito.setEditable(false);
		textCoxaDireita.setEditable(false);
		textTorax.setEditable(false);
		textAbdomem.setEditable(false);
		textPantuDireita.setEditable(false);
		textAltura.setEditable(false);
	}

	public void preecherCampos() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		textPeso.setText(String.valueOf(medida.getPeso()));
		textPantuEsquerda.setText(String.valueOf(medida.getPanturrilhaEsquerda()));
		textCoxaEsquerda.setText(String.valueOf(medida.getCoxaEsquerda()));
		textQuadril.setText(String.valueOf(medida.getQuadril()));
		textCintura.setText(String.valueOf(medida.getCintura()));
		textAntebracoEsquerdo.setText(String.valueOf(medida.getAntebracoEsquerdo()));
		textBracoEsquerdo.setText(String.valueOf(medida.getBracoEsquerdo()));
		textOmbro.setText(String.valueOf(medida.getOmbro()));
		textBracoDireito.setText(String.valueOf(medida.getBracoDireito()));
		textAntebracoDireito.setText(String.valueOf(medida.getAntebracoDireito()));
		textCoxaDireita.setText(String.valueOf(medida.getCoxaDireita()));
		textTorax.setText(String.valueOf(medida.getTorax()));
		textAbdomem.setText(String.valueOf(medida.getAbdomem()));
		textPantuDireita.setText(String.valueOf(medida.getPanturrilhaDireita()));
		textAltura.setText(String.valueOf(medida.getAltura()));
		textData.setText(df.format(medida.getDataMedida().getTime()));
		DecimalFormat dfImc = new DecimalFormat("0.##");
		textImc.setText(String.valueOf(dfImc.format(medida.getImc())));
		
		if (medida.getImc() < 17) {
			lblResultadoImc.setForeground(new Color(192, 57, 43));
			lblResultadoImc.setText("Muito Abaixo do Peso!");
		}

		if (medida.getImc() >= 17 && medida.getImc() < 18.5) {
			lblResultadoImc.setForeground(new Color(243, 156, 18));
			lblResultadoImc.setText("Abaixo do Peso!");
		}

		if (medida.getImc() >= 18.5 && medida.getImc() < 24.99) {
			lblResultadoImc.setForeground(new Color(22, 160, 133));
			lblResultadoImc.setText("Peso normal.");
		}

		if (medida.getImc() >= 25.0 && medida.getImc() < 29.99) {
			lblResultadoImc.setForeground(new Color(243, 156, 18));
			lblResultadoImc.setText("Acima do Peso!");
		}

		if (medida.getImc() >= 30 && medida.getImc() < 34.99) {
			lblResultadoImc.setForeground(new Color(192, 57, 43));
			lblResultadoImc.setText("Obesidade I");
		}

		if (medida.getImc() >= 35 && medida.getImc() < 39.99) {
			lblResultadoImc.setForeground(new Color(192, 57, 43));
			lblResultadoImc.setText("Obesidade II (SEVERA)");
		}

		if (medida.getImc() > 40) {
			lblResultadoImc.setForeground(new Color(192, 57, 43));
			lblResultadoImc.setText("Obesidade III (M�RBIDA)");
		}
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	public Medida getMedida() {
		return medida;
	}

	public void setMedida(Medida medida) {
		this.medida = medida;
	}
}
