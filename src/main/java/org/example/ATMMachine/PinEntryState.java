package org.example.ATMMachine;

public class PinEntryState extends ATMState {
    @Override
    public void processPinEntry(ATMMachine atmMachine, String pin) {
        String cardNumber = atmMachine.getCardProcessor().getCardNumber();
        if (atmMachine.getBankInterface().checkPin(cardNumber, pin)) {
            atmMachine.getDisplay().showMessage("PIN accepted. Select transaction: 1. Withdraw 2. Deposit");
            atmMachine.transitionToState(new TransactionSelectionState());
        } else {
            atmMachine.getDisplay().showMessage("Invalid PIN. Please try again.");
            // Remain in PinEntryState for retry
        }
    }

    @Override
    public void processCardEjection(ATMMachine atmMachine) {
        atmMachine.getDisplay().showMessage("Card ejected. Transaction cancelled.");
        atmMachine.transitionToState(new IdleState());
    }
}
