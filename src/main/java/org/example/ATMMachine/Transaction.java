package org.example.ATMMachine;

public interface Transaction {
    TransactionType getType();

    boolean validateTransaction();

    void executeTransaction();

}
