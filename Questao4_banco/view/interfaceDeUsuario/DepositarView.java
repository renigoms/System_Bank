package view.interfaceDeUsuario;

import java.text.ParseException;

import javax.swing.JTextField;

import model.Conta;
import view.PainelDeLogin;

@SuppressWarnings("serial")
public class DepositarView extends PainelDeLogin{
	private Conta conta;
	private JTextField valorField;
	public DepositarView() throws ParseException {
		remove(getCpfField());
		getCpfLabel().setText("Valor:");
		getLoginButton().setText("Depositar esse valor");
		getLoginButton().setBounds(230,280, 200,30);
		
		getTitulo().setText("Depositar");
		getInformLabel().setText("Cuidaremos do seu dinheiro para você!");
		
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
