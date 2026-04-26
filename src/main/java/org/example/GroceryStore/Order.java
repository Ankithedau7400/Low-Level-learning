package org.example.GroceryStore;

import java.math.BigDecimal;
import java.util.*;

public class Order {
    private final String orderId;
    private final List<OrderItem> items = new ArrayList<>();
    // Map of items to their applied discounts
    private final Map<OrderItem, DiscountCampaign> appliedDiscounts = new HashMap<>();

    private BigDecimal paymentAmount = BigDecimal.ZERO;

    // Creates a new order with a random UUID
    public Order() {
        this.orderId = String.valueOf(UUID.randomUUID());
    }

    public void addItem(OrderItem item){
        items.add(item);
    }
    public BigDecimal calculateSubtotal(){
        return items.stream().map(OrderItem::calculatePrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Calculates the total price including all applied discounts
    public BigDecimal calculateTotal() {

        return items.stream().map(item -> {
            DiscountCampaign discount = appliedDiscounts.get(item);
             return discount != null
                     ? item.calculatePriceWithDiscount(discount)
                     : item.calculatePrice();
        }).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    // Applies a discount to a specific item in the order
    public void applyDiscount(OrderItem item, DiscountCampaign discount) {
        appliedDiscounts.put(item, discount);
    }
    // Calculates the change to be returned to the customer
    public BigDecimal calculateChange() {
        return paymentAmount.subtract(calculateTotal());
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    public Map<OrderItem, DiscountCampaign> getAppliedDiscounts() {
        return appliedDiscounts;
    }
}
