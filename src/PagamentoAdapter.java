public class PagamentoAdapter {
    private SistemaPagamentoExterno sistemaPagamentoExterno;

    public PagamentoAdapter(SistemaPagamentoExterno sistemaPagamentoExterno) {
        this.sistemaPagamentoExterno = sistemaPagamentoExterno;
    }

    public void processarPagamento(Pedido pedido) {
        int valorEmCentavos = (int) Math.round(pedido.getValorTotal() * 100);
        sistemaPagamentoExterno.processarPagamento(pedido.getNomeCliente(), valorEmCentavos);
    }

}
