package com.fawry.ecommerce.service;

import com.fawry.ecommerce.model.Cart;
import com.fawry.ecommerce.model.Customer;
import com.fawry.ecommerce.model.Product;
import com.fawry.ecommerce.interfaces.Expiration;
import com.fawry.ecommerce.interfaces.Shipping;

import java.util.Map;

public class CheckoutProcess {
    private ShippingService shippingService;

    public CheckoutProcess(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void checkout(Customer customer, Cart cart) throws IllegalStateException {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty.");
        }
        double subtotal = cart.calculateSubtotal();
        Map<Shipping, Integer> shippableItems = cart.getShippableItems();
        double shippingFee = shippingService.calculateShippingFee(shippableItems);
        double totalAmount = subtotal + shippingFee;

        if (customer.getBalance() < totalAmount) {
            throw new IllegalStateException("Insufficient balance. Your balance isn’t enough to complete this purchase");
        }

        if (!shippableItems.isEmpty()) {
            shippingService.processShipment(shippableItems);
        }

        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(quantity + "x " + product.getName() + "\t" + (product.getPrice() * quantity));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal\t" + subtotal);
        System.out.println("Shipping\t" + shippingFee);
        System.out.println("Amount\t\t" + totalAmount);

    }
}