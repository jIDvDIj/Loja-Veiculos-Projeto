package classes;

public class ClienteEspecial extends Pessoa {

	private Conta conta_cliente;
	private double desconto;
	
	public ClienteEspecial(String nome,String cpf, int idade, String email, String rua, String bairro, int numero, Conta conta_cliente, double desconto) {
		super(nome, cpf, idade, email, rua, bairro, numero);
		this.conta_cliente = conta_cliente;
		this.desconto = desconto;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	
	public Conta getConta_cliente() {
		return conta_cliente;
	}

	public void setConta_cliente(Conta conta_cliente) {
		this.conta_cliente = conta_cliente;
	}
}
	

	