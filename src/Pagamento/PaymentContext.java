package Pagamento;

public class PaymentContext {
	private PaymentStrategy paymentStrategy;
    
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    
    public void payAmount(double amount) {
        paymentStrategy.pay(amount);
    }
}
