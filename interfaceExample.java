public interface PaymentGateway{
    void initiatePayment(double amount);
}

public class StripePayment implements PaymentGateway{
  public void initiatePayment(double amount){
    System.out.println("PAYMENT FOR STRIPE : "+amount);
  }
}
public class RazorPayment implements PaymentGateway{
  public void initiatePayment(double amount){
    System.out.println("PAYMENT FOR razorpay : "+amount);
  }
}
public class CheckoutService{
    private PaymentGateway paymentGateway;
    public CheckoutService(PaymentGateway paymentGateway){
        this.paymentGateway=paymentGateway;
    }
    public void setPaymentGateway(PaymentGateway paymentGateway){
        this.paymentGateway=paymentGateway;
    }
    public void checkout(double amount){
        paymentGateway.initiatePayment(amount);
    }
}
public class Main{
    public static void main(String args[]){
        PaymentGateway stripePayment = new PaymentGateway();
        CheckoutService checkoutService = new CheckoutService(stripePayment);
        checkoutService.checkout(23.45);

        PaymentGateway razorPayment = new PaymentGateway();
        checkoutService.setPaymentGateway(razorPayment);
        checkoutService.checkout(24.45);

    }
}