import java.util.Scanner;
import java.util.ArrayList;

public class PedidoConsole {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de Pedido");

        // Criando um carrinho vazio
        Carrinho carrinho = new Carrinho(new ArrayList<>(), 0, null, 0.0);

        // Solicita o nome do cliente
        System.out.print("Nome do Cliente: ");
        String nomeCliente = scanner.nextLine();

        // Solicita o endereço de entrega
        System.out.print("Endereço de Entrega: ");
        String endEntrega = scanner.nextLine();

        // Solicita o prazo de entrega
        System.out.print("Prazo de Entrega (dias): ");
        int prazoEntrega = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha

        // Solicita se foi entregue
        System.out.print("Entregue (true/false): ");
        boolean entregue = scanner.nextBoolean();
        scanner.nextLine();  // Consumir a nova linha

        // Cria o pedido
        Pedido pedido = new Pedido(nomeCliente, carrinho.getQtdItens(), carrinho.getItens(), carrinho.calcularValorTotal(), prazoEntrega, entregue, endEntrega);

        // Salva o pedido em um arquivo
        Pedido.escreverPedidoNoArquivo(pedido);

        // Fecha o scanner
        scanner.close();
    }
}
