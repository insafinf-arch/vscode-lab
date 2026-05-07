package org.example;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class AppTest {

    // ===== Calculator Tests =====

    @Test
    void testCalc() {
        Calculator calc = new Calculator();
        // (2+3) / (2*3) = 5/6 = 0.833
        assertEquals(0.833, calc.calculateSumProductRatio(2, 3), 0.01);
    }

    @Test
    void testCalcSymmetry() {
        Calculator calc = new Calculator();
        assertEquals(calc.calculateSumProductRatio(2, 3), calc.calculateSumProductRatio(3, 2), 0.01);
    }

    // ===== OrderProcessor Tests =====

    @Test
    void testPrintOrderSummaryRegular() {
        Customer customer = new Customer("Alice", false);
        List<Item> items = List.of(new Item("Book", 10.0, 2));
        Order order = new Order(customer, items);
        OrderProcessor processor = new OrderProcessor();
        // subtotal = 20, no discount
        assertEquals(20.0, processor.printOrderSummary(order), 0.01);
    }

    @Test
    void testPrintOrderSummaryMember() {
        Customer customer = new Customer("Bob", true);
        List<Item> items = List.of(new Item("Pen", 5.0, 4));
        Order order = new Order(customer, items);
        OrderProcessor processor = new OrderProcessor();
        // subtotal = 20, member discount 10% = 18
        assertEquals(18.0, processor.printOrderSummary(order), 0.01);
    }

    @Test
    void testPrintOrderSummaryMultipleItems() {
        Customer customer = new Customer("Sara", false);
        List<Item> items = List.of(
            new Item("Notebook", 8.0, 3),
            new Item("Pencil", 2.0, 5)
        );
        Order order = new Order(customer, items);
        OrderProcessor processor = new OrderProcessor();
        // subtotal = 24 + 10 = 34
        assertEquals(34.0, processor.printOrderSummary(order), 0.01);
    }
}