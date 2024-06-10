import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public Menu() {
    }

    public void printMenu(GerenciadorProduto gerenciadorProduto, ArrayList<Produto> vestuario, ArrayList<Produto> calcados,  GerenciadorCliente gerenciadorCliente, ExcecaoSaldoInsuficiente excecaoSaldoInsuficiente) {
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("************* MENU *************");
            System.out.println("1 - CADASTRE-SE");
            System.out.println("2 - FAÇA LOGIN");
            System.out.println("3 - SAIR");
            System.out.print("Escolha a opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                gerenciadorCliente.cadastrarCliente();
            } else if (opcao == 2) {
                System.out.print("Digite seu e-mail: ");
                String email = scanner.nextLine();

                System.out.print("Digite sua senha: ");
                String senha = scanner.nextLine();

                Cliente cliente = gerenciadorCliente.logar(email, senha);
                if (cliente != null) {
                    exibirMenuLogado(gerenciadorProduto, vestuario, calcados, cliente, gerenciadorCliente, excecaoSaldoInsuficiente);
                }
            } else if (opcao == 3) {
                System.out.println("Saindo...");
                System.exit(0);
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);
    }

    public void exibirMenuLogado(GerenciadorProduto gerenciadorProduto, ArrayList<Produto> vestuario, ArrayList<Produto> calcados, Cliente cliente, GerenciadorCliente gerenciadorCliente, ExcecaoSaldoInsuficiente excecaoSaldoInsuficiente) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("************* MENU CLIENTE *************");
            System.out.println("1 - Listar Nosso Vestuário.");
            System.out.println("2 - Listar Calçados.");
            System.out.println("3 - Adicionar produto ao carrinho.");
            System.out.println("4 - Remover produto do carrinho.");
            System.out.println("5 - Visualizar Carrinho.");
            System.out.println("6 - Sair.");


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
                    System.out.println("Digite o nome do item:");
                    String nomeProdutoR = scanner.nextLine();

                    Produto produtoR = buscarProduto(nomeProdutoR, vestuario, calcados);
                    if (produtoR != null) {
                        cliente.getCarrinho().removerItem(produtoR);
                        System.out.println("Produto removido do carrinho.");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 5:
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
                            System.out.println("O seu saldo atual é de: "+cliente.getSaldo());
                            System.out.println("Para confirmar o pagamen você deve aumentá-lo!");
                            System.out.println("Digite a quantia a adicionar: ");
                            Scanner scannerQT = new Scanner(System.in);
                            float qt = scannerQT.nextFloat();

                            cliente.setSaldo(cliente.getSaldo() + qt);
                            System.out.println("Para confirmar o pagamento DIGITE 1 \n Para fechar o site DIGITE 2:");
                            Scanner scannerP = new Scanner(System.in);
                            int confirmacao = scannerP.nextInt();
                            if (confirmacao == 1){
                                if (cliente.getSaldo() > cliente.carrinho.getValorTotal()){
                                    System.out.println("Compra realizada!");
                                    cliente.criarPedido(cliente.getEndereco(),15);

                                }else {
                                    excecaoSaldoInsuficiente.exibirEX();
                                }
                            } else if (confirmacao == 2) {
                                System.exit(2);
                            }

                        }
                        if (gerenciadorCliente.getListaClientesPremium().contains(cliente)){
                            cliente.comprar(cliente.carrinho);
                        }
                    }else if (opc == 2) {
                        System.out.println("Tudo bem!Talvez na próxima :( ");
                    }else {
                        System.out.println("Opção inválida");
                    }

                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);
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