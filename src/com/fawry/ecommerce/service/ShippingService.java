package com.fawry.ecommerce.service;

import com.fawry.ecommerce.interfaces.Shipping;

import java.util.Map;

public class ShippingService {
    private static double Shipping_Rate_Per_KG = 10.0;
    public double calculateShippingFee(Map<Shipping, Integer> items){
        double totalWeight = 0.0;
        for (Map.Entry<Shipping, Integer> entry : items.entrySet()){
            totalWeight += entry.getKey().getWeight() * entry.getValue();
        }
        return totalWeight * Shipping_Rate_Per_KG;
    }
    public void processShipment(Map<Shipping, Integer> items) {
        double totalWeight = 0;
        System.out.println("** Shipment notice **");
        for (Map.Entry<Shipping, Integer> entry : items.entrySet()) {
            System.out.println(entry.getValue() + "x " + entry.getKey().getName() + "\t" + (entry.getKey().getWeight() * entry.getValue() * 1000) + "g");
            totalWeight += entry.getKey().getWeight() * entry.getValue();
        }
        System.out.println("Total package weight " + totalWeight + "kg");
    }
}
