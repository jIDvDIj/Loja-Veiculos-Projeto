package classes;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class ReciboVenda {
    private Pessoa cliente;
    private Carro carro;
    private ArrayList <String> carros_vendidos;
    private String data_venda;  // gerado com o Calendar
    private double valorTotal;
    private boolean vendaParcelada;
    private int numeroParcelas;
    private boolean vendido;

    public ReciboVenda(Pessoa cliente, Carro carro, ArrayList <String> carros_vendidos, String data_venda, double valorTotal, boolean vendaParcelada, int numeroParcelas, boolean vendido) {
        this.cliente = cliente;
        this.carro = carro;
        this.carros_vendidos = carros_vendidos;
        this.data_venda = data_venda;
        this.valorTotal = valorTotal;
        this.vendaParcelada = vendaParcelada;
        this.numeroParcelas = numeroParcelas;
        this.vendido = vendido;
    }


	public Pessoa getCliente() {
        return cliente;
    }

    public Carro getCarro() {
        return carro;
    }
    
    public ArrayList<String> getCarros_vendidos() {
		return carros_vendidos;
	}

	public void setCarros_vendidos(ArrayList<String> carros_vendidos) {
		this.carros_vendidos = carros_vendidos;
	}
	
	public String getDataVenda() {
		return data_venda;
	}

	public void setDataVenda(String data_venda) {
		this.data_venda = data_venda;
	}

    public double getValorTotal() {
        return valorTotal;
    }

    public boolean getVendaParcelada() {
        return vendaParcelada;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }
    
    public void setNumeroParcelas(int numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
    }
    
    public boolean getVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");

        String tipoVenda = vendaParcelada ? "Parcelada" : "À vista";
        String detalhesParcelas = vendaParcelada ? " em " + numeroParcelas + " parcelas de R$" + decimalFormat.format(valorTotal / numeroParcelas) : "";
        return "Recibo de Venda\n" +
                "Data: " + getDataVenda() + "\n" +
                "Cliente: " + cliente.getNome() + " (CPF: " + cliente.getCpf() + ")\n" +
                "Carro: " + carro.getModelo() + " Marca: " + carro.getMarca() + " (" + carro.getAnoFabricacao() + ")\n" +
                "Cor: " + carro.getCor() + ", Número de Portas: " + carro.getNumeroPortas() + "\n" +
                "Valor Total: R$" + decimalFormat.format(valorTotal) + detalhesParcelas + " (" + tipoVenda + ")";
    }
}