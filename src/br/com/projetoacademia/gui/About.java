package br.com.projetoacademia.gui;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class About extends JDialog {
	public About() {
		setBounds(100, 100, 484, 344);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(About.class.getResource("/br/com/imagens/about.png")));
		label.setBounds(0, 0, 479, 297);
		getContentPane().add(label);
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
	}
}
