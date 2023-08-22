package view;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public class PainelDeLogin extends PainelLoginCadastroPadrao{
	
	private JLabel cpfLabel;
	private MaskFormatter maskFormatter;
	private JFormattedTextField cpfField;
	private JButton loginButton;

	public PainelDeLogin() throws ParseException{
		
		
		getTitulo().setText("Login");
		
		String informativo = "<html>Entre com seus dados corretamente para acessar <br> o"
				+ " sistema.</html>";
		
		getInformLabel().setText(informativo);
		
		cpfLabel = new JLabel("CPF:");
		cpfLabel.setFont(new Font("Arial",Font.PLAIN, 16));
		cpfLabel.setForeground(Color.white);
		cpfLabel.setBounds(200, 220, 100, 30);
		add(cpfLabel);
		
		try {
			maskFormatter = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		cpfField = new JFormattedTextField(maskFormatter);
		cpfField.setBounds(250, 225, 200, 20);
		add(cpfField);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(230,280, 100,30);
		makeButton(loginButton);
		add(loginButton);
		
		
		
		
	}
	

	public JFormattedTextField getCpfField() {
		return cpfField;
	}

	public JButton getLoginButton() {
		return loginButton;
	}


	public JLabel getCpfLabel() {
		return cpfLabel;
	}
	
	

}
