import java.util.ArrayList;

public abstract class Cliente {
    private String nome;
    private String email;
    private int celular;
    private String senha;
    private float saldo;
    protected Carrinho carrinho;

    public Cliente(String nome, String email, int celular, String senha,float saldo,Carrinho carrinho ) {
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.senha = senha;
        this.saldo = saldo;
        this.carrinho = carrinho;

    }
    public void criarPedido(String endEntrega, int prazoEntrega) {
        int qtdeItens = carrinho.getItens().size();
        ArrayList<Produto> produtos = carrinho.getItens();
        double valorTotal = carrinho.calcularValorTotal();
        boolean entregue = false;

        Pedido pedido = new Pedido(this.nome, qtdeItens, produtos, valorTotal, prazoEntrega, entregue, endEntrega);
        Pedido.escreverPedidoNoArquivo(pedido);
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

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public abstract double comprar(Carrinho carrinho);



    public ArrayList<Produto> criarLista(){
        ArrayList<Produto> lista = new ArrayList<>();
        return lista;
    }

    public void cadastrarEndereco(){

    }

    public void visualizarProduto(Produto produto){
        System.out.println("O produto " + produto.getNome() );
        System.out.println("Tem o valor de " + produto.getValor());
        System.out.println("Nós possuimos " + produto.getEstoque() + " em estoque");
    }

    public void cancelarAssinatura(){

    }

    public void configurarAssinatura(){

    }




}
