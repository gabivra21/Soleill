import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public Menu() {
    }

    public void printMenu(GerenciadorCliente gerenciadorCliente, GerenciadorProduto gerenciadorProduto, ArrayList<Produto> vestuario, ArrayList<Produto> calcados) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("************* MENU *************");
            System.out.println("1 - CADASTRE-SE");
            System.out.println("2 - FAÇA LOGIN");
            System.out.println("3 - SAIR");
            System.out.print("Escolha a opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            if (opcao == 1) {
                gerenciadorCliente.cadastrarCliente();
            } else if (opcao == 2) {
                System.out.print("Digite seu e-mail: ");
                String email = scanner.nextLine();

                System.out.print("Digite sua senha: ");
                String senha = scanner.nextLine();

                Cliente cliente = gerenciadorCliente.logar(email, senha);
                if (cliente != null) {
                    // Verifica se o cliente é Premium ou Comum
                    if (gerenciadorCliente.getListaClientesPremium().contains(cliente)) {
                        System.out.println("Cliente Premium logado.");
                        ClientePremium clientePremium = (ClientePremium) cliente;
                        exibirMenuLogado(gerenciadorProduto, vestuario, calcados, clientePremium, gerenciadorCliente);
                    } else if (gerenciadorCliente.getListaClientesComuns().contains(cliente)) {
                        System.out.println("Cliente Comum logado.");
                        ClienteComum clienteComum = (ClienteComum) cliente;
                        exibirMenuLogado(gerenciadorProduto, vestuario, calcados, clienteComum, gerenciadorCliente);
                    }
                }
            } else if (opcao == 3) {
                System.out.println("Saindo...");
                System.exit(0);
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);
    }

    public void exibirMenuLogado(GerenciadorProduto gerenciadorProduto, ArrayList<Produto> vestuario, ArrayList<Produto> calcados, Cliente cliente, GerenciadorCliente gerenciadorCliente) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("************* MENU CLIENTE *************");
            System.out.println("1 - Listar Nosso Vestuário.");
            System.out.println("2 - Listar Calçados.");
            System.out.println("3 - Adicionar produto ao carrinho.");
            System.out.println("4 - Visualizar Carrinho.");
            System.out.println("5 - Sair.");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.println("------------ Listagem do Vestuário ------------");
                    gerenciadorProduto.listarVestuario(vestuario);
                    break;
                case 2:
                    System.out.println("------------ Listagem dos Calçados ------------");
                    gerenciadorProduto.listarCalcados(calcados);
                    break;
                case 3:
                    System.out.println("Digite o nome do item:");
                    String nomeProduto = scanner.nextLine();

                    Produto produto = buscarProduto(nomeProduto, vestuario, calcados);
                    if (produto != null) {
                        cliente.getCarrinho().addItem(produto);
                        System.out.println("Produto adicionado ao carrinho.");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("------------ Visualização do Carrinho ------------");
                    cliente.getCarrinho().exibirCarrinho(cliente);
                    System.out.println("Deseja concluir a compra?");
                    System.out.println("1. Sim");
                    System.out.println("2. Não");
                    Scanner scannerT = new Scanner(System.in);
                    int opc = scannerT.nextInt();
                    if(opc == 1){
                        if (gerenciadorCliente.getListaClientesComuns().contains(cliente)){
                            cliente.comprar(cliente.carrinho);
                        }
                        if (gerenciadorCliente.getListaClientesPremium().contains(cliente)){
                            cliente.comprar(cliente.carrinho);
                        }
                    }else{
                        System.out.println("Tudo bem!Talvez na próxima :( ");
                    }

                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }

    private Produto buscarProduto(String nomeProduto, ArrayList<Produto> vestuario, ArrayList<Produto> calcados) {
        for (Produto produto : vestuario) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                return produto;
            }
        }
        for (Produto produto : calcados) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                return produto;
            }
        }
        return null;
    }
}