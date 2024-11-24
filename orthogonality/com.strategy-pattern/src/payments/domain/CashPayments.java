package payments.domain;

import billCounter.domain.BillCounter;
import payments.interfaces.PaymentStrategy;

public class CashPayments implements PaymentStrategy{
    @Override
    public boolean credit(PaymentContext paymentContext){
        return BillCounter.add(paymentContext.getAmount());
    }
}
