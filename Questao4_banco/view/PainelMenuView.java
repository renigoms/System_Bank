package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class PainelMenuView extends PainelPadrao{
	private JLabel imagemJLabel,menuPrincipal;
	private JButton entrarButton, cadastrarButton;
	
	public PainelMenuView() {
		setLayout(null);
		setBackground(new Color(242,249,145));
		menuPrincipal = new JLabel("Menu Principal");
		menuPrincipal.setFont(new Font("dialog", Font.BOLD, 50));
		menuPrincipal.setBounds(90, 20, 400, 60);
		add(menuPrincipal);
		imagemJLabel = new JLabel(new ImageIcon("img/realIcon.png"));
		imagemJLabel.setBounds(120,80,300,225 );
		add(imagemJLabel);
		entrarButton = new JButton("Entrar");
		entrarButton.setBounds(100, 330, 150, 50);
		add(entrarButton);
		cadastrarButton = new JButton("Fazer Cadastro");
		cadastrarButton.setBounds(290, 330, 150, 50);
		add(cadastrarButton);
		setVisible(true);
		
	}

	public JButton getEntrarButton() {
		return entrarButton;
	}

	public JButton getCadastrarButton() {
		return cadastrarButton;
	}
	
	

}
