import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Produto> itens;
    private int qtdItens;

    private Cliente cliente;
    private double valorTotal;

    public Carrinho(ArrayList<Produto> itens, int qtdItens, Cliente cliente, double valorTotal) {
        this.itens = itens != null ? itens : new ArrayList<>();
        this.qtdItens = qtdItens;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
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

    public double calcularValorTotal() {
        double total = 0.0;
        for (Produto produto : itens) {
            total += produto.getValor();
        }
        return total;
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
