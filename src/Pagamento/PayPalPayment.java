package Pagamento;

import java.util.Scanner;

public class PayPalPayment implements PaymentStrategy {
    private String email;
    
    public PayPalPayment() {
    	Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o email do paypal: ");
        this.email = scanner.nextLine();;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}
