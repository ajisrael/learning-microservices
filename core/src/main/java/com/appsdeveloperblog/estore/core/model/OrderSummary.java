package com.appsdeveloperblog.estore.core.model;

import lombok.Data;

@Data
public class OrderSummary {

    private final String orderId;
    private final OrderStatus orderStatus;
    private final String message;

    public OrderSummary(String orderId, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.message = "";
    }

    public OrderSummary(String orderId, OrderStatus orderStatus, String message) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.message = message;
    }
}
