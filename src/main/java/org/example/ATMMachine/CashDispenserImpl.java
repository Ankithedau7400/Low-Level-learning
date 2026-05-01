package org.example.ATMMachine;

import java.math.BigDecimal;

public class CashDispenserImpl implements CashDispenser {
    @Override
    public void dispenseCash(BigDecimal amount) {
        // Stub: Logic to dispense cash (e.g., count and release bills)
        System.out.println("Dispensed cash of " + amount);
    }
}
