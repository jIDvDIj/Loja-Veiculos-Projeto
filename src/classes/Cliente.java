package classes;

public class Cliente extends Pessoa {
	private Conta conta_cliente;
	
	public Cliente(String nome, String cpf, int idade, String email, String rua, String bairro, int numero, Conta conta_cliente) {
		super(nome, cpf, idade, email, rua, bairro, numero);
		this.conta_cliente = conta_cliente;
	}

	public Conta getConta_cliente() {
		return conta_cliente;
	}

	public void setConta_cliente(Conta conta_cliente) {
		this.conta_cliente = conta_cliente;
	}
}
