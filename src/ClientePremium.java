import java.io.Serializable;

public class ClientePremium extends Cliente implements Serializable{
    public ClientePremium(String nome, String email, String celular, String senha, float saldo, Carrinho carrinho, String endereco, boolean assinaturaAtiva, String validadeAssinatura) {
        super(nome, email, celular, senha, saldo, carrinho, endereco, assinaturaAtiva, validadeAssinatura);
    }

    @Override
    public double comprar(Carrinho carrinho) {
        System.out.println("Como Cliente Premium, você possui Frete Grátis!!!");
        System.out.println("O total é :"+carrinho.getValorTotal());
        return carrinho.calcularValorTotal();
    }

}
