import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import billCounter.domain.BillCounter;
import payments.domain.CardDetails;
import payments.domain.CardPayments;
import payments.domain.CashPayments;
import payments.domain.PaymentContext;
import payments.domain.PaymentProcessor;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Bill Counter, " + printBillCounterBalance());
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        CardDetails cardDetails = new CardDetails("x", LocalDate.now().plusYears(1));
        Map<String, Object> additionalParameters = new HashMap<>();
        additionalParameters.put("cardDetails", cardDetails);
        PaymentContext cardPaymentContext = new PaymentContext(1500, additionalParameters);
        paymentProcessor.setPaymentStrategy(new CardPayments());
        initiatePayment(paymentProcessor, cardPaymentContext);

        PaymentContext cashPaymentContext = new PaymentContext(2000, null);
        paymentProcessor.setPaymentStrategy(new CashPayments());
        initiatePayment(paymentProcessor, cashPaymentContext);
    }

    public static void initiatePayment(PaymentProcessor paymentProcessor, PaymentContext paymentContext) {
        System.out.println("Initiating payment ...");
        System.out.println("Before payment, " + printBillCounterBalance());
        System.out.println(printPaymentSummary(paymentProcessor.creditPayment(paymentContext)));
        System.out.println("After payment, " + printBillCounterBalance());
    }

    public static String printBillCounterBalance() {
        BillCounter billCounter = BillCounter.getBillCounter();
        return "Bill Counter Balance : " + billCounter.getTotalBalance();
    }

    public static String printPaymentSummary(boolean result) {
        if(result) {
            return "Payment Successful!\n" + printBillCounterBalance();
        } else {
            return "Payment failed!\n" + printBillCounterBalance();
        }
    }
}
