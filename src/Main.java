import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        Produto calca = new Vestuario(43.1f, "calça jeans preta", 21);
        Produto camisa = new Vestuario(79.99f, "camisa polo azul", 80);
        Produto regata = new Vestuario(29.99f, "regata curta preta", 21);
        Produto vestido = new Vestuario(90.0f, "vestido floral", 70);
        Produto legging = new Vestuario(32.99f, "legging marrom", 60);
        Produto legging1 = new Vestuario(32.99f, "legging azul escura", 60);
        Produto shorts = new Vestuario(59.99f, "shorts verde militar", 77);
        Produto jaqueta = new Vestuario(80.0f, "jaqueta jeans azul", 20);
        Produto moletom = new Vestuario(70.0f, "moletom cinza", 89);
        Produto saia = new Vestuario(43.1f, "saia", 21);
        Produto camiseta = new Vestuario(29.9f, "camiseta preta básica", 30);
        Produto camiseta1 = new Vestuario(29.9f, "camiseta branca básica", 30);
        Produto camiseta2 = new Vestuario(29.9f, "camiseta cinza básica", 30);

        Produto bota = new Calcado(199.f, "bota verniz preta", 18);
        Produto allStar = new Calcado(29.9f, "allStar branco", 18);
        Produto sandalia = new Calcado(43.1f, "sandália azul bebê", 18);
        Produto chinelo = new Calcado(29.9f, "chinelo tema Brasil", 18);
        Produto vans = new Calcado(399.9f, "Vans Old Skool", 21);
        Produto veja = new Calcado(799.f, "Veja Campo", 18);
        Produto salto= new Calcado(199.f, "Salto preto", 21);

        ArrayList<Produto> vestuario = new ArrayList<>();
        ArrayList<Produto> calcados = new ArrayList<>();
        Cliente cliente = new ClienteComum("Leticia Aiko", "letaaiko@gmail.com",999997654, "solraiar", 23.9f);

        vestuario.add(calca);
        vestuario.add(camisa);
        vestuario.add(regata);
        vestuario.add(vestido);
        vestuario.add(legging);
        vestuario.add(legging1);
        vestuario.add(shorts);
        vestuario.add(jaqueta);
        vestuario.add(moletom);
        vestuario.add(saia);
        vestuario.add(camiseta);
        vestuario.add(camiseta1);
        vestuario.add(camiseta2);

        calcados.add(bota);
        calcados.add(allStar);
        calcados.add(sandalia);
        calcados.add(chinelo);
        calcados.add(vans);
        calcados.add(veja);
        calcados.add(salto);

        //System.out.println(calcados);
        cliente.visualizarProduto(calca);
        Carrinho carrinho1 = new Carrinho();

        cliente.setNome("Lucia");



    }
}