package model;

import java.util.ArrayList;

public class Cliente extends Usuario {
	private ArrayList<Conta> contas;

	/**
	 * @param cpf
	 * @param nome
	 * @param telefone
	 * @param email
	 */
	public Cliente(String cpf, String nome, String telefone, String email) {
		super(cpf, nome, telefone, email);
		contas = new ArrayList<>();
	}

	public ArrayList<Conta> getContas() {
		return contas;
	}

	public void setContas(ArrayList<Conta> contas) {
		this.contas = contas;
	}
	
	public  Conta buscarConta(int agencia, int numero, String senha) {
		 for(Conta conta:contas) {
			 if(conta.getAgencia()== agencia &&
					 conta.getNumero() == numero &&
					 conta.getSenha().equalsIgnoreCase(senha))
				 return conta;
		 }return null;
	}

	@Override
	public String toString() {
		return "Cliente [contas=" + contas + "]";
	}
	
	
	
	

	
	
	
	
	
}
