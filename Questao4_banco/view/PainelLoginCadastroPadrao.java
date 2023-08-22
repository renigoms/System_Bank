package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public abstract class PainelLoginCadastroPadrao extends PainelPadrao{
	
	private JLabel informLabel, imagemJLabel,titulo, imagemBanco;
	private ImageIcon icone, icone2;
	private JButton voltarButton;
	
	public PainelLoginCadastroPadrao() {
		setBackground(Color.black);
		setLayout(null);
		
		icone = new ImageIcon("img/moeda.png");
		imagemJLabel = new JLabel(icone);
		imagemJLabel.setBounds(45, 30, 80, 86);
		add(imagemJLabel);
		
		icone2 = new ImageIcon("img/banco.png");
		imagemBanco = new JLabel(icone2);
		imagemBanco.setBounds(0,110, 200,300);
		add(imagemBanco);
		setVisible(true);
		
		titulo = new JLabel();
		titulo.setForeground(Color.white);
		titulo.setFont(new Font("Arial Bold", Font.BOLD, 50));
		titulo.setBounds(130, 35, 300, 60);
		add(titulo);
		
		informLabel = new JLabel();
		informLabel.setForeground(Color.white);
		informLabel.setFont(new Font("Arial", Font.PLAIN,16));
		informLabel.setBounds(130, 100, 500, 38);
		add(informLabel);
		
		voltarButton = new JButton("Voltar");
		voltarButton.setBounds(360, 280, 100, 30);
		makeButton(voltarButton);
		add(voltarButton);
		
	
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public JLabel getInformLabel() {
		return informLabel;
	}

	public JButton getVoltarButton() {
		return voltarButton;
	}
	
	public void makeButton(JButton button) {
		button.setBackground(Color.yellow);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Arial Bold Italic", Font.BOLD, 16));
	}
	
	public void makeLabel(JLabel label) {
		label.setFont(new Font("Arial",Font.PLAIN, 16));
		label.setForeground(Color.white);
		
	}
	
	
	
	
	
	

}
