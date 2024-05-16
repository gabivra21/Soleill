import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Produto> itens;
    private int qtdItens;
    private Endereco endEntrega;
    private Cliente cliente;
    private double valorTotal;

    public Carrinho() {
        this.itens = new ArrayList<Produto>();
        this.qtdItens = 0;
        this.endEntrega = new Endereco();
        this.cliente = new Cliente();
        this.valorTotal = 0.0;
    }

    public void addItem(Produto produto) {
        this.itens.add(produto);
        this.qtdItens++;
        this.valorTotal += produto.getPreco();
    }

    public void removerItem(Produto produto) {
        this.itens.remove(produto);
        this.qtdItens--;
        this.valorTotal -= produto.getPreco();
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

    public Endereco getEndEntrega() {
        return endEntrega;
    }

    public void setEndEntrega(Endereco endEntrega) {
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
