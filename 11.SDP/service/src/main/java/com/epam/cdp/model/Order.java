package com.epam.cdp.model;

/**
 * Created by dima on 15.2.15.
 */
public class Order {
    private static Long orderCounter = 0L;

    Long orderId;

    public Order() {
        orderCounter++;
        orderId = orderCounter;
    }
}
