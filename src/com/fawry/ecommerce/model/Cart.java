package com.fawry.ecommerce.model;

import com.fawry.ecommerce.interfaces.Expiration;
import com.fawry.ecommerce.interfaces.Shipping;
import com.fawry.ecommerce.products.ExpirableProduct;
import com.fawry.ecommerce.products.ShippableExpirableProduct;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items;
    public Cart(){
        this.items = new HashMap<>();
    }
    public void add(Product product, int quantity) throws IllegalArgumentException {
        if(quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        if(product.getQuantity() < quantity) {
            throw new IllegalArgumentException("The quantity you’re trying to buy exceeds what's available.");
        }
        if ((product instanceof ExpirableProduct && ((ExpirableProduct) product).isExpired()) || (product instanceof ShippableExpirableProduct && ((ShippableExpirableProduct) product).isExpired())) {
            throw new IllegalArgumentException("Product is expired");
        }
        items.put(product, quantity);
    }
    public Map<Product, Integer> getItems(){
        return items;
    }
    public boolean isEmpty(){
        return items.isEmpty();
    }

    public Map<Shipping, Integer>getShippableItems(){
        Map<Shipping, Integer> shippableItems = new HashMap<>();
        for (Map.Entry<Product, Integer> entry : items.entrySet()){
            if(entry.getKey() instanceof Shipping){
                shippableItems.put((Shipping) entry.getKey(), entry.getValue());
            }
        }
        return shippableItems;
    }
    public double calculateSubtotal() {
        double subtotal = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            subtotal += entry.getKey().getPrice() * entry.getValue();
        }
        return subtotal;
    }
}
