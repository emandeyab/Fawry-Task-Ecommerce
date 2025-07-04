package com.fawry.ecommerce;

import com.fawry.ecommerce.model.*;
import com.fawry.ecommerce.products.*;
import com.fawry.ecommerce.service.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("Valid case with shippable and non-shippable products:");
        try {
            ShippableExpirableProduct cheese = new ShippableExpirableProduct(
                    "Cheese", 100, 15, 0.2, LocalDate.now().plusDays(60));
            ShippableExpirableProduct biscuits = new ShippableExpirableProduct(
                    "Biscuits", 150, 10, 0.7, LocalDate.now().plusDays(365));
            ShippableProduct tv = new ShippableProduct("TV", 1000, 5, 7);
            Product scratchCard = new Product("Scratch Card", 50, 10);
            Customer customer = new Customer("Eman", 2000, "Menoufia", "01012345678");
            Cart cart = new Cart();
            cart.add(cheese, 2);
            cart.add(biscuits, 1);
            cart.add(tv, 1);
            cart.add(scratchCard, 1);
            ShippingService shippingService = new ShippingService();
            CheckoutProcess checkoutProcess = new CheckoutProcess(shippingService);
            checkoutProcess.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nValid case with only non-shippable product:");
        try {
            Product scratchCard = new Product("Scratch Card", 50, 10);
            Customer customer = new Customer("Eman", 2000, "Menoufia", "01012345678");
            Cart cart = new Cart();
            cart.add(scratchCard, 2);
            ShippingService shippingService = new ShippingService();
            CheckoutProcess checkoutProcess = new CheckoutProcess(shippingService);
            checkoutProcess.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nInvalid case (quantity exceeds stock):");
        try {
            ShippableExpirableProduct cheese = new ShippableExpirableProduct(
                    "Cheese", 100, 5, 0.2, LocalDate.now().plusDays(60));
            Customer customer = new Customer("Eman", 2000, "Menoufia", "01012345678");
            Cart cart = new Cart();
            cart.add(cheese, 6);
            ShippingService shippingService = new ShippingService();
            CheckoutProcess checkoutProcess = new CheckoutProcess(shippingService);
            checkoutProcess.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nInvalid case (empty cart):");
        try {
            Customer customer = new Customer("Eman", 2000, "Menoufia", "01012345678");
            Cart cart = new Cart();
            ShippingService shippingService = new ShippingService();
            CheckoutProcess checkoutProcess = new CheckoutProcess(shippingService);
            checkoutProcess.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nInvalid case (insufficient balance):");
        try {
            ShippableExpirableProduct cheese = new ShippableExpirableProduct(
                    "Cheese", 1000, 10, 0.2, LocalDate.now().plusDays(60));
            ShippableProduct tv = new ShippableProduct("TV", 3000, 5, 7);
            Customer customer = new Customer("Eman", 500, "Menoufia", "01012345678");
            Cart cart = new Cart();
            cart.add(cheese, 1);
            cart.add(tv, 1);
            ShippingService shippingService = new ShippingService();
            CheckoutProcess checkoutProcess = new CheckoutProcess(shippingService);
            checkoutProcess.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nInvalid case (expired product):");
        try {
            ShippableExpirableProduct cheese = new ShippableExpirableProduct(
                    "Cheese", 100, 10, 0.2, LocalDate.now().minusDays(1));
            Customer customer = new Customer("Eman", 2000, "Menoufia", "01012345678");
            Cart cart = new Cart();
            cart.add(cheese, 1);
            ShippingService shippingService = new ShippingService();
            CheckoutProcess checkoutProcess = new CheckoutProcess(shippingService);
            checkoutProcess.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
