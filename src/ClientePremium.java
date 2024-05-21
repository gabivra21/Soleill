public class ClientePremium extends Cliente {
    public ClientePremium(String nome, String email, int celular, String senha) {
        super(nome, email, celular, senha);
    }

    @Override
    public double comprar() {
        return 0;
    }
}
