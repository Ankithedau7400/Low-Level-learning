package org.example.ATMMachine;

import java.math.BigDecimal;

public interface DepositBox {
    void collectDeposit(BigDecimal amount);
}
