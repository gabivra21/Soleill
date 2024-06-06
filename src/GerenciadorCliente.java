import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

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




        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        boolean assinaturaAtivada = false;
        String validadeAssinatura = null;
        float saldo = 0.0f;

        Carrinho carrinho = new Carrinho(new ArrayList<Produto>(),0,null,0.0); // Inicializar o carrinho vazio

        Cliente novoCliente = new ClienteComum(nome, email, celular, senha, saldo, carrinho, endereco, assinaturaAtivada, validadeAssinatura);
        listaClientes.add(novoCliente);

        System.out.println("Cliente cadastrado com sucesso!!");
    }

    public Cliente loginCliente(String email, String senha) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
                return cliente;
            }
        }
        return null; // Retorna null se o cliente não for encontrado
    }

    public void listarClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("***********Listagem de nossos Clientes**********");
            for (Cliente cliente : listaClientes) {
                System.out.println(cliente);
                System.out.println("---------------");
            }
        }
    }

    public void salvarClientes() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
            outputStream.writeObject(listaClientes);
            System.out.println("Clientes salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }

    public void carregarClientes() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
            listaClientes = (ArrayList<Cliente>) inputStream.readObject();
            System.out.println("Clientes carregados com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar clientes: " + e.getMessage());
        }
    }
}
