import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorCliente  {
	private FileClienteAdapter ClienteAdapter;
    private ArrayList<ClienteComum> listaClientesComuns;
    private ArrayList<ClientePremium> listaClientesPremium;
    private ArrayList<Cliente> listaTodosClientes;

    public GerenciadorCliente() throws IOException {
    	ClienteAdapter = new FileClienteAdapter("clientes.txt");
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

    public void cadastrarCliente() throws IOException {
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

        Carrinho carrinho = new Carrinho(new ArrayList<Produto>(), 0, null, 0.0);

        ClienteComum novoCliente = new ClienteComum(nome, email, celular, senha, saldo, carrinho, endereco, assinaturaAtivada, validadeAssinatura);


        listaClientesComuns.add(novoCliente);
        listaTodosClientes.add(novoCliente);
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


    public void salvarClientes() throws IOException {
        ClienteAdapter.saveClients(listaTodosClientes);
    }

    public void carregarClientes() throws IOException {
    	this.listaTodosClientes = ClienteAdapter.loadClients();
    }

    public void ativarAssinaturaClienteADM() throws IOException{
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

    public void listarPedidos() {
        File file = new File("pedido.txt");
        if (!file.exists()) {
            System.out.println("Nenhum arquivo de pedidos encontrado.");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            System.out.println("Pedidos listados com sucesso!");
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao carregar pedidos: Arquivo não encontrado.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erro ao carregar pedidos: " + e.getMessage());
            e.printStackTrace();
        }
    }




}
