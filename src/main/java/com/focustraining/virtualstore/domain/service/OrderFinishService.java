package com.focustraining.virtualstore.domain.service;

import com.focustraining.virtualstore.domain.model.entity.Client;
import com.focustraining.virtualstore.domain.model.entity.Order;
import com.focustraining.virtualstore.domain.model.entity.ShoppingCart;
import com.focustraining.virtualstore.domain.model.valueObject.ProductHolder;
import com.focustraining.virtualstore.domain.model.valueObject.payment.Payment;
import com.focustraining.virtualstore.domain.repository.ClientRepository;
import com.focustraining.virtualstore.domain.repository.OrderRepository;
import com.focustraining.virtualstore.domain.repository.ShoppingCartRepository;
import com.focustraining.virtualstore.domain.repository.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFinishService {

    private Store store;
    private OrderRepository orderRepository;
    private ClientRepository clientRepository;
    private ShoppingCartRepository shoppingCartRepository;

    public void finish(int clientId, Payment payment) {
        ShoppingCart shoppingCart = shoppingCartRepository.getShoppingCart();
        List<ProductHolder> productHolders = shoppingCart.getProductHolders();
        int orderId = orderRepository.getNextIdToUse();
        Client client = clientRepository.findById(clientId);

        Order order = new Order(orderId, client, productHolders, payment);



    }



    public void finalize(ShoppingCart shoppingCart, Client client, Payment payment, Store store) {
        List<ProductHolder> productHolders = shoppingCart.getProductHolders();
        int id = lastId();



    }
    public Order(int id, Client client, List<ProductHolder> productHolders, Payment payment) {


}
