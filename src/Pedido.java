import java.io.FileWriter;
import java.io.IOException;

public class Pedido {
  private String nomeCliente;
  private int qtdeItens;
  private String produto;
  private double valorTotal;
  private int prazoEntrega;
  private boolean entregue;
  private String endEntrega;

  public Pedido(String nomeCliente, int qtdeItens, String produto, double valorTotal, int prazoEntrega, boolean entregue, String endEntrega) {
    this.nomeCliente = nomeCliente;
    this.qtdeItens = qtdeItens;
    this.produto = produto;
    this.valorTotal = valorTotal;
    this.prazoEntrega = prazoEntrega;
    this.entregue = entregue;
    this.endEntrega = endEntrega;

  }

  @Override
  public String resumoString() {
    return "Nome do Cliente: " + nomeCliente + "\n" +
            "Quantidade: " + qtdeItens + "\n" +
            "Produtos: " + produto + "\n" +
            "Valor Total: " + valorTotal + "\n" +
            "Prazo de Entrega: " + prazoEntrega + " dias\n" +
            "Entregue: " + entregue + "\n" +
            "Endereço de Entrega: " + endEntrega + "\n";
  }

  public static void main() {
    Pedido pedido = new Pedido(nomeCliente, produto, quantidade, preco, prazoEntrega, entregue, qtdeItens, endEntrega);
    escreverPedidoNoArquivo(pedido);
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
}
