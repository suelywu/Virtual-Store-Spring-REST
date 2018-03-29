package com.focustraining.virtualstore.domain.repository;

import com.focustraining.virtualstore.domain.model.entity.Client;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Component
public class ClientRepository {

    private List<Client> clients;

    public ClientRepository() {
        clients = new LinkedList<>();
        defaultClientRepositoryClients();
    }

    public List<Client> findAll() {
        return Collections.unmodifiableList(clients);
    }

    public Client findById(int id) {
        return clients.stream().filter(c -> c.equals(id)).findFirst().orElse(new Client(0, ""));
    }

    public void deleteById(int id) {
        clients.removeIf(c -> c.equals(id));
    }

    public boolean existsById(int id) {
        return clients.stream().anyMatch(c -> c.equals(id));
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    private void defaultClientRepositoryClients() {
        clients.add(new Client(1, "Ana"));
        clients.add(new Client(2, "Bianca"));
    }

}
