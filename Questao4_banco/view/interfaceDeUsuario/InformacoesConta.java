package view.interfaceDeUsuario;

import javax.swing.JButton;

import model.Conta;

@SuppressWarnings("serial")
public class InformacoesConta extends CriarConta{
	
	private Conta conta;
	private JButton depositarButton;

	public InformacoesConta() {
		super(null);
		getNomeField().setEditable(false);
		
		getEmailField().setEditable(false);
		
		getSalarioField().setEditable(false);
		
		remove(getSenhaField());
		remove(getFoneJLabel());
		remove(getConfirSenhField());
		remove(getConfirSenhLabel());
		
		getTitulo().setText("Dados Conta");
		getTitulo().setBounds(130, 20, 350, 100);
		getInformLabel().setText("Informações "
				+ "sobre sua conta.");
		
		getAddButton().setText("Sacar");
		getAddButton().setBounds(280, 360, 100, 30);
		depositarButton = new JButton("Depositar");
		makeButton(depositarButton);
		depositarButton.setBounds(390, 360, 120, 30);
		add(depositarButton);
		getVoltarButton().setBounds(170, 360, 100, 30);
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
		getNomeField().setText(String.valueOf(conta.getAgencia()));
		getEmailField().setText(String.valueOf(conta.getNumero()));
		getSalarioField().setText(String.valueOf(conta.getSaldo()));
	}

	public JButton getDepositarButton() {
		return depositarButton;
	}
	
	
	
	
	
	

}
