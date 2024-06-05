import java.util.ArrayList;

public abstract class Cliente {
    private String nome;
    private String email;
    private int celular;
    private String senha;
    private float saldo;
    protected Carrinho carrinho;
    private String endereco;
    private boolean assinaturaAtiva;
    private String validadeAssinatura;

    public Cliente(String nome, String email, int celular, String senha,float saldo,Carrinho carrinho, String endereco,boolean assinaturaAtiva,String validadeAssinatura ) {
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.senha = senha;
        this.saldo = saldo;
        this.carrinho = carrinho;
        this.endereco = endereco;
        this.assinaturaAtiva = false;
        this.validadeAssinatura = null;

    }
    public void criarPedido(String endEntrega, int prazoEntrega) {
        int qtdeItens = carrinho.getItens().size();
        ArrayList<Produto> produtos = carrinho.getItens();
        double valorTotal = carrinho.calcularValorTotal();
        boolean entregue = false;

        Pedido pedido = new Pedido(this.nome, qtdeItens, produtos, valorTotal, prazoEntrega, entregue, endEntrega);
        Pedido.escreverPedidoNoArquivo(pedido);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "Email: " + email + "\n" +
                "Celular: " + celular + "\n" +
                "Saldo: " + saldo + "\n" +
                "Endereço: " + endereco + "\n" +
                "Assinatura Ativa: " + (assinaturaAtiva ? "Sim" : "Não") + "\n" +
                "Validade da Assinatura: " + validadeAssinatura + "\n";
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public boolean isAssinaturaAtiva() {
        return assinaturaAtiva;
    }

    public void setAssinaturaAtiva(boolean assinaturaAtiva) {
        this.assinaturaAtiva = assinaturaAtiva;
    }

    public String getValidadeAssinatura() {
        return validadeAssinatura;
    }

    public void setValidadeAssinatura(String validadeAssinatura) {
        this.validadeAssinatura = validadeAssinatura;
    }

    public abstract double comprar(Carrinho carrinho);



    public ArrayList<Produto> criarLista(){
        ArrayList<Produto> lista = new ArrayList<>();
        return lista;
    }

    public void cadastrarEndereco( String endereco){
        this.setEndereco(endereco);
    }

    public void visualizarProduto(Produto produto){
        System.out.println("O produto " + produto.getNome() );
        System.out.println("Tem o valor de " + produto.getValor());
        System.out.println("Nós possuimos " + produto.getEstoque() + " em estoque");
    }

    public void cancelarAssinatura(){
        if (assinaturaAtiva) {
            assinaturaAtiva = false;
            validadeAssinatura = null;
            System.out.println("Assinatura cancelada com sucesso.");
        } else {
            System.out.println("Nenhuma assinatura ativa para cancelar.");
        }
    }





}
