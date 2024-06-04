import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Pedido {
  private String nomeCliente;
  private int qtdeItens;
  private ArrayList<Produto> produtos;
  private double valorTotal;
  private int prazoEntrega;
  private boolean entregue;
  private String endEntrega;

  public Pedido(String nomeCliente, int qtdeItens,ArrayList<Produto> produtos , double valorTotal, int prazoEntrega, boolean entregue, String endEntrega) {
    this.nomeCliente = nomeCliente;
    this.qtdeItens = qtdeItens;
    this.produtos = produtos;
    this.valorTotal = valorTotal;
    this.prazoEntrega = prazoEntrega;
    this.entregue = entregue;
    this.endEntrega = endEntrega;

  }


  public String resumoString() {
    return "Nome do Cliente: " + nomeCliente + "\n" +
            "Quantidade: " + qtdeItens + "\n" +
            "Produtos: " + produtos + "\n" +
            "Valor Total: " + valorTotal + "\n" +
            "Prazo de Entrega: " + prazoEntrega + " dias\n" +
            "Entregue: " + entregue + "\n" +
            "Endereço de Entrega: " + endEntrega + "\n";
  }



  public static void escreverPedidoNoArquivo(Pedido pedido) {
    try (FileWriter writer = new FileWriter("pedido.txt", true)) {
      writer.write(pedido.resumoString());
      writer.write("\n");
      System.out.println("Pedido salvo com sucesso!");
    } catch (IOException e) {
      System.out.println("Ocorreu um erro ao salvar o pedido: " + e.getMessage());
    }
  }

  public String getNomeCliente() {
    return nomeCliente;
  }

  public void setNomeCliente(String nomeCliente) {
    this.nomeCliente = nomeCliente;
  }

  public int getQtdeItens() {
    return qtdeItens;
  }

  public void setQtdeItens(int qtdeItens) {
    this.qtdeItens = qtdeItens;
  }

  public ArrayList<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(ArrayList<Produto> produtos) {
    this.produtos = produtos;
  }

  public double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public int getPrazoEntrega() {
    return prazoEntrega;
  }

  public void setPrazoEntrega(int prazoEntrega) {
    this.prazoEntrega = prazoEntrega;
  }

  public boolean isEntregue() {
    return entregue;
  }

  public void setEntregue(boolean entregue) {
    this.entregue = entregue;
  }

  public String getEndEntrega() {
    return endEntrega;
  }

  public void setEndEntrega(String endEntrega) {
    this.endEntrega = endEntrega;
  }
}
