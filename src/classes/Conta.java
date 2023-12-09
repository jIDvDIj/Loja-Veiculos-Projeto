package classes;
import java.util.ArrayList;

public class Conta {
    private ArrayList<ReciboVenda> recibo_venda;
    private ArrayList<String> historico;

    public Conta(ArrayList<ReciboVenda> recibo_venda, ArrayList<String> historico) {
        this.recibo_venda = recibo_venda;
        this.historico = historico;
    }

    public ArrayList<ReciboVenda> getRecibo_venda() {
        return recibo_venda;
    }

    public void setRecibo_venda(ArrayList<ReciboVenda> recibo_venda) {
        this.recibo_venda = recibo_venda;
    }

    public ArrayList<String> getHistorico() {
        return historico;
    }

    public void setHistorico(ArrayList<String> historico) {
        this.historico = historico;
    }
}
