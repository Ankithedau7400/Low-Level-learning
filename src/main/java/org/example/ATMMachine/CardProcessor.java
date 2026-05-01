package org.example.ATMMachine;

public interface CardProcessor {
    void insertCard(String cardNumber);
    String getCardNumber();
    void ejectCard();
}
