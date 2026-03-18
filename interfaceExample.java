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