
import java.util.ArrayList;

public class CarrinhoSingleton  {
    private ArrayList<Produto> itens;
    private int qtdItens;
    private static CarrinhoSingleton instancia;

    private Cliente cliente;
    private double valorTotal;

    private CarrinhoSingleton(ArrayList<Produto> itens, int qtdItens, Cliente cliente, double valorTotal) {
        this.itens = itens != null ? itens : new ArrayList<>();
        this.qtdItens = qtdItens;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
    }

    private CarrinhoSingleton() {}

    public static CarrinhoSingleton getInstance(ArrayList<Produto> itens, int qtdItens, Cliente cliente, double valorTotal) {
        if (instancia == null) {
            instancia = new Carrinho(itens, qtdItens, cliente, valorTotal);
        }
        return instancia;
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

    public void exibirCarrinho(Cliente cliente) {
        for(Produto produto :itens){
            System.out.println("Produtos do carrinho:");
            cliente.visualizarProduto(produto);
            int qi = this.getQtdItens();
            System.out.println("Contabilizando " + qi +" itens no total.");
            this.calcularValorTotal();
            double vt = this.getValorTotal();
            System.out.println("Valor (sem o frete): "+vt);
        }
    }


}
