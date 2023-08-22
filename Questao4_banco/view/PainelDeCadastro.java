package view;

import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public class PainelDeCadastro extends PainelLoginCadastroPadrao {
	private MaskFormatter maskCpf, maskFone;
	private JFormattedTextField cpfField, foneField;
	private JTextField nomeField, emailField;
	private JLabel nomeJLabel, emaiLabel, cpfJLabel, foneJLabel;
	
	private JButton addButton;
	
	
	public PainelDeCadastro() {
		getTitulo().setText("<html>Cadastro<br> de Cliente</html>");
		getTitulo().setBounds(130, 30, 300, 100);
		getInformLabel().setText("Cadastre-se agora e vem ser feliz com a gente!");
		getInformLabel().setBounds(120, 120, 500, 38);
		
//		nome
		nomeJLabel = new JLabel("Nome:");
		makeLabel(nomeJLabel);
		nomeJLabel.setBounds(200, 200, 50, 30);
		add(nomeJLabel);
		
		nomeField = new JTextField();
		nomeField.setBounds(260, 205, 150, 20);
		add(nomeField);
		
//		E-MAIL
		
		emaiLabel = new JLabel("E-mail:");
		makeLabel(emaiLabel);
		emaiLabel.setBounds(200, 240, 50, 30);
		add(emaiLabel);
		
		emailField = new JTextField();
		emailField.setBounds(260,245,150,20);
		add(emailField);
		
//		CPF
		
		cpfJLabel = new JLabel("Cpf:");
		makeLabel(cpfJLabel);
		cpfJLabel.setBounds(220, 280, 50, 30);
		add(cpfJLabel);
		
		try {
			maskCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cpfField = new JFormattedTextField(maskCpf);
		cpfField.setBounds(260,285,100,20);
		add(cpfField);
		
//		Telefone
		
		foneJLabel = new JLabel("Telefone:");
		makeLabel(foneJLabel);
		foneJLabel.setBounds(185, 320, 80, 30);
		add(foneJLabel);
		
		try {
			maskFone = new MaskFormatter("(##) # ####-####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		foneField = new JFormattedTextField(maskFone);
		foneField.setBounds(260, 325, 100,20);
		add(foneField);
		
//		botões
		
		getVoltarButton().setBounds(180, 360, 100, 30);
		
		addButton = new JButton("Salvar Informações");
		makeButton(addButton);
		addButton.setBounds(300, 360, 185, 30);
		add(addButton);
		
	}


	public JFormattedTextField getCpfField() {
		return cpfField;
	}


	public JFormattedTextField getFoneField() {
		return foneField;
	}


	public JTextField getNomeField() {
		return nomeField;
	}


	public JTextField getEmailField() {
		return emailField;
	}


	public JButton getAddButton() {
		return addButton;
	}


	public JLabel getNomeJLabel() {
		return nomeJLabel;
	}


	public JLabel getEmaiLabel() {
		return emaiLabel;
	}


	public JLabel getCpfJLabel() {
		return cpfJLabel;
	}


	public JLabel getFoneJLabel() {
		return foneJLabel;
	}
	
	
	
	
}
