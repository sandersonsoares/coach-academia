package br.com.projetoacademia.gui;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JProgressBar;

public class DialogMessage extends JDialog {
		
	private JProgressBar progressBar;
	
	public DialogMessage() {
		init();
	}
	
	private void init(){
		setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(12, 138, 366, 20);
		progressBar.setIndeterminate(true);
		getContentPane().add(progressBar);
		
		setTitle("Carregando...");
		setSize(400, 200);
		setVisible(true);
		setModal(true);
		setLocationRelativeTo(null);
	}
}
