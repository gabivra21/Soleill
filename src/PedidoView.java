import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PedidoView extends JFrame {
    private JTextField tfNomeCliente;
    private JTextField tfQtdeItens;
    private JTextField tfValorTotal;
    private JTextField tfPrazoEntrega;
    private JCheckBox cbEntregue;
    private JTextField tfEndEntrega;

    public PedidoView() {
        setTitle("Cadastro de Pedido");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        tfNomeCliente = new JTextField(20);
        tfQtdeItens = new JTextField(10);
        tfValorTotal = new JTextField(10);
        tfPrazoEntrega = new JTextField(10);
        cbEntregue = new JCheckBox("Entregue");
        tfEndEntrega = new JTextField(20);

        JButton btnSalvar = new JButton("Salvar");

        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarPedido();
            }
        });

        panel.add(new JLabel("Nome do Cliente:"));
        panel.add(tfNomeCliente);
        panel.add(new JLabel("Quantidade de Itens:"));
        panel.add(tfQtdeItens);
        panel.add(new JLabel("Valor Total:"));
        panel.add(tfValorTotal);
        panel.add(new JLabel("Prazo de Entrega (dias):"));
        panel.add(tfPrazoEntrega);
        panel.add(cbEntregue);
        panel.add(new JLabel("Endereço de Entrega:"));
        panel.add(tfEndEntrega);
        panel.add(btnSalvar);

        add(panel);
    }

    private void salvarPedido() {
        String nomeCliente = tfNomeCliente.getText();
        int qtdeItens = Integer.parseInt(tfQtdeItens.getText());
        double valorTotal = Double.parseDouble(tfValorTotal.getText());
        int prazoEntrega = Integer.parseInt(tfPrazoEntrega.getText());
        boolean entregue = cbEntregue.isSelected();
        String endEntrega = tfEndEntrega.getText();

        Pedido pedido = new Pedido(nomeCliente, qtdeItens, null, valorTotal, prazoEntrega, entregue, endEntrega);
        // Aqui você pode fazer algo com o pedido, como salvar em um arquivo ou banco de dados
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PedidoView().setVisible(true);
            }
        });
    }
}
