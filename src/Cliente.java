import java.util.ArrayList;

public abstract class Cliente {
    private String nome;
    private String email;
    private int celular;
    private String senha;

    private float saldo;

    public Cliente(String nome, String email, int celular, String senha, float saldo) {
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.senha = senha;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public abstract double comprar();

    public ArrayList criarPedido(){
        ArrayList<Produto> pedido = new ArrayList<>();
        return pedido;
    }

    public ArrayList<Produto> criarLista(){
        ArrayList<Produto> lista = new ArrayList<>();
        return lista;
    }

    public void cadastrarEndereco(){

    }

    public void vizualizarProduto(){

    }

    public void cancelarAssinatura(){

    }

    public void configurarAssinatura(){

    }
}
