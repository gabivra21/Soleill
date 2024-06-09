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

    }

    public void removerClientePremium(ClientePremium cliente) {
        listaClientesPremium.remove(cliente);

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
        Cliente novoCliente1 = new ClienteComum(nome, email, celular, senha, saldo, carrinho, endereco, assinaturaAtivada, validadeAssinatura);

        listaClientesComuns.add(novoCliente);
        listaTodosClientes.add(novoCliente1);
        salvarClientes();
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
        try (PrintWriter writer = new PrintWriter(new FileWriter("clientes.txt"))) {
            for (Cliente cliente : listaTodosClientes) {
                writer.println(cliente.toFileString());
            }
            System.out.println("Clientes salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }

    public void carregarClientes() {
        try (Scanner scanner = new Scanner(new File("clientes.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String nome = parts[0];
                String email = parts[1];
                String celular = parts[2];
                String senha = parts[3];
                float saldo = Float.parseFloat(parts[4]);
                // Adicionar outros campos conforme necessário
                String endereco = parts[5];
                boolean assinaturaAtiva = Boolean.parseBoolean(parts[6]);
                String validadeAssinatura = parts[7];

                // Carrinho - Vamos criar um novo carrinho vazio para cada cliente por enquanto
                Carrinho carrinho = new Carrinho();

                Cliente cliente = new ClienteComum(nome, email, celular, senha, saldo, carrinho, endereco, assinaturaAtiva, validadeAssinatura);
                listaTodosClientes.add(cliente);
            }
            System.out.println("Clientes carregados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar clientes: " + e.getMessage());
        }
    }
}
