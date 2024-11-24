package payments.domain;

import java.time.LocalDate;

public class CardDetails {
    private String cardNubmer;
    private LocalDate expiryDate;
    
    public CardDetails(String cardNumber, LocalDate expiryDate) {
        this.cardNubmer = cardNumber;
        this.expiryDate = expiryDate;
    }

    public boolean isValidCard() {
        return isValidCardNumber() && isNotExpired();
    }

    public boolean isValidCardNumber() {
        return cardNubmer.length() > 1;
    }

    public boolean isNotExpired() {
        return LocalDate.now().isBefore(expiryDate);
    }
}
