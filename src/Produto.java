
import java.util.ArrayList;


public class Produto  {
    private float valor;
    private String nome;
    private int estoque;

    public Produto(float valor, String nome, int estoque) {
        this.valor = valor;
        this.nome = nome;
        this.estoque = estoque;
    }


    public double getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }


}


