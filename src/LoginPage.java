import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class LoginPage {
    private JFrame frame;
    private ArrayList<Cliente> listaClientes;
    private static final String CLIENTES_FILE = "clientes.dat";

    public LoginPage() {
        listaClientes = carregarClientes();
        createUI();
    }

    private void createUI() {
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(75, 0, 130)); // Roxo
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Email:");
        userLabel.setBounds(50, 50, 80, 25);
        userLabel.setForeground(new Color(255, 255, 0)); // Amarelo
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(150, 50, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(50, 100, 80, 25);
        passwordLabel.setForeground(new Color(255, 255, 0)); // Amarelo
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(150, 100, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 80, 25);
        loginButton.setBackground(new Color(255, 255, 0)); // Amarelo
        loginButton.setForeground(new Color(75, 0, 130)); // Roxo
        panel.add(loginButton);

        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(50, 200, 300, 25);
        messageLabel.setForeground(new Color(255, 255, 0)); // Amarelo
        panel.add(messageLabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = userText.getText();
                String senha = new String(passwordText.getPassword());

                Cliente cliente = loginCliente(email, senha);
                if (cliente != null) {
                    messageLabel.setText("Login bem-sucedido!");
                    // Aqui você pode redirecionar o cliente para outra página ou interface
                } else {
                    messageLabel.setText("Email ou senha inválidos.");
                }
            }
        });

        JLabel registerLabel = new JLabel("<html><u>Não possui login? Cadastre-se</u></html>");
        registerLabel.setBounds(100, 180, 200, 25);
        registerLabel.setForeground(new Color(255, 255, 0)); // Amarelo
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(registerLabel);

        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new CadastroPage(listaClientes);
                frame.dispose(); // Fecha a página de login
            }
        });
    }

    private Cliente loginCliente(String email, String senha) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
                return cliente;
            }
        }
        return null;
    }

    private ArrayList<Cliente> carregarClientes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CLIENTES_FILE))) {
            return (ArrayList<Cliente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}

class CadastroPage {
    private JFrame frame;
    private ArrayList<Cliente> listaClientes;
    private static final String CLIENTES_FILE = "clientes.dat";

    public CadastroPage(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
        createUI();
    }

    private void createUI() {
        frame = new JFrame("Cadastro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(75, 0, 130)); // Roxo
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(50, 20, 80, 25);
        nomeLabel.setForeground(new Color(255, 255, 0)); // Amarelo
        panel.add(nomeLabel);

        JTextField nomeText = new JTextField(20);
        nomeText.setBounds(150, 20, 165, 25);
        panel.add(nomeText);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 60, 80, 25);
        emailLabel.setForeground(new Color(255, 255, 0)); // Amarelo
        panel.add(emailLabel);

        JTextField emailText = new JTextField(20);
        emailText.setBounds(150, 60, 165, 25);
        panel.add(emailText);

        JLabel celularLabel = new JLabel("Celular:");
        celularLabel.setBounds(50, 100, 80, 25);
        celularLabel.setForeground(new Color(255, 255, 0)); // Amarelo
        panel.add(celularLabel);

        JTextField celularText = new JTextField(20);
        celularText.setBounds(150, 100, 165, 25);
        panel.add(celularText);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(50, 140, 80, 25);
        senhaLabel.setForeground(new Color(255, 255, 0)); // Amarelo
        panel.add(senhaLabel);

        JPasswordField senhaText = new JPasswordField(20);
        senhaText.setBounds(150, 140, 165, 25);
        panel.add(senhaText);

        JLabel enderecoLabel = new JLabel("Endereço:");
        enderecoLabel.setBounds(50, 180, 80, 25);
        enderecoLabel.setForeground(new Color(255, 255, 0)); // Amarelo
        panel.add(enderecoLabel);

        JTextField enderecoText = new JTextField(20);
        enderecoText.setBounds(150, 180, 165, 25);
        panel.add(enderecoText);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBounds(150, 220, 100, 25);
        cadastrarButton.setBackground(new Color(255, 255, 0)); // Amarelo
        cadastrarButton.setForeground(new Color(75, 0, 130)); // Roxo
        panel.add(cadastrarButton);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeText.getText();
                String email = emailText.getText();
                String celular = celularText.getText();
                String senha = new String(senhaText.getPassword());
                String endereco = enderecoText.getText();

                boolean assinaturaAtivada = false;
                String validadeAssinatura = null;
                float saldo = 0.0f;
                Carrinho carrinho = new Carrinho(new ArrayList<Produto>(), 0, null, 0.0); // Inicializar o carrinho vazio

                Cliente novoCliente = new ClienteComum(nome, email, celular, senha, saldo, carrinho, endereco, assinaturaAtivada, validadeAssinatura);
                listaClientes.add(novoCliente);
                salvarClientes(listaClientes);

                JOptionPane.showMessageDialog(panel, "Cadastro realizado com sucesso!");
                frame.dispose(); // Fecha a página de cadastro
                new LoginPage(); // Redireciona de volta para a página de login
            }
        });
    }

    private void salvarClientes(ArrayList<Cliente> listaClientes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CLIENTES_FILE))) {
            oos.writeObject(listaClientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

