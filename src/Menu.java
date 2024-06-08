import java.util.Scanner;

public class Menu {
    public Menu(){

    }

    public void printMenu(GerenciadorCliente gerenciadorCliente){
        System.out.println("************* MENU *************");
        System.out.println("1 - CADASTRE-SE");
        System.out.println("2 - FAÇA LOGIN");
        System.out.println("3 - SAIR");
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Escolha a opção: ");
        int opcao = scanner1.nextInt();
        if (opcao == 1){
            System.out.println("");
            gerenciadorCliente.cadastrarCliente();

        }
        if (opcao == 2){
            System.out.println("");

            Scanner scanner2 = new Scanner(System.in);
            System.out.print("Digite seu e-mail: ");
            String email = scanner2.nextLine();

            Scanner scanner3 = new Scanner(System.in);
            System.out.print("Digite sua senha: ");
            String senha = scanner3.nextLine();

            gerenciadorCliente.logar(email, senha);
        }

        if (opcao == 3){

        }

    }
}
