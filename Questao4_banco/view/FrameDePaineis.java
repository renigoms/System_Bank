package view;

import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FrameDePaineis extends JFrame {
	private PainelDeCartoes painelDeCartoes;
	public FrameDePaineis() throws ParseException {
		super("Banco Ouro Real");
		setIconImage(new ImageIcon("img/realIcon.png").getImage());
		setSize(550, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		painelDeCartoes = new PainelDeCartoes();
		add(painelDeCartoes);
		
		setVisible(true);
		
	}
	
	
	public PainelDeCartoes getPainelDeCartoes() {
		return painelDeCartoes;
	}


	
}
