package model;

import java.util.ArrayList;

public class BaseDeDados {
	private static ArrayList<Cliente> clientes = new ArrayList<>();
	
	public static Cliente buscarCliente(Cliente cliente) {
		return buscarCliente(cliente.getCpf());
	}
	
	public static Cliente buscarCliente(String cpf) {
		for(Cliente clientBusc:clientes)
			if(clientBusc.getCpf().equalsIgnoreCase(cpf))
				return clientBusc;
		return null;
	}
	
	public static boolean isCliente(Cliente cliente) {
		return clientes.contains(buscarCliente(cliente));
	}
	
	public static boolean adicionarCliente(Cliente cliente) {
		if(!isCliente(cliente))
			return clientes.add(cliente);
		return false;
	}
	
	public static boolean removerCliente(Cliente cliente) {
		if(isCliente(cliente))
			return clientes.remove(buscarCliente(cliente));
		return false;
	}
	
	public static boolean atualizarCliente(Cliente oldCliente, Cliente newCliente) {
		oldCliente.setContas(newCliente.getContas());
		oldCliente.setCpf(newCliente.getCpf());
		oldCliente.setEmail(newCliente.getEmail());
		oldCliente.setNome(newCliente.getNome());
		oldCliente.setTelefone(newCliente.getTelefone());
		return isCliente(newCliente);
	}
	
	

}
