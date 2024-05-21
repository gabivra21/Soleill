public class ClientePremium extends Cliente {
    public ClientePremium(String nome, String email, int celular, String senha, float saldo) {
        super(nome, email, celular, senha, saldo);
    }

    @Override
    public double comprar(Carrinho carrinho) {
        System.out.println("Como Cliente Premium, você possui Frete Grátis!!!");
        return 0;
    }

}
