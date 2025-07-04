package com.fawry.ecommerce.products;

import com.fawry.ecommerce.interfaces.Expiration;
import com.fawry.ecommerce.model.Product;

import java.time.LocalDate;

public class ExpirableProduct extends Product implements Expiration {
    private LocalDate expiryDate;

    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate){
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public LocalDate getExpiryDate(){
        return expiryDate;
    }
    @Override
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
