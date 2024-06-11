public class ExcecaoSaldoInsuficiente extends Exception {
    private static final String MENSAGEM_PADRAO = "Saldo Insuficiente :(\n Adicione mais ou encerre a compra.";

    public ExcecaoSaldoInsuficiente() {
        super(MENSAGEM_PADRAO);
    }

    public ExcecaoSaldoInsuficiente(String mensagem) {
        super(mensagem);
    }

    public void exibirEX() {
        System.out.println("Erro: " + getMessage());
    }
}
