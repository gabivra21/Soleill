import java.util.ArrayList;
import java.io.Serializable;


public class ClienteComum extends Cliente implements Serializable {

    public ClienteComum() {
        // Construtor padrão necessário para a desserialização
    }

    public ClienteComum(String nome, String email, String celular, String senha, float saldo, Carrinho carrinho, String endereco, boolean assinaturaAtiva, String validadeAssinatura) {
        super(nome, email, celular, senha, saldo, carrinho, endereco, assinaturaAtiva, validadeAssinatura);
    }

    @Override
    public double comprar(Carrinho carrinho) {
        if (this.carrinho == null || this.carrinho.getItens().isEmpty()) {
            System.out.println("Carrinho vazio");

        }
        int frete = 15;
        double totalCompra =  this.carrinho.getValorTotal() + frete;
        System.out.println();
        System.out.println("O valor total de sua compra com o frete é "+totalCompra);
        return totalCompra;

        }

    /*public void ativarAssinatura(ClienteComum clienteComum){
        String clienteProcurado = "";
        int index = GerenciadorCliente.listaClientes.indexOf(clienteProcurado);

        if (index != -1) {
            System.out.println("O cliente " + clienteProcurado + " está no índice: " + index);
        } else {
            System.out.println("Cliente não encontrado na lista.");
        }*/

}

