public class PagamentoAdapter {
    private SistemaPagamentoExterno sistemaPagamentoExterno;

    public PagamentoAdapter(SistemaPagamentoExterno sistemaPagamentoExterno) {
        this.sistemaPagamentoExterno = sistemaPagamentoExterno;
    }

    public void processarPagamento(Pedido pedido) {
        sistemaPagamentoExterno.processarPagamento(pedido.getNomeCliente(), pedido.getValorTotal());
    }
}
