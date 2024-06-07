import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorCliente implements Serializable {
    private ArrayList<ClienteComum> listaClientes;

    public GerenciadorCliente() {
        listaClientes = new ArrayList<>();
    }

    public void adicionarCliente(ClienteComum cliente) {
        listaClientes.add(cliente);
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

        Carrinho carrinho = new Carrinho(new ArrayList<Produto>(),0,null,0.0); // Inicializar o carrinho vazio

        ClienteComum novoCliente = new ClienteComum(nome, email, celular, senha, saldo, carrinho, endereco, assinaturaAtivada, validadeAssinatura);
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

    public String resumoString(Cliente cliente) {
        return "Nome do Cliente: " + cliente.getNome() + "\n" +
                "Email: " + cliente.getEmail() + "\n" +
                "Senha: " + cliente.getSenha() + "\n" +
                "Celular: " + cliente.getCelular() + "\n";
    }

    public void salvarCliente(Cliente cliente) {
        try (FileWriter writer = new FileWriter("cliente.txt", true)) {
            writer.write(resumoString(cliente));
            writer.write("\n");
            System.out.println("Cliente salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar o cliente: " + e.getMessage());
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
            listaClientes = (ArrayList<ClienteComum>) inputStream.readObject();
            System.out.println("Clientes carregados com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar clientes: " + e.getMessage());
        }
    }
}
