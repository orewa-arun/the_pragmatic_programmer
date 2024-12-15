package payments.domain;

import java.util.Map;

import billCounter.domain.BillCounter;
import payments.interfaces.PaymentStrategy;

public class CardPayments implements PaymentStrategy{
    @Override
    public boolean credit(PaymentContext paymentContext) {
        boolean result = false;

        Map<String, Object> additionalParameters = paymentContext.getAdditionalParametersMap();
        
        if(!additionalParameters.containsKey("cardDetails") || !(additionalParameters.get("cardDetails") instanceof CardDetails)) return result;

        CardDetails cardDetails = (CardDetails) additionalParameters.get("cardDetails"); 

        if(cardDetails.isValidCard()) result = BillCounter.add(paymentContext.getAmount());

        return result;
    }
}
