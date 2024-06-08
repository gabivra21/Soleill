import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<ClienteComum> listaClientes;

    public GerenciadorCliente() {
        listaClientes = new ArrayList<>();
        carregarClientes(); // Carregar clientes ao iniciar o gerenciador
    }

    public void adicionarCliente(ClienteComum cliente) {
        listaClientes.add(cliente);
        salvarClientes(); // Salvar após adicionar um cliente
    }

    public int obterIndiceCliente(String email) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getEmail().equals(email)) {
                return i;
            }
        }
        return -1; // Retorna -1 se o cliente não for encontrado
    }

    public ArrayList<ClienteComum> getListaClientes() {
        return listaClientes;
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

        Carrinho carrinho = new Carrinho(new ArrayList<Produto>(), 0, null, 0.0); // Inicializar o carrinho vazio

        ClienteComum novoCliente = new ClienteComum(nome, email, celular, senha, saldo, carrinho, endereco, assinaturaAtivada, validadeAssinatura);
        adicionarCliente(novoCliente); // Adicionar e salvar o cliente

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

    public void salvarClientes() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
            outputStream.writeObject(listaClientes);
            System.out.println("Clientes salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }

    public void carregarClientes() {
        File file = new File("clientes.dat");
        if (!file.exists()) {
            System.out.println("Nenhum cliente cadastrado previamente.");
            return;
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            listaClientes = (ArrayList<ClienteComum>) inputStream.readObject();
            System.out.println("Clientes carregados com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar clientes: " + e.getMessage());
        }
    }

    public Cliente logar(String email, String senha) {
        for (ClienteComum cliente : listaClientes) {
            if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
                System.out.println("Login bem-sucedido!");
                return cliente;
            }
        }
        System.out.println("Email ou senha incorretos.");
        return null;
    }
}
