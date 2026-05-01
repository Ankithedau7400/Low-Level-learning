package org.example.ATMMachine;

import java.math.BigDecimal;
import java.security.MessageDigest;

public class Account {
    private BigDecimal balance;
    private final String accountNumber;
    private final String cardNumber;
    private final byte[] cardPinHash;
    private final AccountType accountType;

    // Creates a new account with initial zero balance and hashed PIN
    public Account(
            final String accountNumber,
            final AccountType type,
            final String cardNumber,
            final String pin) {
        this.accountNumber = accountNumber;
        this.accountType = type;
        this.cardNumber = cardNumber;
        this.cardPinHash = calculateMd5(pin); // PIN is hashed for security
        this.balance = BigDecimal.ZERO;
    }

    private byte[] calculateMd5(String pin) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return md.digest(pin.getBytes());
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not available", e);
        }
    }

    public void updateBalanceWithTransaction(final BigDecimal balanceChange) {
        this.balance = this.balance.add(balanceChange);
    }

    public boolean validatePin(String pinNumber) {
        byte[] entryPinHash = calculateMd5(pinNumber);
        return MessageDigest.isEqual(this.cardPinHash, entryPinHash);
    }

    public BigDecimal getBalance(){
        return this.balance;
    }
}
