package view.interfaceDeUsuario;

import model.Cliente;
import view.PainelDeCadastro;

@SuppressWarnings("serial")
public class InformacoesCliente extends PainelDeCadastro{
	private Cliente cliente;
	
	public InformacoesCliente(Cliente cliente) {
		this.cliente = cliente;
		getTitulo().setText("Dados Pessoais");
		getTitulo().setBounds(130, 20, 400, 100);
		getInformLabel().setText("Bem vindo(a),"
				+ " crie uma conta com a gente!");
		getInformLabel().setBounds(135, 80, 500, 38);
		
		getAddButton().setText("Criar Conta");
		
		getVoltarButton().setText("Acessar Conta");
		getVoltarButton().setBounds(120, 360, 150, 30);
		
		getNomeField().setEditable(false);
		getNomeField().setText(this.cliente.getNome());
		getEmailField().setEditable(false);
		getEmailField().setText(this.cliente.getEmail());
		getCpfField().setEditable(false);
		getCpfField().setText(this.cliente.getCpf());
		getFoneField().setEditable(false);
		getFoneField().setText(this.cliente.getTelefone());
	}

}
