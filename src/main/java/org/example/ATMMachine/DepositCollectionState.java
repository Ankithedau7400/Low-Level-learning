package org.example.ATMMachine;

import java.math.BigDecimal;

public class DepositCollectionState extends ATMState {
    @Override
    public void processDepositCollection(ATMMachine atmMachine, BigDecimal amount) {
        String cardNumber = atmMachine.getCardProcessor().getCardNumber();
        Account account = atmMachine.getBankInterface().getAccountByCard(cardNumber);
        account.updateBalanceWithTransaction(amount);
        atmMachine.getDisplay().showMessage("Deposit successful. Select another transaction or eject card.");
        atmMachine.transitionToState(new TransactionSelectionState());
    }

    @Override
    public void processCardEjection(ATMMachine atmMachine) {
        atmMachine.getDisplay().showMessage("Card ejected.");
        atmMachine.transitionToState(new IdleState());
    }
}
