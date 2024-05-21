import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Produto> itens;
    private int qtdItens;
    private String endEntrega;
    private Cliente cliente;
    private double valorTotal;

    public Carrinho(ArrayList<Produto> itens, int qtdItens, String endEntrega,Cliente cliente, double valorTotal) {
        this.itens = itens;
        this.qtdItens = 0;
        this.endEntrega = endEntrega;
        this.cliente = cliente;
        this.valorTotal = 0;
    }

    public void addItem(Produto produto) {
        this.itens.add(produto);
        this.qtdItens++;
        this.valorTotal += produto.getValor();
    }

    public void removerItem(Produto produto) {
        this.itens.remove(produto);
        this.qtdItens--;
        this.valorTotal -= produto.getValor();
    }

    public ArrayList<Produto> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Produto> itens) {
        this.itens = itens;
    }

    public int getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(int qtdItens) {
        this.qtdItens = qtdItens;
    }

    public String getEndEntrega() {
        return endEntrega;
    }

    public void setEndEntrega(String  endEntrega) {
        this.endEntrega = endEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
