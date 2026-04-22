package org.example.VendingMaching;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    // Maps rack codes to their corresponding rack objects
    private Map<String, Rack> racks;

    public InventoryManager() {
        racks = new HashMap<>();
    }

    // Retrieves the product from a specific rack using its code
    public Product getProductFromRack(String rackCode) {
        Rack rack = racks.get(rackCode);
        if (rack != null) {
            return rack.getProduct();
        }
        return null;
    }

    // Dispenses a product from the specified rack and decrements its count
    public void dispenseProductFromRack(Rack rack){
        if(rack.getProductCount()>0){
            rack.setProductCount(rack.getProductCount() - 1);
        }
    }

    public void updateRack(Map<String, Rack> racks) {
        this.racks = racks;
    }

    public Rack getRack(String rackCode){
        return racks.get(rackCode);
    }
    public Product getProductInRack(String rackCode){
        return racks.get(rackCode).getProduct();
    }
}
