package payments.interfaces;

import payments.domain.PaymentContext;

public interface PaymentStrategy {
    public boolean credit(PaymentContext context);
}
