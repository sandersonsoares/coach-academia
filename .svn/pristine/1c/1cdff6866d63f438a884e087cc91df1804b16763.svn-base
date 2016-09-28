package br.com.projetoacademia.gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import br.com.projetoacademia.excecoes.BusinessException;
import br.com.projetoacademia.facade.Facade;
import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;

public class Inicio extends JFrame {

	private JProgressBar jProgressBar;

	public Inicio() {

		getContentPane().setBackground(Color.WHITE);
		try {
			UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			System.out.println("Problema no LookAndFeel");
			e.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				initComponents();
			}	
		});

		try {
			Facade.getInstance().getInstance().listarTodosUsuarios();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Principal p = new Principal();
				Login l = new Login(p);
				dispose();
				p.setVisible(true);
				l.setVisible(true);
			}
		});

	}

	private void initComponents() {
		setUndecorated(true);
		getContentPane().setLayout(null);
		jProgressBar = new JProgressBar();
		jProgressBar.setBounds(10, 228, 428, 18);
		jProgressBar.setIndeterminate(true);

		getContentPane().add(jProgressBar);

		JLabel lblimg = new JLabel("New label");
		lblimg.setIcon(new ImageIcon(Inicio.class.getResource("/br/com/imagens/inicio.png")));
		lblimg.setBounds(10, 11, 428, 216);
		getContentPane().add(lblimg);
		// pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(30, 30, 454, 260);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}