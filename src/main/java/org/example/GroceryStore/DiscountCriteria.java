package org.example.GroceryStore;

public interface DiscountCriteria {
    // Determines if the discount applies to the given item
    boolean isApplicable(Item item);
}
