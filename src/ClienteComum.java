import java.util.ArrayList;

public class ClienteComum extends Cliente {
    public ClienteComum(String nome, String email, int celular, String senha, float saldo) {
        super(nome, email, celular, senha, saldo);
    }

    @Override
    public double comprar(Carrinho carrinho) {
        for (Produto produto : itens){

        }
        return 0;
    }
}
