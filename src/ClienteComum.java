public class ClienteComum extends Cliente {
    public ClienteComum(String nome, String email, int celular, String senha) {
        super(nome, email, celular, senha);
    }

    @Override
    public double comprar() {
        return 0;
    }
}
