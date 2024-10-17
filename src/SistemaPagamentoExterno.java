public class SistemaPagamentoExterno {
    public void processarPagamento(String nomeCliente, int valorEmCentavos) {
        System.out.println("Pagamento processado para o cliente " + nomeCliente + " no valor de R$ " + (valorEmCentavos / 100.0));
    }
}
