
package Pagamento;

import java.util.Scanner;

public class CreditCardPayment implements PaymentStrategy {
	private String cardNumber;
    private String cardHolderName;
    
    public CreditCardPayment() {
    	Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número do cartão de crédito: ");
        this.cardNumber = scanner.nextLine();

        System.out.print("Digite o nome do titular do cartão: ");
        this.cardHolderName = scanner.nextLine();

    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
        System.out.println("Cartao: " + cardNumber);
        System.out.println("Titular: " + cardHolderName);
    }
}
