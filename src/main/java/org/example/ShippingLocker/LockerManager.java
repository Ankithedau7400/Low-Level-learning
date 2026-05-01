package org.example.ShippingLocker;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LockerManager {
    // The site being managed
    private final Site site;
    // Service for sending notifications
//    private final NotificationInterface notificationService;
    // Map of account IDs to account objects
    private final Map<String, Account> accounts;
    // Map of access codes to lockers
    private final Map<String, Locker> accessCodeMap = new HashMap<>();

    public LockerManager(
            Site site, Map<String, Account> accounts) {
        this.site = site;
        this.accounts = accounts;
    }

    // Assigns a package to an available locker
    public Locker assignPackage(ShippingPackage pkg, Date date) {
        Locker locker = site.placePackage(pkg, date);
        if (locker != null) {
            accessCodeMap.put(locker.getAccessCode(), locker);
//            notificationService.sendNotification(
//                    "Package assigned to locker" + locker.getAccessCode(), pkg.getUser());
        }
        return locker;
    }
    // Processes package pickup using an access code
    public Locker pickUpPackage(String accessCode) {
        Locker locker = accessCodeMap.get(accessCode);
        if (locker != null && locker.checkAccessCode(accessCode)) {
            try {
                BigDecimal charge = locker.calculateStorageCharges();
                ShippingPackage pkg = locker.getPackage();
                locker.releaseLocker();
                pkg.getUser().addUsageCharge(charge);
                pkg.updateShippingStatus(ShippingStatus.RETRIEVED);
                return locker;
            } catch (Exception e) {
                locker.releaseLocker();
                return locker;
            }
        }
        return null;
    }
}
