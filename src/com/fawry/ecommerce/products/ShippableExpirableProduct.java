package com.fawry.ecommerce.products;

import com.fawry.ecommerce.interfaces.Expiration;
import com.fawry.ecommerce.interfaces.Shipping;
import com.fawry.ecommerce.model.Product;

import java.time.LocalDate;

public class ShippableExpirableProduct extends Product implements Expiration, Shipping {
    private double weight;
    private LocalDate expiryDate;

    public ShippableExpirableProduct(String name, double price, int quantity, double weight, LocalDate expiryDate){
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now()) || expiryDate.isEqual(LocalDate.now());
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
