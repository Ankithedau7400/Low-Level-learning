package org.example.ATMMachine;

public class TransactionSelectionState extends ATMState {
    @Override
    public void processWithdrawalRequest(ATMMachine atmMachine) {
        atmMachine.getDisplay().showMessage("Enter amount to withdraw.");
        atmMachine.transitionToState(new WithdrawAmountEntryState());
    }

    @Override
    public void processDepositRequest(ATMMachine atmMachine) {
        atmMachine.getDisplay().showMessage("Enter amount to deposit.");
        atmMachine.transitionToState(new DepositAmountEntryState());
    }

    @Override
    public void processCardEjection(ATMMachine atmMachine) {
        atmMachine.getDisplay().showMessage("Card ejected. Transaction cancelled.");
        atmMachine.transitionToState(new IdleState());
    }
}
