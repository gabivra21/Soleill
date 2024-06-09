import java.io.Serializable;

public class ClientePremium extends Cliente implements Serializable{
    public ClientePremium(String nome, String email, String celular, String senha, float saldo, Carrinho carrinho, String endereco, boolean assinaturaAtiva, String validadeAssinatura) {
        super(nome, email, celular, senha, saldo, carrinho, endereco, assinaturaAtiva, validadeAssinatura);
    }

    @Override
    public  double comprar(Carrinho carrinho) {
        System.out.println("Como Cliente Premium, você possui Frete Grátis!!!");
        System.out.println("O total é :"+carrinho.getValorTotal());
        return carrinho.calcularValorTotal();
    }

    public void cancelarAssinatura(GerenciadorCliente gerenciador, ClientePremium clientePremium) {
        gerenciador.removerClientePremium(clientePremium);
        ClienteComum clienteComum = new ClienteComum(clientePremium.getNome(), clientePremium.getEmail(), clientePremium.getCelular(), clientePremium.getSenha(), clientePremium.getSaldo(), clientePremium.getCarrinho(), clientePremium.getEndereco(), false, null);
        gerenciador.adicionarClienteComum(clienteComum);
        System.out.println("Assinatura cancelada com sucesso!");
    }



}
