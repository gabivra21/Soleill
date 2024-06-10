public class ExcecaoSaldoInsuficiente extends Exception{
    public ExcecaoSaldoInsuficiente(){

    }

    public void exibirEX() {
        System.out.println("O saldo é insuficiente \n Por favor adicione mais saldo ou cancele a compra!");
    }
}
