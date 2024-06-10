import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorCliente  {
    private ArrayList<ClienteComum> listaClientesComuns;
    private ArrayList<ClientePremium> listaClientesPremium;
    private ArrayList<Cliente> listaTodosClientes;

    public GerenciadorCliente() {
        listaClientesComuns = new ArrayList<>();
        listaClientesPremium = new ArrayList<>();
        listaTodosClientes = new ArrayList<>();
        carregarClientes();
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
        Cliente c = novoCliente;

        listaClientesComuns.add(novoCliente);
        listaTodosClientes.add(c);
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
            e.printStackTrace();
        }
    }

    public void carregarClientes() {
        File file = new File("clientes.txt");
        if (!file.exists()) {
            System.out.println("Nenhum arquivo de clientes encontrado. Um novo arquivo será criado.");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Cliente cliente = Cliente.fromFileString(line);
                listaTodosClientes.add(cliente);
            }
            System.out.println("Clientes carregados com sucesso!");
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao carregar clientes: Arquivo não encontrado.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erro ao carregar clientes: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void ativarAssinaturaClienteADM(){
        Scanner scannerAD = new Scanner(System.in);
        System.out.print("Email do cliente para ativar assinatura: ");
        String emailAtivacao = scannerAD.nextLine();
        System.out.print("Senha: ");
        String senhaAtivacao = scannerAD.nextLine();
        Cliente clienteAtivacao = logar(emailAtivacao, senhaAtivacao);
        if (clienteAtivacao instanceof ClienteComum) {
            ((ClienteComum) clienteAtivacao).ativarAssinatura(this);
            this.salvarClientes();
        } else {
            System.out.println("Cliente não encontrado ou já é premium.");
        }
    }
}
