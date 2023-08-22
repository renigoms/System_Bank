package view.interfaceDeUsuario;

import java.text.ParseException;

import javax.swing.JTextField;

import model.Conta;
import view.PainelDeLogin;

@SuppressWarnings("serial")
public class sacarView extends PainelDeLogin{
	
	private JTextField valorField;
	
	private Conta conta;

	public sacarView() throws ParseException {
		remove(getCpfField());
		getTitulo().setText("Sacar");
		getInformLabel().setText("<html>Saque apenas o que você tem e se tiver<br> e nunca a mais"
				+ " do que isso!</html>");
		
		getCpfLabel().setText("Valor:");
		getLoginButton().setText("Sacar esse valor");
		getLoginButton().setBounds(230,280, 200,30);
		
		valorField = new JTextField();
		valorField.setBounds(250, 225, 200, 20);
		add(valorField);
		
		getVoltarButton().setBounds(280, 320, 100, 30);
	}

	public JTextField getValorField() {
		return valorField;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
	
	
	
	
	
	
	
	
}
