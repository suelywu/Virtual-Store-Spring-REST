package com.focustraining.virtualstore.domain.service;

import com.focustraining.virtualstore.domain.model.entity.Client;
import com.focustraining.virtualstore.domain.model.entity.Order;
import com.focustraining.virtualstore.domain.model.entity.ShoppingCart;
import com.focustraining.virtualstore.domain.model.valueObject.ProductHolder;
import com.focustraining.virtualstore.domain.model.valueObject.payment.Payment;
import com.focustraining.virtualstore.domain.repository.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFinishService {

    private final StoreService storeService;
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public OrderFinishService(StoreService storeService, OrderService orderService, ShoppingCartService shoppingCartService) {
        this.storeService = storeService;
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
    }


    public void finish(Client client, Payment payment) {
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart();
        List<ProductHolder> productHolders = shoppingCart.getProductHolders();
        int id = orderService.getNextIdToUse();
        Order order = new Order(id, client, productHolders, payment);
        orderService.addOrderToRepository(order);
        client.addOrder(order);
        shoppingCart.clear();
        productHolders.forEach(storeService::removeFromStore);


    }


}
