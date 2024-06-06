import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPage {
    private GerenciadorCliente gerenciador;
    private JFrame frame; // Defina frame como um campo da classe

    public LoginPage(GerenciadorCliente gerenciador) {
        this.gerenciador = gerenciador;
        createUI();
    }

    private void createUI() {
        frame = new JFrame("Login"); // Inicialize frame aqui
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

                Cliente cliente = gerenciador.loginCliente(email, senha);
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
                new CadastroPage(gerenciador);
                frame.dispose(); // Fecha a página de login
            }
        });
    }

    public static void main(String[] args) {
        GerenciadorCliente gerenciador = new GerenciadorCliente();


        gerenciador.cadastrarCliente();

        // Mostrar a página de login
        new LoginPage(gerenciador);
    }
}

class CadastroPage {
    private GerenciadorCliente gerenciador;
    private JFrame frame;

    public CadastroPage(GerenciadorCliente gerenciador) {
        this.gerenciador = gerenciador;
        createUI();
    }

    private void createUI() {
        frame = new JFrame("Cadastro");
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

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(50, 50, 80, 25);
        nomeLabel.setForeground(new Color(255, 255, 0)); // Amarelo
        panel.add(nomeLabel);

        JTextField nomeText = new JTextField(20);
        nomeText.setBounds(150, 50, 165, 25);
        panel.add(nomeText);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 100, 80, 25);
        emailLabel.setForeground(new Color(255, 255, 0)); // Amarelo
        panel.add(emailLabel);

        JTextField emailText = new JTextField(20);
        emailText.setBounds(150, 100, 165, 25);
        panel.add(emailText);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(50, 150, 80, 25);
        senhaLabel.setForeground(new Color(255, 255, 0)); // Amarelo
        panel.add(senhaLabel);

        JPasswordField senhaText = new JPasswordField(20);
        senhaText.setBounds(150, 150, 165, 25);
        panel.add(senhaText);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBounds(150, 200, 100, 25);
        cadastrarButton.setBackground(new Color(255, 255, 0)); // Amarelo
        cadastrarButton.setForeground(new Color(75, 0, 130)); // Roxo
        panel.add(cadastrarButton);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeText.getText();
                String email = emailText.getText();
                String senha = new String(senhaText.getPassword());

                gerenciador.cadastrarCliente();
                JOptionPane.showMessageDialog(panel, "Cadastro realizado com sucesso!");
                frame.dispose(); // Fecha a página de cadastro
                new LoginPage(gerenciador); // Redireciona de volta para a página de login
            }
        });
    }
}
