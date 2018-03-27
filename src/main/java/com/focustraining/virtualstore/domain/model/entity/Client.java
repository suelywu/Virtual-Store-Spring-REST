package com.focustraining.virtualstore.domain.model.entity;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Component
public class Client {

    private final int id;
    private final String name;
    private List<Order> orders;

    public Client(final int id, final String name) {
        this.id = id;
        this.name = name;
        this.orders = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Integer) {
            return this.id == (int) obj;
        }
        return super.equals(obj);
    }
}
