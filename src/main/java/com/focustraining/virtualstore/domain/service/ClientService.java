package com.focustraining.virtualstore.domain.service;

import com.focustraining.virtualstore.domain.model.entity.Client;
import com.focustraining.virtualstore.domain.model.entity.Order;
import com.focustraining.virtualstore.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClient(int id) {
        return clientRepository.findById(id);
    }

    public void addClient(Client client) {
        clientRepository.addClient(client);
    }

    public boolean existsClient(int id) {
        return clientRepository.existsById(id);
    }

    public void addOrder(Order order, int clientId) {
        getClient(clientId).addOrder(order);
    }

    public List<Order> getOrders(int clientId) {
        return getClient(clientId).getOrders();
    }

}
