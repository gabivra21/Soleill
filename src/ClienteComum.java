import java.util.ArrayList;



public class ClienteComum extends Cliente  {

    public ClienteComum() {

    }

    public ClienteComum(String nome, String email, String celular, String senha, double saldo, Carrinho carrinho, String endereco, boolean assinaturaAtiva, String validadeAssinatura) {
        super(nome, email, celular, senha, saldo, carrinho, endereco, assinaturaAtiva, validadeAssinatura);
    }


    @Override
    public  double comprar(Carrinho carrinho) {
        if (this.carrinho == null || this.carrinho.getItens().isEmpty()) {
            System.out.println("Carrinho vazio");

        }
        int frete = 15;
        double totalCompra =  this.carrinho.getValorTotal() + frete;
        System.out.println();
        System.out.println("O valor total de sua compra com o frete é "+totalCompra);
        return totalCompra;

        }

    public void ativarAssinatura(GerenciadorCliente gerenciadorCliente) {
        gerenciadorCliente.removerClienteComum(this);
        ClientePremium clientePremium = new ClientePremium(nome, email, celular, senha, saldo, carrinho, endereco, true, validadeAssinatura);;
        gerenciadorCliente.adicionarClientePremium(clientePremium);
        System.out.println("Assinatura ativada com sucesso!");
    }

}

