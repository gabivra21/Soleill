import java.util.ArrayList;

public class GerenciadorProduto {
    public GerenciadorProduto(){

    }

    public void listarVestuario(ArrayList<Produto> vestuario) {
        if (vestuario.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Produtos cadastrados:");
            for (Produto produto: vestuario) {
                System.out.println("Nome: " + produto.getNome() + ", Valor: " + produto.getValor() + ", Estoque: " + produto.getEstoque());
            }
        }
    }

    public void listarCalcados(ArrayList<Produto> calcados) {
        if (calcados.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Produtos cadastrados:");
            for (Produto produto: calcados) {
                System.out.println("Nome: " + produto.getNome() + ", Valor: " + produto.getValor() + ", Estoque: " + produto.getEstoque());
            }
        }
    }
}
