package org.example.GroceryStore;

import java.math.BigDecimal;

public interface DiscountCalculationStrategy {
    public BigDecimal calculateDiscountedPrice(BigDecimal originalPrice);

}
