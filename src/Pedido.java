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
}
