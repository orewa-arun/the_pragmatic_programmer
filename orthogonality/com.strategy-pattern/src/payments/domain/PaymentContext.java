package payments.domain;

import java.util.Map;

public class PaymentContext {
    private double amount;
    private Map<String, Object> additionalParameters;

    public PaymentContext(double amount, Map<String, Object> additionalParameters) {
        this.amount = amount;
        this.additionalParameters = additionalParameters;
    }

    public double getAmount() {return amount;}

    public Map<String, Object> getAdditionalParametersMap() {return additionalParameters;}

    public void addAdditionalParameter(String key, Object value) {additionalParameters.put(key, value);}
}
