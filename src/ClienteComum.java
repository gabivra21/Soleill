import java.util.ArrayList;

public class ClienteComum extends Cliente {
    public ClienteComum(String nome, String email, int celular, String senha, float saldo, Carrinho carrinho) {
        super(nome, email, celular, senha, saldo, carrinho );
    }

    @Override
    public double comprar(Carrinho carrinho) {
        if (this.carrinho == null || this.carrinho.getItens().isEmpty()) {
            System.out.println("Carrinho vazio");

        }
        double totalCompra = this.carrinho.getValorTotal();
        System.out.println(totalCompra);
        return totalCompra;

        }




    }

