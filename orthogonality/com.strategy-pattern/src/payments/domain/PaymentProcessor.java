package payments.domain;

import payments.interfaces.PaymentStrategy;

/* It's a class that encapsulates and implements polymorphism
   of the strategy interface */
public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public boolean creditPayment(PaymentContext context) {
        if(paymentStrategy == null) return false;
        
        return paymentStrategy.credit(context);
    }
}
