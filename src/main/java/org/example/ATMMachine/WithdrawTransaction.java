package org.example.ATMMachine;

import java.math.BigDecimal;

public class WithdrawTransaction implements Transaction {
    Account account;
    BigDecimal amount;

    // Returns the transaction type as WITHDRAW
    @Override
    public TransactionType getType() {
        return TransactionType.WITHDRAW;
    }

    @Override
    public boolean validateTransaction() {
        assert account != null;
        return account.getBalance().compareTo(amount) >= 0;
    }

    public WithdrawTransaction(Account account, BigDecimal amount) throws InvalidTransactionException {
        this.account = account;
        this.amount = amount;
        if (!validateTransaction()) {
            throw new InvalidTransactionException("Cannot complete withdrawal: Insufficient funds in account");
        }
    }

    @Override
    public void executeTransaction() {
        account.updateBalanceWithTransaction(amount.negate());
    }


}
