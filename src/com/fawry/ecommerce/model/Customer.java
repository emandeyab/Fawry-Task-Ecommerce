package com.fawry.ecommerce.model;

public class Customer {
    private String name;
    private double balance;
    private String address;
    private String phoneNumber;

    public Customer(String name, double balance, String address, String phoneNumber){
        this.name = name;
        this.balance = balance;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public String getName(){
        return name;
    }
    public double getBalance(){
        return balance;
    }
    public String getAddress(){
        return address;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
}
