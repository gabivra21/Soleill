

public class ClientePremium extends Cliente {
    public ClientePremium(String nome, String email, String celular, String senha, float saldo, Carrinho carrinho, String endereco, boolean assinaturaAtiva, String validadeAssinatura) {
        super(nome, email, celular, senha, saldo, carrinho, endereco, assinaturaAtiva, validadeAssinatura);
    }

    @Override
    public  double comprar(Carrinho carrinho) {
        System.out.println("Como Cliente Premium, você possui Frete Grátis!!!");
        System.out.println("O total é :"+carrinho.getValorTotal());
        return carrinho.calcularValorTotal();
    }

    public void cancelarAssinatura(GerenciadorCliente gerenciador) {
        gerenciador.removerClientePremium(this);
        ClienteComum clienteComum = new ClienteComum(nome, email, celular, senha, saldo, carrinho, endereco, false, null);
        gerenciador.adicionarClienteComum(clienteComum);
        System.out.println("Assinatura cancelada com sucesso!");
    }



}
