package com.fawry.ecommerce.products;

import com.fawry.ecommerce.interfaces.Shipping;
import com.fawry.ecommerce.model.Product;

public class ShippableProduct extends Product implements Shipping {
    private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight){
        super(name, price, quantity);
        this.weight = weight;
    }
    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
}
