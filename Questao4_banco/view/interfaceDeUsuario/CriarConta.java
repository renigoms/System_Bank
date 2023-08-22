package view.interfaceDeUsuario;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Cliente;
import view.PainelDeCadastro;

@SuppressWarnings("serial")
public class CriarConta extends PainelDeCadastro{
	
	private Cliente cliente;
	private JTextField salarioField, senhaField, confirSenhField;
	private JLabel confirSenhLabel;

	/**
	 * @param cliente
	 */
	public CriarConta(Cliente cliente) {
		super();
		this.cliente = cliente;
		
		getTitulo().setText("Criar Conta");
		getTitulo().setBounds(130, 20, 300, 100);
		getInformLabel().setText("Crie sua conta aqui!");
		getInformLabel().setBounds(140, 85, 500, 38);
		remove(getCpfField());
		remove(getFoneField());
		
		getNomeJLabel().setText("Agência:");
		getNomeJLabel().setBounds(190, 150, 100, 30);
		getNomeField().setBounds(260, 155, 150, 20);
		getEmaiLabel().setText("Número:");
		getEmaiLabel().setBounds(195, 190, 100, 30);
		getEmailField().setBounds(260,195,150,20);
		getCpfJLabel().setText("Saldo:");
		getCpfJLabel().setBounds(210, 225, 100, 30);
		
		salarioField = new JTextField();
		salarioField.setBounds(260,230,100,20);
		add(salarioField);
		
		getFoneJLabel().setText("Senha:");
		getFoneJLabel().setBounds(205, 260, 80, 30);
		
		senhaField = new JTextField();
		senhaField.setBounds(260, 265, 100, 20);
		add(senhaField);
		
		confirSenhLabel = new JLabel("<html>Confirmar <br> Senha</html>");
		confirSenhLabel.setBounds(180,290,80,40);
		makeLabel(confirSenhLabel);
		add(confirSenhLabel);
		
		confirSenhField = new JTextField();
		confirSenhField.setBounds(260, 300, 100, 20);
		
		add(confirSenhField);
		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public JTextField getSenhaField() {
		return senhaField;
	}

	public JTextField getConfirSenhField() {
		return confirSenhField;
	}

	public JTextField getSalarioField() {
		return salarioField;
	}

	public JLabel getConfirSenhLabel() {
		return confirSenhLabel;
	}
}
