package com.focustraining.virtualstore.domain.repository;

import com.focustraining.virtualstore.domain.model.entity.Client;
import com.focustraining.virtualstore.domain.model.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderRepository {

    private List<Order> orders;

    public OrderRepository() {
        orders = new LinkedList<>();
    }

    public List<Order> findAll() {
        return Collections.unmodifiableList(orders);
    }

    public Order findById(int id) {
        if (orders.stream().anyMatch(order -> order.equals(id))) {
            return orders.stream().filter(order -> order.equals(id)).findFirst().get();
        }
        return new Order(0, new Client(0, ""), new LinkedList<>(), null);
    }

    public List<Order> findByClientId(int clientId) {
        return orders.stream().filter(order -> order.getClientId() == clientId).collect(Collectors.toList());
    }

    public boolean existById(int id) {
        return orders.stream().anyMatch(order -> order.equals(id));
    }

    public int getNextIdToUse() {
        return orders.size()+1;
    }

    public void save(Order order) {
        orders.add(order);
    }



}
