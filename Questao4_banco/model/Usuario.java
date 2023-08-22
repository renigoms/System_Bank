package model;

public abstract class Usuario {
	private String cpf,nome, telefone, email;

	

	/**
	 * @param cpf
	 * @param nome
	 * @param telefone
	 * @param email
	 */
	public Usuario(String cpf, String nome, String telefone, String email) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + "]";
	}
	
	
	
	
}
