import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClienteView extends JFrame {
    private Cliente cliente;

    private JTextField nomeField;
    private JTextField emailField;
    private JTextField celularField;
    private JTextField senhaField;
    private JTextField saldoField;
    private JTextField enderecoField;
    private JCheckBox assinaturaAtivaBox;
    private JTextField validadeAssinaturaField;

    public ClienteView(Cliente cliente) {
        this.cliente = cliente;

        setTitle("Gerenciar Cliente");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2));

        panel.add(new JLabel("Nome:"));
        nomeField = new JTextField(cliente.getNome());
        panel.add(nomeField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField(cliente.getEmail());
        panel.add(emailField);

        panel.add(new JLabel("Celular:"));
        celularField = new JTextField(String.valueOf(cliente.getCelular()));
        panel.add(celularField);

        panel.add(new JLabel("Senha:"));
        senhaField = new JTextField(cliente.getSenha());
        panel.add(senhaField);

        panel.add(new JLabel("Saldo:"));
        saldoField = new JTextField(String.valueOf(cliente.getSaldo()));
        panel.add(saldoField);

        panel.add(new JLabel("Endereço:"));
        enderecoField = new JTextField(cliente.getEndereco());
        panel.add(enderecoField);

        panel.add(new JLabel("Assinatura Ativa:"));
        assinaturaAtivaBox = new JCheckBox();
        assinaturaAtivaBox.setSelected(cliente.isAssinaturaAtiva());
        panel.add(assinaturaAtivaBox);

        panel.add(new JLabel("Validade Assinatura:"));
        validadeAssinaturaField = new JTextField(cliente.getValidadeAssinatura());
        panel.add(validadeAssinaturaField);

        JButton saveButton = new JButton("Salvar");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveCliente();
            }
        });
        panel.add(saveButton);

        JButton criarPedidoButton = new JButton("Criar Pedido");
        criarPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarPedido();
            }
        });
        panel.add(criarPedidoButton);

        add(panel);
    }

    private void saveCliente() {
        cliente.setNome(nomeField.getText());
        cliente.setEmail(emailField.getText());
        cliente.setCelular(celularField.getText());
        cliente.setSenha(senhaField.getText());
        cliente.setSaldo(Float.parseFloat(saldoField.getText()));
        cliente.setEndereco(enderecoField.getText());
        cliente.setAssinaturaAtiva(assinaturaAtivaBox.isSelected());
        cliente.setValidadeAssinatura(validadeAssinaturaField.getText());

        JOptionPane.showMessageDialog(this, "Dados do cliente salvos com sucesso!");
    }

    private void criarPedido() {
        String endEntrega = JOptionPane.showInputDialog(this, "Endereço de Entrega:");
        int prazoEntrega = Integer.parseInt(JOptionPane.showInputDialog(this, "Prazo de Entrega (dias):"));
        cliente.criarPedido(endEntrega, prazoEntrega);
        JOptionPane.showMessageDialog(this, "Pedido criado com sucesso!");
    }

    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho(new ArrayList<Produto>(), 0,null, 0.0);
        Cliente cliente = new Cliente("Nome", "email@example.com", "(41)123456789", "senha", 100.0f, carrinho, "Endereço", false, null) {
            @Override
            public double comprar(Carrinho carrinho) {
                return 0;
            }
        };

        ClienteView frame = new ClienteView(cliente);
        frame.setVisible(true);
    }
}
