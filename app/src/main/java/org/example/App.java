package org.example;

import java.util.List;

// ===== Supporting Classes =====

class Customer {
    private String name;
    private boolean isMember;

    public Customer(String name, boolean isMember) {
        this.name = name;
        this.isMember = isMember;
    }

    public String getName() { return name; }
    public boolean isMember() { return isMember; }
}

class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}

class Order {
    private Customer customer;
    private List<Item> items;

    public Order(Customer customer, List<Item> items) {
        this.customer = customer;
        this.items = items;
    }

    public Customer getCustomer() { return customer; }
    public List<Item> getItems() { return items; }
}

// ===== Exercise 1: Before Refactoring (Rename) =====

class Calculator {
    public double calculateSumProductRatio(double num1, double num2) {
        double sum = num1 + num2;
        double product = num1 * num2;
        return sum / product;
    }

    public void printResult(double res) {
        System.out.println("Result: " + res);
    }
}

// ===== Exercise 2: Before Refactoring (Extract Method) =====

class OrderProcessor {
    public double printOrderSummary(Order order) {
        double totalPrice = calculateTotalPrice(order);
        if (order.getCustomer().isMember()) {
            totalPrice *= 0.9;
        }
        System.out.println("Order Summary:");
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Items:");
        for (Item item : order.getItems()) {
            System.out.println("  - " + item.getName() + ": " + item.getQuantity() + " x $" + item.getPrice());
        }
        System.out.printf("Total Price: $%.2f%n", totalPrice);
        return totalPrice;
    }

    private double calculateTotalPrice(Order order) {
        double totalPrice = 0;
        for (Item item : order.getItems()) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        return totalPrice;
    }
}

// ===== Main =====

public class App {
    public static void main(String[] args) {
        System.out.println("Refactoring Lab!");
    }
}