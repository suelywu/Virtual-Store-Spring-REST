package com.focustraining.virtualstore.domain.service;

import com.focustraining.virtualstore.domain.model.entity.Order;
import com.focustraining.virtualstore.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByClientId(int clientId) {
        return orderRepository.findByClientId(clientId);
    }

    public Order getOrderById(int id) {
        return orderRepository.findById(id);
    }

    public boolean hasOrderById(int id) {
        return orderRepository.existById(id);
    }

    public int getNextIdToUse() {
        return orderRepository.getNextIdToUse();
    }

    public void addOrderToRepository(Order order) {
        orderRepository.save(order);
    }
}
