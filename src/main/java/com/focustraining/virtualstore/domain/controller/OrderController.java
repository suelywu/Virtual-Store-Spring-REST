package com.focustraining.virtualstore.domain.controller;

import com.focustraining.virtualstore.domain.model.entity.Client;
import com.focustraining.virtualstore.domain.model.entity.Order;
import com.focustraining.virtualstore.domain.model.valueObject.ProductHolder;
import com.focustraining.virtualstore.domain.model.valueObject.payment.Payment;
import com.focustraining.virtualstore.domain.repository.ClientRepository;
import com.focustraining.virtualstore.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<Order> getAllClients() {
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "/clients/{id}/orders", method = RequestMethod.GET)
    public List<Order> getClientOrders(@PathVariable int id) {
        return orderService.getOrdersByClientId(id);
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public Order getOrder(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @RequestMapping(value = "/hasOrder", method = RequestMethod.GET)
    public boolean hasOrder(@RequestParam int id) {
        return orderService.hasOrderById(id);
    }

    @RequestMapping(value = "/clients/{clientId}/order", method = RequestMethod.POST)
    public void addNewOrder(@PathVariable int clientId, @RequestBody List<ProductHolder> productHolders, @RequestBody Payment payment) {
        Client client = clientRepository.findById(clientId);
        int id = orderService.getNextIdToUse();
        new Order(id, client, productHolders, payment);
    }


}
