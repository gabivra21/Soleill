import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorCliente implements Serializable {
    private ArrayList<ClienteComum> listaClientesComuns;
    private ArrayList<ClientePremium> listaClientesPremium;
    private ArrayList<Cliente> listaTodosClientes;

    public GerenciadorCliente() {
        listaClientesComuns = new ArrayList<>();
        listaClientesPremium = new ArrayList<>();
        listaTodosClientes = new ArrayList<>();
    }

    public void adicionarClienteComum(ClienteComum cliente) {
        listaClientesComuns.add(cliente);
        listaTodosClientes.add(cliente);
    }

    public void adicionarClientePremium(ClientePremium cliente) {
        listaClientesPremium.add(cliente);
        listaTodosClientes.add(cliente);
    }

    public void removerClienteComum(ClienteComum cliente) {
        listaClientesComuns.remove(cliente);
        listaTodosClientes.remove(cliente);
    }

    public void removerClientePremium(ClientePremium cliente) {
        listaClientesPremium.remove(cliente);
        listaTodosClientes.remove(cliente);
    }

    public ArrayList<ClienteComum> getListaClientesComuns() {
        return listaClientesComuns;
    }

    public ArrayList<ClientePremium> getListaClientesPremium() {
        return listaClientesPremium;
    }

    public ArrayList<Cliente> getListaTodosClientes() {
        return listaTodosClientes;
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

        listaClientesComuns.add(novoCliente);
        listaTodosClientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!!");
    }

    public void listarClientes() {
        if (listaTodosClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : listaTodosClientes) {
                System.out.println(cliente);
                System.out.println("---------------");
            }
        }
    }

    // Outros métodos, como logar, salvarClientes, carregarClientes, etc.


public Cliente logar(String email, String senha) {
        for (Cliente cliente : listaTodosClientes) {
            if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
                System.out.println("Login bem-sucedido.");
                return cliente;
            }
        }
        System.out.println("Email ou senha incorretos.");
        return null;
    }

    // Métodos de salvar e carregar clientes (existentes)
    public void salvarClientes() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
            List<Cliente> todosClientes = getListaTodosClientes();
            outputStream.writeObject(todosClientes);
            System.out.println("Clientes salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }

    public void carregarClientes() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
            List<Cliente> todosClientes = (List<Cliente>) inputStream.readObject();
            listaClientesComuns.clear();
            listaClientesPremium.clear();
            for (Cliente cliente : todosClientes) {
                if (cliente instanceof ClienteComum) {
                    listaClientesComuns.add((ClienteComum) cliente);
                } else if (cliente instanceof ClientePremium) {
                    listaClientesPremium.add((ClientePremium) cliente);
                }
            }
            System.out.println("Clientes carregados com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar clientes: " + e.getMessage());
        }
    }
}
