package org.example.GroceryStore;

import java.math.BigDecimal;
import java.util.List;

public class Checkout {

    private  Order currentOrder;
    // List of active discount campaigns
    private final List<DiscountCampaign> activeDiscounts;

    public Checkout(List<DiscountCampaign> activeDiscounts) {
        this.activeDiscounts = activeDiscounts;
        startNewOrder();
    }

    public void startNewOrder() {
        this.currentOrder = new Order();
    }
    public BigDecimal processPayment(BigDecimal paymentAmount){
        currentOrder.setPaymentAmount(paymentAmount);
        return currentOrder.calculateChange();
    }
//    public Receipt getReceipt() {
//        return new Receipt(currentOrder);
//    }
    public void addItemToOrder(Item item, int quantity) {
            OrderItem orderItem = new OrderItem(item, quantity);
            currentOrder.addItem(orderItem);
            // Check for applicable discounts and apply them to the order item
            for (DiscountCampaign discount : activeDiscounts) {
                if (discount.isApplicable(item)) {
                    // if there are multiple newDiscount that apply to item, apply the higher one
                    if (currentOrder.getAppliedDiscounts().containsKey(orderItem)){
                        DiscountCampaign existingDiscount =
                                currentOrder.getAppliedDiscounts().get(orderItem);
                        if (orderItem
                                .calculatePriceWithDiscount(discount)
                                .compareTo(
                                        orderItem.calculatePriceWithDiscount(existingDiscount))
                                > 0) {
                            currentOrder.applyDiscount(orderItem, discount);
                        }
                    }else{
                            currentOrder.applyDiscount(orderItem, discount);

                    }

                }
            }
    }

    // Calculates the total amount for the current order
    public BigDecimal getOrderTotal() {
        return currentOrder.calculateTotal();
    }
}
