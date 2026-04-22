package org.example.VendingMaching;

import java.math.BigDecimal;

public class Transaction {
    private Rack rack;
    private  Product product;
    private BigDecimal totalAmount;

    public Transaction() {

        this.totalAmount = BigDecimal.ZERO;
    }
    void setProduct(Product product){
        this.product = product;
    }
    void setRack(Rack rack){
        this.rack = rack;
    }
    void setTotalAmount(BigDecimal totalAmount){
        this.totalAmount = totalAmount;
    }

    Product getProduct(){
        return product;
    }
    Rack getRack(){
        return rack;
    }
    BigDecimal getTotalAmount(){
        return totalAmount;
    }



}
