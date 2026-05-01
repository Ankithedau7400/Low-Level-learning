package org.example.ATMMachine;

import java.math.BigDecimal;

public class DepositBoxImpl implements DepositBox {
    @Override
    public void collectDeposit(BigDecimal amount) {
        // Stub: Logic to physically collect and verify deposit (e.g., count bills)
        System.out.println("Collected deposit of " + amount);
    }
}
