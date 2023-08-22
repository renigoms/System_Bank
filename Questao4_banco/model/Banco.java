package model;

public class Banco {
	public static boolean depositar(double valor, Conta conta) {
		try {
			conta.setSaldo(conta.getSaldo()+valor);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao efetuar o deposito");
			return false;
		}
	}
	
	public static boolean sacar(double valor, Conta conta) {
		if(conta.getSaldo() != 0 && conta.getSaldo()>=valor) {
			conta.setSaldo(conta.getSaldo()-valor);
			return true;
		}
		System.out.println("Erro ao efetuar o saque");
		return false;
	}
}
