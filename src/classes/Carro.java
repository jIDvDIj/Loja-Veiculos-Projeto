package classes;

public class Carro {
    private String modelo;
    private String marca;
    private int anoFabricacao;
    private String cor;
    private double preco;
    private int numeroPortas;
    private int quantidade;

    public Carro(String modelo, String marca, int anoFabricacao, String cor, double preco, int numeroPortas, int quantidade) {
        this.modelo = modelo;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.cor = cor;
        this.preco = preco;
        this.numeroPortas = numeroPortas;
        this.quantidade = quantidade;
    }

    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
		this.modelo = modelo;
	}

    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
		this.marca = marca;
	}
    
    
    public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

    public int getAnoFabricacao() {
        return anoFabricacao;
    }
    
    public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

    public String getCor() {
        return cor;
    }
    
    public void setCor(String cor) {
		this.cor = cor;
	}

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }
}