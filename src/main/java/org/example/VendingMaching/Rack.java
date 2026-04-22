package org.example.VendingMaching;

public class Rack {
    private final String rackCode;
    private final Product product;
    private int count;

    public Rack(final String rackCode, final Product product, final int count) {
        this.rackCode = rackCode;
        this.product = product;
        this.count = count;
    }

    public Product getProduct(){
        return product;
    }
    public int getProductCount(){
        return count;
    }
    public void setProductCount(int count){
        this.count = count;
    }

}
