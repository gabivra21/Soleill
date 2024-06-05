import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorCliente {
    private ArrayList<Cliente> listaClientes;

    public GerenciadorCliente() {
        this.listaClientes = new ArrayList<>();
    }

    public void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Celular: ");
        String celular = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("Saldo: ");
        float saldo = Float.parseFloat(scanner.nextLine());

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        boolean assinaturaAtivada = false;
        String validadeAssinatura = null;


        Carrinho carrinho = new Carrinho(new ArrayList<Produto>(),0,null,0.0); // Inicializar o carrinho vazio

        Cliente novoCliente = new ClienteComum(nome, email, celular, senha, saldo, carrinho, endereco, assinaturaAtivada, validadeAssinatura);
        listaClientes.add(novoCliente);

        System.out.println("Cliente cadastrado com sucesso!!");
    }

    public void listarClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : listaClientes) {
                System.out.println(cliente);
                System.out.println("---------------");
            }
        }
    }
}
