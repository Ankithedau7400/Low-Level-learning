package org.example.ATMMachine;

public class CardProcessorImpl implements CardProcessor {
    private String cardNumber;

    @Override
    public void insertCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public void ejectCard() {
        this.cardNumber = null;
    }
}
