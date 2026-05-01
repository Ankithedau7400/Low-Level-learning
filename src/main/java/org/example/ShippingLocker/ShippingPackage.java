package org.example.ShippingLocker;

public interface ShippingPackage {


    void updateShippingStatus(ShippingStatus shippingStatus);

    LockerSize getLockerSize();

    ShippingStatus getStatus();

    Account user = null;
}
