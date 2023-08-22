package view.interfaceDeUsuario;

import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Cliente;
import view.PainelDeLogin;

@SuppressWarnings("serial")
public class AcessarConta extends PainelDeLogin{
	private JLabel numLabel, agenLabel;
	private JTextField numField, agenField;
	private JPasswordField senhaField;
	private Cliente cliente;
	public AcessarConta(Cliente cliente) throws ParseException{
		remove(getCpfField());
		getTitulo().setText("Conta");
		getInformLabel().setText("Acesse sua conta por aqui.");
		getCpfLabel().setText("Senha:");
		getCpfLabel().setBounds(370, 220, 100, 30);
		getLoginButton().setText("Acessar");
		this.cliente = cliente;
		
		senhaField = new JPasswordField();
		senhaField.setBounds(425, 225, 80, 20);
		add(senhaField);
		
		numLabel = new JLabel("Número:");
		numLabel.setBounds(205,225,100,20);
		makeLabel(numLabel);
		add(numLabel);
		
		numField = new JTextField();
		numField.setBounds(270, 225, 80, 20);
		add(numField);
		
		agenLabel = new JLabel("Agência:");
		agenLabel.setBounds(270, 180, 100, 20);
		makeLabel(agenLabel);
		add(agenLabel);
		
		agenField = new JTextField();
		agenField.setBounds(340, 180, 100, 20);
		add(agenField);

		
	}
	public JTextField getNumField() {
		return numField;
	}
	public JTextField getAgenField() {
		return agenField;
	}
	public JPasswordField getSenhaField() {
		return senhaField;
	}
	public Cliente getCliente() {
		return cliente;
	}
	
	
	
	
}
