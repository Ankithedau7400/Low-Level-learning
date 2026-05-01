package org.example.ATMMachine;

import java.math.BigDecimal;

public class DepositAmountEntryState extends ATMState {
    @Override
    public void processCardEjection(ATMMachine atmMachine) {
        atmMachine.getDisplay().showMessage("Transaction cancelled. Card ejected.");
        atmMachine.transitionToState(new IdleState());
    }

    @Override
    public void processAmountEntry(ATMMachine atmMachine, BigDecimal amount) {
        atmMachine.getDepositBox().collectDeposit(amount);
        atmMachine.getDisplay().showMessage("Deposit collected. Please confirm.");
        atmMachine.transitionToState(new DepositCollectionState());
    }
}
